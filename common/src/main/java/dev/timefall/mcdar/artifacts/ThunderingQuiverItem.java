package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class ThunderingQuiverItem extends ArtifactQuiverItem{
    public ThunderingQuiverItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().THUNDERING_QUIVER_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().THUNDERING_QUIVER_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffectForQuivers(maxCooldownEnchantmentTime, user, world);

        return CleanlinessHelper.mcdar$cleanUseWithOptionalStatus(
                user,
                hand,
                this,
                modifiedCooldownEnchantmentTime,
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
