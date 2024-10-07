package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.api.McdarEnchantmentHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.ArtifactEffects;
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


public class UpdraftTomeItem extends ArtifactDamagingItem{
    public UpdraftTomeItem() {
        super(
                DamagingArtifactID.UPDRAFT_TOME,
                McdarArtifactsStatsConfig.CONFIG.DAMAGING_ARTIFACT_STATS
                        .get(DamagingArtifactID.UPDRAFT_TOME).mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);

        ArtifactEffects.updraftNearbyEnemies(user);
        if (!user.isCreative()){
            EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.damage(1, user, equipmentSlot);
        }

        McdarEnchantmentHelper.mcdar$cooldownHelper(
                user,
                this
        );

        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
