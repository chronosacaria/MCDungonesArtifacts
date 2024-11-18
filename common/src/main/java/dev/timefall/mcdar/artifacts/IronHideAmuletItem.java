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

public class IronHideAmuletItem extends ArtifactDefensiveItem{
    public IronHideAmuletItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().IRON_HIDE_AMULET_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().IRON_HIDE_AMULET_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().IRON_HIDE_AMULET_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().IRON_HIDE_AMULET_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, user, world);

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                modifiedCooldownEnchantmentTime,
                StatusEffects.RESISTANCE,
                duration,
                amplifier,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
