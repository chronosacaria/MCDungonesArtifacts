package dev.timefall.mcdar.event;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effect.ArtifactEffects;
import dev.timefall.mcdar.effect.EnchantmentEffects;
import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;

public class McdarFabricEvents {
    public static void registerEvents() {

        // Activeates Beast Burst and/or Beast Surge upon consumption of a valid potion; mcdar$playerFinishPotionEvent
        UseItemCallback.EVENT.register((playerEntity, world, hand) -> {
            if(world instanceof ServerWorld serverWorld) {
                EnchantmentEffects.activateBeastBurst(playerEntity, serverWorld);
                EnchantmentEffects.activateBeastSurge(playerEntity, serverWorld);
            }
            return TypedActionResult.pass(ItemStack.EMPTY);
        });

        // Spawns an explosion at the position of target killed with PowerShaker in the offhand; mcdar$onPowershakerExplodingKill
        ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
            if (!(damageSource.getAttacker() instanceof PlayerEntity playerEntity)) return;

            if (McdarArtifactsStatsConfig.CONFIG.mcdar$getDamagingArtifactStats().POWERSHAKER_STATS.mcdar$getIsEnabled())
                ArtifactEffects.mcdar$activatePowerShaker(playerEntity, livingEntity);
        });

        // Prevents use of items via right click; mcdar$stunnedStatusPreventItemUsage
        UseItemCallback.EVENT.register(((player, world, hand) -> {
            if (player.hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
                return TypedActionResult.fail(ItemStack.EMPTY);
            }
            return TypedActionResult.pass(ItemStack.EMPTY);
        }));

        // Prevents use of items via left click on entities; mcdar$stunnedStatusPreventAttackEntityBlock
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (player.hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });

        // Prevents use of items via left click on blocks; mcdar$stunnedStatusPreventAttackBlock
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (player.hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())) {
                return ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
