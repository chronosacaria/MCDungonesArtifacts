package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.entities.SummonedEntityType;
import dev.timefall.mcdar.enums.SummoningArtifactID;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.util.List;

public class TastyBoneItem extends ArtifactSummoningItem{
    public TastyBoneItem() {
        super(
                SummoningArtifactID.TASTY_BONE,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().TASTY_BONE_STATS.mcdar$getDurability()
        );
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext) {
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().TASTY_BONE_STATS.mcdar$getMaxCooldownEnchantmentTime();

        return CleanlinessHelper.mcdar$cleanUseSummon(
                itemUsageContext,
                this,
                SummonedEntityType.TASTY_BONE_WOLF_ENTITY,
                maxCooldownEnchantmentTime
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
