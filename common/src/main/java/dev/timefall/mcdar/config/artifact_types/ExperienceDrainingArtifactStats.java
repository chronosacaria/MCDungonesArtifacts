package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;

@IgnoreVisibility
public class ExperienceDrainingArtifactStats extends ArtifactStats {

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int experienceDrain;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    float range;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    float damageOrHealingFactor;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int damageOrHealing;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int duration;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int amplifier;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int amplifier2;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.experience_draining")
    int amplifier3;

    public int mcdar$getExperienceDrain() {
        return experienceDrain;
    }

    public float mcdar$getRange() {
        return range;
    }

    public float mcdar$getDamageOrHealingFactor() {
        return damageOrHealingFactor;
    }

    public int mcdar$getDamageOrHealing() {
        return damageOrHealing;
    }

    public int mcdar$getDuration() {
        return duration;
    }

    public int mcdar$getAmplifier() {
        return amplifier;
    }

    public int mcdar$getAmplifier2() {
        return amplifier2;
    }

    public int mcdar$getAmplifier3() {
        return amplifier3;
    }


    public ExperienceDrainingArtifactStats(int experienceDrain, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.experienceDrain = experienceDrain;

    }

    public ExperienceDrainingArtifactStats(int experienceDrain, float range, float damageOrHealingFactor, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.experienceDrain = experienceDrain;
        this.range = range;
        this.damageOrHealingFactor = damageOrHealingFactor;

    }

    public ExperienceDrainingArtifactStats(int experienceDrain, float range, int damageOrHealing, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.experienceDrain = experienceDrain;
        this.range = range;
        this.damageOrHealing = damageOrHealing;

    }

    public ExperienceDrainingArtifactStats(int experienceDrain, float damageOrHealingFactor, float range, int duration, int amplifier, int amplifier2, int amplifier3, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.experienceDrain = experienceDrain;
        this.damageOrHealingFactor = damageOrHealingFactor;
        this.range = range;
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;

    }

    public ExperienceDrainingArtifactStats(int experienceDrain, int damageOrHealing, float range, int duration, int amplifier, int amplifier2, int amplifier3, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.experienceDrain = experienceDrain;
        this.damageOrHealing = damageOrHealing;
        this.range = range;
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
    }

    public ExperienceDrainingArtifactStats() {
        super();
    }
}
