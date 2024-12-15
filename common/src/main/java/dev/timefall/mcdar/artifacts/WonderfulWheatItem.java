package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.artifacts.artifact_types.ArtifactSummoningItem;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import dev.timefall.mcdar.entity.SummonedEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.util.List;

public class WonderfulWheatItem extends ArtifactSummoningItem {
    public WonderfulWheatItem() {
        super(McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().WONDERFUL_WHEAT_STATS);
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().WONDERFUL_WHEAT_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, itemUsageContext.getPlayer(), itemUsageContext.getWorld());

        return CleanlinessHelper.mcdar$cleanUseSummon(
                itemUsageContext,
                this,
                SummonedEntityType.WONDERFUL_WHEAT_LLAMA_ENTITY,
                modifiedCooldownEnchantmentTime
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
