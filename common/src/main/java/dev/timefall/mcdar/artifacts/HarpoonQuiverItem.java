package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.QuiverArtifactID;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class HarpoonQuiverItem extends ArtifactQuiverItem{
    public HarpoonQuiverItem() {
        super(
                QuiverArtifactID.HARPOON_QUIVER,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().HARPOON_QUIVER_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                null,
                null,
                null,
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
