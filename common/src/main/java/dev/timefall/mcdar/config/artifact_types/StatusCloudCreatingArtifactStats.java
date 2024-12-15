package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

@IgnoreVisibility
public class StatusCloudCreatingArtifactStats extends ArtifactStats {

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_cloud_creating")
    float cloudRadius;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_cloud_creating")
    int cloudDuration;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_cloud_creating")
    int effectDuration;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage.status_cloud_creating")
    int amplifier;


    public float mcdar$getCloudRadius() {
        return cloudRadius;
    }

    public int mcdar$getCloudDuration() {
        return cloudDuration;
    }

    public int mcdar$getEffectDuration() {
        return effectDuration;
    }

    public int mcdar$getAmplifier() {
        return amplifier;
    }



    public StatusCloudCreatingArtifactStats(float cloudRadius, int cloudDuration, int effectDuration, int amplifier, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.cloudRadius = cloudRadius;
        this.cloudDuration = cloudDuration;
        this.effectDuration = effectDuration;
        this.amplifier = amplifier;
    }

    public StatusCloudCreatingArtifactStats() {
        super();
    }
}
