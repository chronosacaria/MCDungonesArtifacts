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

public class DeathCapMushroomItem extends ArtifactAgilityItem{
    public DeathCapMushroomItem() {
        super(
                AgilityArtifactID.DEATH_CAP_MUSHROOM,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand) {
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int amplifier2 = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getAmplifier2();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getMaxCooldownEnchantmentTime();

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                maxCooldownEnchantmentTime,
                StatusEffects.HASTE,
                duration,
                amplifier,
                StatusEffects.SPEED,
                duration,
                amplifier2,
                null,
                null,
                null);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type) {
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
