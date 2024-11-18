package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import dev.timefall.mcdar.entities.SummonedEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.util.List;

public class GolemKitItem extends ArtifactSummoningItem{
    public GolemKitItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().GOLEM_KIT_STATS.mcdar$getDurability()
        );
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().GOLEM_KIT_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, itemUsageContext.getPlayer(), itemUsageContext.getWorld());

        return CleanlinessHelper.mcdar$cleanUseSummon(
                itemUsageContext,
                this,
                SummonedEntityType.GOLEM_KIT_GOLEM_ENTITY,
                modifiedCooldownEnchantmentTime
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
