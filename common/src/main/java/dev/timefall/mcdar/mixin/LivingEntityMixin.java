package dev.timefall.mcdar.mixin;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.ArtifactEffects;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import dev.timefall.mcdar.enchants.EnchantmentsID;
import dev.timefall.mcdar.registries.StatusEffectRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("ConstantConditions")
@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    public void onSoulProtectionDeath(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        if (livingEntity.hasStatusEffect(RegistryEntry.of(StatusEffectRegistry.SOUL_PROTECTION))) {
            livingEntity.setHealth(1.0F);
            livingEntity.clearStatusEffects();
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 900, 1));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100, 1));

            cir.setReturnValue(true);
        }
    }

    @Inject(method = "swingHand(Lnet/minecraft/util/Hand;)V", at = @At("HEAD"), cancellable = true)
    public void onAttackWhilstStunnedNoTarget(Hand hand, CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        if (livingEntity.hasStatusEffect(RegistryEntry.of(StatusEffectRegistry.STUNNED))) {
            ci.cancel();
        }
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    public void onPowershakerExplodingKill(DamageSource source, CallbackInfo ci) {
        if (!(source.getAttacker() instanceof PlayerEntity player)) return;

        LivingEntity target = (LivingEntity) (Object) this;

        if (McdarArtifactsStatsConfig.CONFIG.mcdar$getDamagingArtifactStats().POWERSHAKER_STATS.mcdar$getIsEnabled())
            ArtifactEffects.activatePowerShaker(player, target);
    }

    @ModifyVariable(method = "damage", at = @At(value = "HEAD"), argsOnly = true)
    public float mcdar$damageModifiers(float amount, DamageSource source) {
        if (source.getSource() instanceof Tameable summonedEntity) {
            if (source.getSource().getWorld() instanceof ServerWorld serverWorld) {

                if (McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BOSS).mcdar$getIsEnabled())
                    amount *= EnchantmentEffects.beastBossDamage(summonedEntity, serverWorld);

            }
        }
        return amount;
    }

    @Inject(method = "consumeItem", at = @At("HEAD"))
    public void mcdar$onConsume(CallbackInfo ci) {

        if (!((Object) this instanceof PlayerEntity player)) return;

        if (player.isAlive() && player.getWorld() instanceof ServerWorld) {

            if (McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsEnabled())
                EnchantmentEffects.activateBeastBurst(player);
            if (McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_SURGE).mcdar$getIsEnabled())
                EnchantmentEffects.activateBeastSurge(player);
        }
    }
}