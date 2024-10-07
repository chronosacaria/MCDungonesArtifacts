package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.api.McdarEnchantmentHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.DamagingArtifactID;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class LightningRodItem extends ArtifactDamagingItem{
    public LightningRodItem() {
        super(
                DamagingArtifactID.LIGHTNING_ROD,
                McdarArtifactsStatsConfig.CONFIG.DAMAGING_ARTIFACT_STATS
                        .get(DamagingArtifactID.LIGHTNING_ROD).mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (user.totalExperience >= 15 || user.isCreative()) {
            AOEHelper.electrocuteNearbyEnemies(user, 5, 5, Integer.MAX_VALUE);

            if (!user.isCreative()) {
                user.addExperience(-15);
                EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                itemStack.damage(1, user, equipmentSlot);
            }

            McdarEnchantmentHelper.mcdar$cooldownHelper(
                    user,
                    this
            );
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
