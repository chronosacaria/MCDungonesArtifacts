package dev.timefall.mcdar.api;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AbilityHelper {

    public static boolean isPetOf(LivingEntity self, LivingEntity owner){
        if (self instanceof Tameable tameable) {
            return tameable.getOwner() == owner;
        }
        return false;
    }

    //also could be a tag
    private static boolean isVillagerOrIronGolem(LivingEntity nearbyEntity) {
        return (nearbyEntity instanceof VillagerEntity) || (nearbyEntity instanceof IronGolemEntity);
    }

    public static boolean canHealEntity(LivingEntity healer, LivingEntity nearbyEntity){
        return nearbyEntity != healer
                && isAllyOf(healer, nearbyEntity)
                && nearbyEntity.isAlive()
                && healer.canSee(nearbyEntity);
    }

    private static boolean isAllyOf(LivingEntity self, LivingEntity other) {
        return self.isTeammate(other)
                || isPetOf(self, other)
                || isVillagerOrIronGolem(other);
    }

    public static boolean isAoeTarget(LivingEntity self, LivingEntity attacker, LivingEntity center) {
        return self != attacker
                && self.isAlive()
                && !isAllyOf(attacker, self)
                && !isUnaffectedByAoe(self)
                && center.canSee(self);
    }

    private static boolean isUnaffectedByAoe(LivingEntity entity) {
        if (entity instanceof PlayerEntity)
            return ((PlayerEntity) entity).isCreative();
        return false;
    }

    //Recommend making into a tag
    public static final List<ItemStack> SATCHEL_OF_ELIXIRS_LIST = List.of(
            PotionContentsComponent.createStack(Items.POTION, Potions.STRENGTH),
            PotionContentsComponent.createStack(Items.POTION, Potions.SWIFTNESS),
            PotionContentsComponent.createStack(Items.POTION, Potions.INVISIBILITY));

    //recommend making into a tag
    public static final List<Item> SATCHEL_OF_SNACKS_LIST = Collections.unmodifiableList(Arrays.asList(
            Items.APPLE, Items.BREAD, Items.COOKED_SALMON, Items.COOKED_PORKCHOP, Items.COOKED_MUTTON,
            Items.COOKED_COD, Items.COOKED_COD, Items.COOKED_RABBIT, Items.COOKED_CHICKEN, Items.COOKED_BEEF,
            Items.MELON_SLICE, Items.CARROT, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.BAKED_POTATO));

    public static final List<Item> TOME_OF_DUPLICATION_LIST = Collections.unmodifiableList(Arrays.asList(
            Items.APPLE, Items.BREAD, Items.COOKED_SALMON, Items.COOKED_PORKCHOP, Items.COOKED_MUTTON,
            Items.COOKED_COD, Items.COOKED_COD, Items.COOKED_RABBIT, Items.COOKED_CHICKEN, Items.COOKED_BEEF,
            Items.MELON_SLICE, Items.CARROT, Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.BAKED_POTATO, Items.TNT,
            PotionContentsComponent.createStack(Items.POTION, Potions.STRENGTH).getItem(),
            PotionContentsComponent.createStack(Items.POTION, Potions.SWIFTNESS).getItem(),
            PotionContentsComponent.createStack(Items.POTION, Potions.INVISIBILITY).getItem()));
}
