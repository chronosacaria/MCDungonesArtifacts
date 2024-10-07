package dev.timefall.mcdar.effects;

import dev.timefall.mcdar.api.AOECloudHelper;
import dev.timefall.mcdar.api.AOEHelper;
import dev.timefall.mcdar.api.AbilityHelper;
import dev.timefall.mcdar.api.CleanlinessHelper;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;

import java.util.List;
import java.util.UUID;

public class EnchantmentEffects {

    public static float beastBossDamage(Tameable summonedEntity, ServerWorld serverWorld) {
        if (summonedEntity.getOwner() != null) {
            UUID summonerUUID = summonedEntity.getOwnerUuid();
            if (summonerUUID != null) {
                Entity beastOwner = serverWorld.getEntity(summonerUUID);
                if (beastOwner instanceof LivingEntity beastOwnerAsLiving) {
                    int beastBossLevel = 0;
                            EnchantmentHelper.getEquipmentLevel(RegistryEntry.of(EnchantsRegistry.BEAST_BOSS),
                                    beastOwnerAsLiving);
                    if (beastBossLevel > 0) {
                        return 1.1F + (0.1F * beastBossLevel);
                    }
                }
            }
        }
        return 1f;
    }

    public static void activateBeastBurst(PlayerEntity player) {
        float explosionRadius = 3.0f;
        List<StatusEffectInstance> potionEffects = PotionContentsComponent.DEFAULT.customEffects();
        if (potionEffects.isEmpty()) return;
        if (potionEffects.get(0).getEffectType() == StatusEffects.INSTANT_HEALTH){
            int beastBurstLevel = 0;
                    /*EnchantmentHelper.getEquipmentLevel(RegistryEntry.of(EnchantsRegistry.BEAST_BURST),
                            player);*/
            if (beastBurstLevel > 0){
                for (LivingEntity summonedMob : AOEHelper.getEntitiesByPredicate(player, 10,
                        (nearbyEntity) -> AbilityHelper.isPetOf(nearbyEntity, player))) {
                    if (summonedMob == null) continue;
                    CleanlinessHelper.playCenteredSound(summonedMob, SoundEvents.ENTITY_GENERIC_EXPLODE.value(), 0.5F, 1.0F);
                    AOECloudHelper.spawnExplosionCloud(summonedMob, summonedMob, explosionRadius);
                    AOEHelper.causeExplosion(player, summonedMob, 3 * beastBurstLevel, explosionRadius);
                }
            }
        }
    }

    public static void activateBeastSurge(PlayerEntity player) {
        List<StatusEffectInstance> potionEffects = PotionContentsComponent.DEFAULT.customEffects();
        if (potionEffects.isEmpty()) return;
        if (potionEffects.get(0).getEffectType().equals(StatusEffects.INSTANT_HEALTH)) {
            int beastSurgeLevel =0;
                    /*EnchantmentHelper.getEquipmentLevel(RegistryEntry.of(EnchantsRegistry.BEAST_SURGE),
                            player);
                     */
            if (beastSurgeLevel > 0) {
                AOEHelper.afflictNearbyEntities(LivingEntity.class, player, 10,
                        (nearbyEntity) -> AbilityHelper.isPetOf(nearbyEntity, player),
                        new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, (beastSurgeLevel * 3) - 1),
                        new StatusEffectInstance(StatusEffects.STRENGTH, 10 * 20, (beastSurgeLevel * 3) - 1));
            }
        }
    }
}
