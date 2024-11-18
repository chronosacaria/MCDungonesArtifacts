package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
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

public class TormentQuiverItem extends ArtifactQuiverItem{
    public TormentQuiverItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().TORMENT_QUIVER_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().TORMENT_QUIVER_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffectForQuivers(maxCooldownEnchantmentTime, user, world);

        if (user.totalExperience >= 20 || user.isCreative()){

            EnchantmentEffects.mcdar$cooldownHelper(
                    user,
                    this,
                    modifiedCooldownEnchantmentTime
            );

            //int cooldownLevel = EnchantmentEffects.getLevel(EnchantmentRegistry.COOLDOWN, user, user.getWorld());
            //user.getItemCooldownManager().set(
            //        this,
            //        (cooldownLevel + 1) * modifiedCooldownEnchantmentTime
            //);

            if (!user.isCreative()) {
                user.addExperience(-20);
                EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                itemStack.damage(1, user, equipmentSlot);
            }
        }
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}