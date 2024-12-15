package dev.timefall.mcdar.mixin;

import dev.timefall.mcdar.api.ProjectileEffectHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.registry.ArtifactsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.BowItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public abstract class BowItemMixin {

    @Inject(method = "shoot", at = @At(value = "HEAD"))
    public void onFlamingQuiverArrowLoosing(LivingEntity shooter, ProjectileEntity projectile, int index, float speed, float divergence, float yaw, LivingEntity target, CallbackInfo ci){
        if (McdarArtifactsStatsConfig.CONFIG.mcdar$getQuiverArtifactStats().FLAMING_QUIVER_STATS.mcdar$getIsEnabled()){
            if (shooter.getOffHandStack().isOf(ArtifactsRegistry.FLAMING_QUIVER.get())) {
                if (shooter instanceof PlayerEntity playerEntity) {
                    float effectTimer = playerEntity.getItemCooldownManager().getCooldownProgress(shooter.getOffHandStack().getItem(), 0);
                    if (effectTimer > 0) {
                        ProjectileEffectHelper.flamingQuiverArrow((PersistentProjectileEntity) projectile);
                    }
                }
            }
        }
    }
}
