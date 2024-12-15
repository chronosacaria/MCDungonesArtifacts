package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOECloudHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.artifacts.artifact_types.ArtifactDefensiveItem;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
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

public class TotemOfShieldingItem extends ArtifactDefensiveItem {
    public TotemOfShieldingItem() {
        super(McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS);
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        float cloudRadius = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS.mcdar$getCloudRadius();
        int cloudDuration = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS.mcdar$getCloudDuration();
        int effectDuration = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS.mcdar$getEffectDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS.mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().TOTEM_OF_SHIELDING_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, itemUsageContext.getPlayer(), itemUsageContext.getWorld());

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
                                StatusEffectRegistry.SHIELDING.getEntry(),
                                effectDuration,
                                amplifier
                        )
                );

                if (!itemUsageContextPlayer.isCreative()) {
                    Hand hand = itemUsageContext.getHand();
                    EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                    itemUsageContext.getStack().damage(1, itemUsageContextPlayer, equipmentSlot);
                }

                EnchantmentEffects.mcdar$cooldownHelper(
                        itemUsageContextPlayer,
                        this,
                        modifiedCooldownEnchantmentTime
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
