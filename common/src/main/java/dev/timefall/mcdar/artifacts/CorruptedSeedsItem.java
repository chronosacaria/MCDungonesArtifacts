package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.StatusInflictingArtifactID;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class CorruptedSeedsItem extends ArtifactStatusInflictingItem{
    public CorruptedSeedsItem() {
        super(
                StatusInflictingArtifactID.CORRUPTED_SEEDS,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use (World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        float range = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getInnerStat().mcdar$getRange();
        int duration = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getInnerStat().mcdar$getDuration();
        int amplifier = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getInnerStat().mcdar$getAmplifier();
        int amplifier2 = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getInnerStat().mcdar$getAmplifier2();
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getStatusInflictingArtifactStats().CORRUPTED_SEEDS_STATS.mcdar$getMaxCooldownEnchantmentTime();

        AOEHelper.afflictNearbyEntities(user,range, new StatusEffectInstance(StatusEffects.SLOWNESS, duration, amplifier),
                new StatusEffectInstance(StatusEffects.POISON, duration, amplifier2));

        if (!user.isCreative()){
            EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.damage(1, user, equipmentSlot);
        }


        user.getItemCooldownManager().set(this, maxCooldownEnchantmentTime);

        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type) {
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
