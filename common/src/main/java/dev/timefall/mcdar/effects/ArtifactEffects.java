package dev.timefall.mcdar.effects;

import dev.timefall.mcdar.api.AOECloudHelper;
import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.AbilityHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.registries.ArtifactsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;

public class ArtifactEffects {
    private static final float EXPLOSION_RADIUS = 3.0F;

    public static void activatePowerShaker(PlayerEntity player, LivingEntity target) {
        // Temporary way to stop crash with Industrial Revolution Slaughter Block
        if (player.getName().toString().equals("slaughter")) {
            return;
        }

        ItemStack offhand = player.getOffHandStack();
        if (target != null && offhand.getItem() == ArtifactsRegistry.POWERSHAKER) {
            if (CleanlinessHelper.isCoolingDown(player, offhand.getItem()) && CleanlinessHelper.percentToOccur(20)) {
                CleanlinessHelper.playCenteredSound(target, SoundEvents.ENTITY_GENERIC_EXPLODE.value(), 0.5F, 1.0F);
                AOECloudHelper.spawnExplosionCloud(player, target, EXPLOSION_RADIUS);
                AOEHelper.affectNearbyEntities(player, 3.0f,
                        (nearbyEntity) -> AbilityHelper.isAoeTarget(nearbyEntity, player, target),
                        livingEntity -> AOEHelper.causeExplosion(player, target, target.getMaxHealth() * 0.2F, EXPLOSION_RADIUS)
                );
            }
        }
    }

    public static void causeBlastFungusExplosions(LivingEntity user, float distance, float damageAmount) {
        AOEHelper.affectNearbyEntities(user, distance,
                (nearbyEntity) -> AbilityHelper.isAoeTarget(nearbyEntity, user, nearbyEntity),
                livingEntity -> {
                    if (!(livingEntity instanceof PlayerEntity playerEntity && playerEntity.getAbilities().creativeMode)) {
                        AOECloudHelper.spawnExplosionCloud(user, livingEntity, EXPLOSION_RADIUS);
                        AOEHelper.causeExplosion(user, livingEntity, damageAmount, distance);
                    }
                }
        );
    }

    public static void enchantersTomeEffects(PlayerEntity user) {
        for (LivingEntity nearbyEntity : AOEHelper.getEntitiesByPredicate(user, McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().ENCHANTERS_TOME_STATS.mcdar$getInnerStat().mcdar$getRange(),
                (nearbyEntity) -> AbilityHelper.isPetOf(nearbyEntity, user))){
            StatusEffect[] statuses = {StatusEffects.HASTE.value(), StatusEffects.STRENGTH.value(), StatusEffects.SPEED.value()};
            StatusEffectInstance statusEffectInstance =
                    new StatusEffectInstance(RegistryEntry.of(
                            statuses[CleanlinessHelper.RANDOM.nextInt(statuses.length)]),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().ENCHANTERS_TOME_STATS.mcdar$getInnerStat().mcdar$getDuration(),
                            McdarArtifactsStatsConfig.CONFIG.mcdar$getDefensiveArtifactStats().ENCHANTERS_TOME_STATS.mcdar$getInnerStat().mcdar$getAmplifier()
                    );
            nearbyEntity.addStatusEffect(statusEffectInstance);
        }
    }

    public static void updraftNearbyEnemies(PlayerEntity user) {
        for (LivingEntity nearbyEntity : AOEHelper.getEntitiesByPredicate(user, 5,
                (nearbyEntity) -> nearbyEntity != user && !AbilityHelper.isPetOf(nearbyEntity, user) && nearbyEntity.isAlive())){
            nearbyEntity.setVelocity(0.0D, 1.25D, 0.0D);
        }
    }
}
