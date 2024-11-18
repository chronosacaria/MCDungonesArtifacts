package dev.timefall.mcdar.mixin;

import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
    public void onPlayerAttackWhilstStunnedTarget(Entity target, CallbackInfo ci) {
        if (((PlayerEntity) (Object) this).hasStatusEffect(RegistryEntry.of(StatusEffectRegistry.STUNNED))){
            ci.cancel();
        }
    }

    @Inject(method = "tickMovement", at = @At("HEAD"), cancellable = true)
    public void onPlayerMovementWhilstStunnedTarget(CallbackInfo ci) {
        if (((PlayerEntity) (Object) this).hasStatusEffect(RegistryEntry.of(StatusEffectRegistry.STUNNED))){
            ci.cancel();
        }
    }
}
