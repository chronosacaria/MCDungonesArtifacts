package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class GhostCloakItem extends ArtifactAgilityItem{
    public GhostCloakItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){

        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int amplifier2 = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getInnerStat().mcdar$getAmplifier2();
        int amplifier3 = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getInnerStat().mcdar$getAmplifier3();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().GHOST_CLOAK_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, world);

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                modifiedCooldownEnchantmentTime,
                StatusEffects.INVISIBILITY,
                duration,
                amplifier,
                StatusEffects.RESISTANCE,
                duration,
                amplifier2,
                StatusEffects.SPEED,
                duration,
                amplifier3
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
