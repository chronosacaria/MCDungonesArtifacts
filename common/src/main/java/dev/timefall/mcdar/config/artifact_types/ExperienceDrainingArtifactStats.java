package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

@IgnoreVisibility
public class ExperienceDrainingArtifactStats implements Walkable {

    int experienceDrain;
    float range;
    float damageOrHealingFactor;
    int damageOrHealing;
    int duration;
    int amplifier;
    int amplifier2;
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


    public ExperienceDrainingArtifactStats(int experienceDrain) {
        this.experienceDrain = experienceDrain;
    }

    public ExperienceDrainingArtifactStats(int experienceDrain, float range, float damageOrHealingFactor) {
        this.experienceDrain = experienceDrain;
        this.range = range;
        this.damageOrHealingFactor = damageOrHealingFactor;
    }
    public ExperienceDrainingArtifactStats(int experienceDrain, float range, int damageOrHealing) {
        this.experienceDrain = experienceDrain;
        this.range = range;
        this.damageOrHealing = damageOrHealing;
    }

    public ExperienceDrainingArtifactStats(int experienceDrain, float damageOrHealingFactor, float range, int duration, int amplifier, int amplifier2, int amplifier3) {
        this.experienceDrain = experienceDrain;
        this.damageOrHealingFactor = damageOrHealingFactor;
        this.range = range;
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
    }

    public ExperienceDrainingArtifactStats(int experienceDrain, int damageOrHealing, float range, int duration, int amplifier, int amplifier2, int amplifier3) {
        this.experienceDrain = experienceDrain;
        this.damageOrHealing = damageOrHealing;
        this.range = range;
        this.duration = duration;
        this.amplifier = amplifier;
        this.amplifier2 = amplifier2;
        this.amplifier3 = amplifier3;
    }

    public ExperienceDrainingArtifactStats() {
    }
}
