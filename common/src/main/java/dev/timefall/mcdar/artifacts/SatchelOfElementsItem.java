package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.List;

public class SatchelOfElementsItem extends ArtifactStatusInflictingItem{
    public SatchelOfElementsItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getDurability()
        );
    }

    @Override
    public ActionResult useOnBlock (ItemUsageContext context) {
        if (context.getPlayer() != null && context.getPlayer().getWorld().getServer() != null) {
            ServerPlayerEntity user = context.getPlayer().getWorld().getServer().getPlayerManager().getPlayer(context.getPlayer().getUuid());
            if (user != null) {
                Hand hand = user.getActiveHand();
                ItemStack itemStack = user.getStackInHand(hand);
                int experienceDrain = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getInnerStat().mcdar$getExperienceDrain();
                float damage = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getInnerStat().mcdar$getDamageOrHealingFactor();
                float range = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getInnerStat().mcdar$getRange();
                int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getInnerStat().mcdar$getDuration();
                int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
                int amplifier2 = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SHOCK_POWDER_STATS.mcdar$getInnerStat().mcdar$getAmplifier2();
                int amplifier3 = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SHOCK_POWDER_STATS.mcdar$getInnerStat().mcdar$getAmplifier3();
                int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().SATCHEL_OF_ELEMENTS_STATS.mcdar$getMaxCooldownEnchantmentTime();
                int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, user.getWorld());

                if (user.totalExperience >= experienceDrain || user.isCreative()) {
                    AOEHelper.satchelOfElementsEffects(user, damage, range, duration, amplifier, amplifier2, amplifier3);

                    if (!user.isCreative()) {
                        user.addExperience(-experienceDrain);
                        EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemStack.damage(1, user, equipmentSlot);
                    }
                    EnchantmentEffects.mcdar$cooldownHelper(
                            user,
                            this,
                            modifiedCooldownEnchantmentTime
                    );
                    return ActionResult.CONSUME;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
