package dev.timefall.mcdar.mixin;

import dev.timefall.mcdar.effect.EnchantmentEffects;
import dev.timefall.mcdar.registry.StatusEffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("ConstantConditions")
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    public void onSoulProtectionDeath(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        if (livingEntity.hasStatusEffect(StatusEffectRegistry.SOUL_PROTECTION.getEntry())) {
            livingEntity.setHealth(1.0F);
            livingEntity.clearStatusEffects();
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 900, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));

            cir.setReturnValue(true);
        }
    }

    @ModifyVariable(method = "damage", at = @At(value = "HEAD"), argsOnly = true)
    public float mcdar$damageModifiers(float amount, DamageSource source) {
        if (source.getSource() instanceof Tameable summonedEntity) {
            if (source.getSource().getWorld() instanceof ServerWorld serverWorld) {
                amount *= EnchantmentEffects.beastBossDamage(summonedEntity, serverWorld);
            }
        }
        return amount;
    }
}