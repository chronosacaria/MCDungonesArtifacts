package dev.timefall.mcdar.event;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.ArtifactEffects;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class McdarForgeEventHandler {
    public static void mcdar$playerFinishPotionEvent(LivingEntityUseItemEvent.Finish event) {
        World world = event.getEntity().getWorld();
        LivingEntity livingEntity = event.getEntity();
        if (world instanceof ServerWorld serverWorld && livingEntity instanceof PlayerEntity playerEntity) {
            EnchantmentEffects.activateBeastBurst(playerEntity, serverWorld);
            EnchantmentEffects.activateBeastSurge(playerEntity, serverWorld);
        }
    }

    public static void mcdar$onPowershakerExplodingKill(LivingDeathEvent event) {
        if (!(event.getSource().getAttacker() instanceof PlayerEntity playerEntity)) return;

        if (McdarArtifactsStatsConfig.CONFIG.mcdar$getDamagingArtifactStats().POWERSHAKER_STATS.mcdar$getIsEnabled())
            ArtifactEffects.mcdar$activatePowerShaker(playerEntity, event.getEntity());
    }

    public static void mcdar$stunnedStatusPreventItemUsage(LivingEntityUseItemEvent.Start event) {
        if (event.getEntity().hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
            event.setCanceled(true);
        }
    }

    public static void mcdar$stunnedStatusPreventAttackEntityBlock(AttackEntityEvent event) {
        if (event.getEntity().hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
            event.setCanceled(true);
        }
    }

    public static void mcdar$stunnedStatusPreventAttackBlock(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getEntity().hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
            event.setCanceled(true);
        }
    }
}
