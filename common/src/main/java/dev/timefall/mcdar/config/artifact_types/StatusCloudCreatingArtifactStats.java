package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

@IgnoreVisibility
public class StatusCloudCreatingArtifactStats implements Walkable {

    float cloudRadius;

    int cloudDuration;

    int effectDuration;

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



    public StatusCloudCreatingArtifactStats(float cloudRadius, int cloudDuration, int effectDuration, int amplifier) {
        this.cloudRadius = cloudRadius;
        this.cloudDuration = cloudDuration;
        this.effectDuration = effectDuration;
        this.amplifier = amplifier;
    }

    public StatusCloudCreatingArtifactStats() {
    }
}
