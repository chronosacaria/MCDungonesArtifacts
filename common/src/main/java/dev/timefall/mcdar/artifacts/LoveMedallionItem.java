package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.AbilityHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class LoveMedallionItem extends ArtifactStatusInflictingItem {
    public LoveMedallionItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().LOVE_MEDALLION_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        float range = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().LOVE_MEDALLION_STATS.mcdar$getInnerStat().mcdar$getRange();
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().LOVE_MEDALLION_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().LOVE_MEDALLION_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().LOVE_MEDALLION_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, world);

        int i = 0;

        for (LivingEntity entitiesByPredicate : AOEHelper.getEntitiesByPredicate(MobEntity.class, user, range,
                (nearbyEntity) -> AbilityHelper.isAoeTarget(nearbyEntity, user, user))) {
            sendIntoWildRage(entitiesByPredicate, duration, amplifier);
            i++;
            if (i >= 3)
                break;
        }

        if (!user.isCreative()){
            EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.damage(1, user, equipmentSlot);
        }

        EnchantmentEffects.mcdar$cooldownHelper(
                user,
                this,
                modifiedCooldownEnchantmentTime
        );

        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    public static void sendIntoWildRage(LivingEntity mobEntity, int duration, int amplifier) {
        boolean bl = false;
        try {
            mobEntity.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        } catch (IllegalArgumentException e) {
            bl = true;
        }
        if (!(bl || mobEntity instanceof WitherEntity || mobEntity instanceof EnderDragonEntity || mobEntity instanceof AmbientEntity))
            mobEntity.addStatusEffect(new StatusEffectInstance(RegistryEntry.of(StatusEffectRegistry.CHARMED), duration, amplifier));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }

}

/*
3 nearby mobs give off heart particles, become allies for 10 seconds, then die

// Abridged
3 mobs within 6 radius are afflicted with wild rage for 10 seconds as is in mcdw
 */