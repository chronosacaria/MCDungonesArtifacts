package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.AbilityHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.api.McdarEnchantmentHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.AgilityArtifactID;
import dev.timefall.mcdar.registries.StatusEffectRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class LightFeatherItem extends ArtifactAgilityItem{
    public LightFeatherItem() {
        super(
                AgilityArtifactID.LIGHT_FEATHER,
                McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().LIGHT_FEATHER_STATS.mcdar$getDurability()
        );
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        user.jump();

        for (LivingEntity nearbyEntity : AOEHelper.getEntitiesByPredicate(user, 5,
                (nearbyEntity) -> nearbyEntity != user && !AbilityHelper.isPetOf(nearbyEntity, user) && nearbyEntity.isAlive())) {
            AOEHelper.knockbackNearbyEnemies(user, nearbyEntity, 5.0F);

            nearbyEntity.addStatusEffect(
                    new StatusEffectInstance(
                            RegistryEntry.of(StatusEffectRegistry.STUNNED),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getDuration(),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getAmplifier()
                    ));
            nearbyEntity.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.NAUSEA,
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getDuration(),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getAmplifier2()
                    ));
            nearbyEntity.addStatusEffect(
                    new StatusEffectInstance(
                            StatusEffects.SLOWNESS,
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getDuration(),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getAgilityArtifactStats().DEATH_CAP_MUSHROOM_STATS.mcdar$getInnerStat().mcdar$getAmplifier3()
                    ));
        }

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
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type) {
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
