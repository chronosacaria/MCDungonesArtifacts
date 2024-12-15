package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;

@IgnoreVisibility
public class DamageArtifactStats extends ArtifactStats {

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage")
    float range;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats.damage")
    float damage;

    public float mcdar$getRange() {
        return range;
    }

    public float mcdar$getDamage() {
        return damage;
    }

    public DamageArtifactStats() {
        super();
    }

    public DamageArtifactStats(float range, float damage, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super (isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.range = range;
        this.damage = damage;
    }
}
