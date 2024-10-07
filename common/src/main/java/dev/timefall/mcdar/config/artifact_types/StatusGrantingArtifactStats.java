package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

@IgnoreVisibility
public class StatusGrantingArtifactStats implements Walkable {

    int duration;
    int duration2;

    int amplifier;
    int amplifier2;
    int amplifier3;

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

    public StatusGrantingArtifactStats(int duration, int amplifier) {
        this.duration = duration;
        this.amplifier = amplifier;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, int amplifier3) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, float range) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.range = range;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, float range) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.range = range;
    }

    public StatusGrantingArtifactStats(int duration, int amplifier, int amplifier2, int amplifier3, float range) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
        this.range = range;
    }

    public StatusGrantingArtifactStats() {
    }
}
