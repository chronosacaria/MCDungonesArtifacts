package dev.timefall.mcdar.entities;

import dev.timefall.mcdar.api.interfaces.Summonable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class BuzzyNestBeeEntity extends BeeEntity implements Tameable, Summonable {

    @Nullable
    UUID ownerEntityUUID = null;

    final int MAX_AGE = 12000;

    public BuzzyNestBeeEntity(EntityType<BuzzyNestBeeEntity> type, World world){
        super(type, world);
    }

    public void setSummoner(Entity player) {
        ownerEntityUUID = player.getUuid();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        if (getOwnerUuid() != null)
            tag.putUuid("SummonerUUID",getOwnerUuid());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        UUID id = tag.getUuid("SummonerUUID");
        if (id != null)
            this.ownerEntityUUID = id;
    }

    protected void mobTick(){
        if (getOwner() instanceof PlayerEntity summoner){
            if (summoner.getAttacking() != null)
                this.setBeeAttacker(summoner.getAttacking());
            else if (summoner.getAttacker() != null)
                this.setBeeAttacker(summoner.getAttacker());
        }
        if (MAX_AGE > -1)
            if (age >= MAX_AGE)
                kill();
        super.mobTick();
    }

    private void setBeeAttacker(LivingEntity attacker){
        if (!attacker.equals(getOwner()))
            super.setAttacker(attacker);
    }

    public boolean tryAttack(Entity target){
        if (target.equals(getOwner()) || this.hasStung())
            return false;
        return super.tryAttack(target);
    }

    @Nullable
    @Override
    public UUID getOwnerUuid() {
        return ownerEntityUUID;
    }

}
