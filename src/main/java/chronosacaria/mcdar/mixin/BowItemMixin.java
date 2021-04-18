package chronosacaria.mcdar.mixin;

import chronosacaria.mcdar.api.ProjectileEffectHelper;
import chronosacaria.mcdar.init.ArtefactsInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public abstract class BowItemMixin {
    @Shadow public abstract void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks);

    @Inject(method = "onStoppedUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile" +
            "/PersistentProjectileEntity;setProperties(Lnet/minecraft/entity/Entity;FFFFF)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    public void onFlamingQuiverArrowLoosing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks,
                                            CallbackInfo ci, PlayerEntity playerEntity, boolean bl,
                                            ItemStack itemStack, int i, float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity){
        ItemStack offhand = user.getOffHandStack();
        if (user instanceof PlayerEntity && offhand.getItem() == ArtefactsInit.FLAMING_QUIVER.asItem()){
            float effectTimer = playerEntity.getItemCooldownManager().getCooldownProgress(offhand.getItem(), 0);
            if (effectTimer > 0){
                ProjectileEffectHelper.flamingQuiverArrow(persistentProjectileEntity);
            }
        }
    }
}