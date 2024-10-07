package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOECloudHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.api.McdarEnchantmentHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.DefensiveArtifactID;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TotemOfRegenerationItem extends ArtifactDefensiveItem{
    public TotemOfRegenerationItem() {
        super(
                DefensiveArtifactID.TOTEM_OF_REGENERATION,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getDurability()
        );
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext) {
        float cloudRadius = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getInnerStat().mcdar$getCloudRadius();
        int cloudDuration = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getInnerStat().mcdar$getCloudDuration();
        int effectDuration = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getInnerStat().mcdar$getEffectDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_REGENERATION_STATS.mcdar$getMaxCooldownEnchantmentTime();

        if (itemUsageContext.getWorld() instanceof ServerWorld serverWorld) {
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();
            BlockPos itemUseContextBlockPos = itemUsageContext.getBlockPos();

            BlockPos blockPos;
            if (serverWorld.getBlockState(itemUseContextBlockPos).getCollisionShape(serverWorld, itemUseContextBlockPos).isEmpty()){
                blockPos = itemUseContextBlockPos;
            } else {
                blockPos = itemUseContextBlockPos.offset(itemUsageContext.getHorizontalPlayerFacing());
            }
            if (itemUsageContextPlayer != null){

                AOECloudHelper.spawnStatusEffectCloud(
                        itemUsageContextPlayer,
                        blockPos,
                        cloudRadius,
                        cloudDuration,
                        new StatusEffectInstance(
                                StatusEffects.REGENERATION,
                                effectDuration,
                                amplifier));

                if (!itemUsageContextPlayer.isCreative()) {
                    Hand hand = itemUsageContext.getHand();
                    EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer, equipmentSlot);
                }

                McdarEnchantmentHelper.mcdar$cooldownHelper(
                        itemUsageContextPlayer,
                        this,
                        maxCooldownEnchantmentTime
                );
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
