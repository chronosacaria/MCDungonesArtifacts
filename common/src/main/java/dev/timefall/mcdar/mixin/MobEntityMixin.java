package dev.timefall.mcdar.mixin;

import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {
    @Inject(method = "isAiDisabled", at = @At("HEAD"), cancellable = true)
    public void onStunnedMob(CallbackInfoReturnable<Boolean> cir){
        if (((MobEntity) (Object) this).hasStatusEffect(StatusEffectRegistry.STUNNED.getEntry())){
            cir.setReturnValue(true);
        }
    }
}
