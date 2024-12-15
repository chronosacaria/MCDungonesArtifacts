package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AbilityHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.artifacts.artifact_types.ArtifactDefensiveItem;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class SatchelOfSnacksItem extends ArtifactDefensiveItem {
    public SatchelOfSnacksItem() {
        super(McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().SATCHEL_OF_SNACKS_STATS);
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().SATCHEL_OF_SNACKS_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, world);

        Item snackToDrop =
                AbilityHelper.SATCHEL_OF_SNACKS_LIST.get(user.getRandom().nextInt(AbilityHelper.SATCHEL_OF_SNACKS_LIST.size()));

        CleanlinessHelper.mcdar$dropItem(user, snackToDrop);

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

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}