package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.AgilityArtifactID;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class BootsOfSwiftnessItem extends ArtifactAgilityItem{
    public BootsOfSwiftnessItem() {
        super(
                AgilityArtifactID.BOOTS_OF_SWIFTNESS,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().BOOTS_OF_SWIFTNESS_STATS.mcdar$getMaxCooldownEnchantmentTime();

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                maxCooldownEnchantmentTime,
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
