package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.util.Walkable;

//ComplexArtifactStats<T extends Walkable>(...) extends ArtifactStats


// public ComplexArtifactStats<DamageStat> BLAST_FUNGUS_STATS = ComplexArtifactStats(new DamageArtifactStat(5, 4)

// Congig.BLAST_FUNGUS_STATS.mcdar$getRange()

// public DamageArtifactStats BLAST_FUNGUS_STATS = DamageArtifactStats(range = 5, damage = 4, ;ggggggg)

// Congig.BLAST_FUNGUS_STATS.mcdar$getRange()

@IgnoreVisibility
public class ComplexArtifactStats<T extends Walkable> extends ArtifactStats {

    //@Translation(prefix = "fgfg")
    T innerStat;

    public T mcdar$getInnerStat() {
        return innerStat;
    }

    @SuppressWarnings("unused")
    public ComplexArtifactStats() {
    }

    public ComplexArtifactStats(T innerStat, boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        super(isEnabled, isSpawnableInLoot, durability, maxCooldownEnchantmentTime, generalSpawnWeight, dungeonSpawnWeight);
        this.innerStat = innerStat;
    }
}
