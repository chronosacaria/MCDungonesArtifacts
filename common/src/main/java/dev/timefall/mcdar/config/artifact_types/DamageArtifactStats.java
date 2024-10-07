package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

@IgnoreVisibility
public class DamageArtifactStats implements Walkable {

    float range;
    float damage;

    public float mcdar$getRange() {
        return range;
    }

    public float mcdar$getDamage() {
        return damage;
    }

    public DamageArtifactStats(float range, float damage) {
        this.range = range;
        this.damage = damage;
    }

    public DamageArtifactStats() {
    }
}
