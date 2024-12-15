package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.artifacts.artifact_types.ArtifactAgilityItem;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class BootsOfSwiftnessItem extends ArtifactAgilityItem {
    public BootsOfSwiftnessItem() {
        super(McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, world);

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                modifiedCooldownEnchantmentTime,
                StatusEffects.SPEED,
                duration,
                amplifier,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
