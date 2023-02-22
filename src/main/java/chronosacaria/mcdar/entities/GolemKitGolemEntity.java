package chronosacaria.mcdar.entities;

import chronosacaria.mcdar.api.SummoningHelper;
import chronosacaria.mcdar.api.interfaces.Summonable;
import chronosacaria.mcdar.goals.FollowGolemSummonerGoal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class GolemKitGolemEntity extends IronGolemEntity implements Summonable {

    protected static final TrackedData<Optional<UUID>> SUMMONER_UUID;


    public GolemKitGolemEntity(EntityType<? extends GolemKitGolemEntity> type, World world) {
        super(type, world);
    }

    protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(SUMMONER_UUID, Optional.empty());
    }

    @Override
    protected void initGoals(){

        this.goalSelector.add(6, new FollowGolemSummonerGoal(this, this.getSummoner(), 1.0,
                this.getNavigation(), 90.0F, 3.0F));
        this.initCustomGoals();
    }

    protected void initCustomGoals(){
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.add(2, new RevengeGoal(this));
    }

    public void setSummonerUuid(@Nullable UUID uuid) {
        this.dataTracker.set(SUMMONER_UUID, Optional.ofNullable(uuid));
    }

    public Optional<UUID> getSummonerUuid(){
        return this.dataTracker.get(SUMMONER_UUID);
    }

    @Override
    public void setSummoner(Entity player) {
        this.setSummonerUuid(player.getUuid());
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        if (getSummonerUuid().isPresent())
            tag.putUuid("SummonerUUID",getSummonerUuid().get());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        UUID id = tag.getUuid("SummonerUUID");
        if (id != null)
            this.setSummonerUuid(id);
    }

    @Override
    public void setAttacker(LivingEntity attacker){
        if (attacker != null && !attacker.equals(getSummoner()))
            super.setAttacker(attacker);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        SummoningHelper.trackAndProtectSummoner(this);
    }

    public LivingEntity getSummoner(){
        try {
            return this.getSummonerUuid().map(value -> this.world.getPlayerByUuid(value)).orElse(null);
        } catch (IllegalArgumentException var2){
            return null;
        }
    }

    static {
        SUMMONER_UUID = DataTracker.registerData(GolemKitGolemEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }
}
