package dev.timefall.mcdar.api;

import dev.timefall.mcdar.api.interfaces.Summonable;
import dev.timefall.mcdar.entity.SummonedEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class SummoningHelper {

    public static final List<? extends EntityType<? extends SheepEntity>> SHEEP = Arrays.asList(
            SummonedEntityType.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY,
            SummonedEntityType.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY,
            SummonedEntityType.ENCHANTED_GRASS_RED_SHEEP_ENTITY);

    public static void mcdar$summonedSheepEffect(LivingEntity sheep, int effectInt) {
        switch (effectInt) {
            case 0 -> AOEHelper.afflictNearbyEntities(MobEntity.class, sheep, 5,
                    (nearbyEntity) -> nearbyEntity != sheep && nearbyEntity.isAlive(), new StatusEffectInstance(StatusEffects.POISON, 100, 4));
            case 1 -> AOEHelper.afflictNearbyEntities(PlayerEntity.class, sheep, 10,
                    LivingEntity::isAlive, new StatusEffectInstance(StatusEffects.SPEED, 600, 2));
            case 2 -> {
                for (LivingEntity nearbyEntity : AOEHelper.getEntitiesByPredicate(MobEntity.class, sheep, 5,
                        (nearbyEntity) -> nearbyEntity != sheep && nearbyEntity.isAlive())) {
                    nearbyEntity.setOnFireFor(5);
                }
            }
            default -> {}
        }
    }

    public static boolean mcdar$summonSummonableEntity(LivingEntity entityToSpawn, LivingEntity summoner, BlockPos blockPos) {
        World world = summoner.getWorld();

        if (entityToSpawn instanceof Summonable summonableEntity) {
            try {
                summonableEntity.setSummoner(summoner);
                entityToSpawn.refreshPositionAndAngles(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ(), 0, 0);
                world.spawnEntity(entityToSpawn);
                return true;
            } catch (RuntimeException exception) {
                return false;
            }
        }
        return false;
    }

    public static void mcdar$trackAndProtectSummoner(MobEntity summonedEntity) {
        if (summonedEntity instanceof Tameable summonable && summonedEntity.isAlive()) {
            if (summonable.getOwner() instanceof PlayerEntity summoner) {
                if (summoner.getAttacker() != null)
                    summonedEntity.setTarget(summoner.getAttacker());
                else if (summoner.getAttacking() != null && summoner.getAttacking() != summonedEntity)
                    summonedEntity.setTarget(summoner.getAttacking());
            }
        }
    }

    public static boolean mcdar$attackTarget(MobEntity summonedMob, Entity target, SoundEvent soundEvent, float damageAmount) {
        boolean bl = target.damage(target.getWorld().getDamageSources().mobAttack(summonedMob), damageAmount);
        if (bl) {
            summonedMob.tryAttack(target);
            summonedMob.playSound(soundEvent, 1f,(summonedMob.getRandom().nextFloat() - summonedMob.getRandom().nextFloat()) * 0.2F + 1.0F);
        }
        return bl;
    }

    public static void mcdar$tryTeleport(MobEntity summonedEntity, @Nullable LivingEntity summoner) {
        if (summoner == null)
            return;

        BlockPos blockPos = new BlockPos(summoner.getBlockPos());

        for (int i = 0; i < 10; ++i) {
            int j = mcdar$getRandomInt(summonedEntity, -3, 3);
            int k = mcdar$getRandomInt(summonedEntity, -1, 1);
            int l = mcdar$getRandomInt(summonedEntity, -3, 3);
            boolean bl = mcdar$tryTeleportTo(summonedEntity, summoner, blockPos.getX() + j, blockPos.getY() + k, blockPos.getZ() + l); //23343
            if (bl) {
                return;
            }
        }
    }

    private static int mcdar$getRandomInt(MobEntity summonedEntity, int i, int j) {
        return summonedEntity.getRandom().nextInt(j - i + 1) + i;
    }

    private static boolean mcdar$tryTeleportTo(MobEntity summonedEntity, LivingEntity summoner, int i, int j, int k){
        if (Math.abs((double) i - summoner.getX()) < 2.0D && Math.abs((double) k - summoner.getZ()) < 2.0D) {
            return false;
        } else if (!mcdar$canTeleportTo(summonedEntity, new BlockPos(i, j, k))){
            return false;
        } else {
            summonedEntity.getNavigation().stop();
            summonedEntity.refreshPositionAndAngles((double)i + 0.5, j, (double)k + 0.5, summonedEntity.getYaw(), summonedEntity.getPitch());
            return true;
        }
    }

    private static boolean mcdar$canTeleportTo(MobEntity summonedEntity, BlockPos blockPos) {
        if (LandPathNodeMaker.getLandNodeType(summonedEntity, new BlockPos.Mutable()) != PathNodeType.WALKABLE)
            return false;
        return summonedEntity.getWorld().isSpaceEmpty(summonedEntity, summonedEntity.getBoundingBox().offset(blockPos.subtract(new BlockPos(summonedEntity.getBlockPos()))));
    }
}
