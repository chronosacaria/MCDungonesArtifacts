package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;

@IgnoreVisibility
public class StatusGrantingArtifactStats extends ArtifactStats {

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    int duration;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    int duration2;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    int amplifier;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    int amplifier2;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    int amplifier3;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_granting")
    float range;


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

    public float mcdar$getRange() {
        return range;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, int amplifier3, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, float range, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
        this.range = range;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, float range, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.range = range;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, int amplifier3, float range, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
        this.range = range;
    }

    public StatusGrantingArtifactStats() {
        super();
    }
}
