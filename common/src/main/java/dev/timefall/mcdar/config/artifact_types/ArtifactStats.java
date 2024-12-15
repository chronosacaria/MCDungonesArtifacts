package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.annotations.Translation;
import me.fzzyhmstrs.fzzy_config.util.Walkable;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt;

//ComplexArtifactStats<T extends Walkable>(...) extends ArtifactStats

@IgnoreVisibility
public class ArtifactStats implements Walkable {

    // The visual order of the elements in the config is defined by the order of the fields below
    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    boolean isEnabled = true;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    @RequiresAction(action = Action.RESTART)
    @ValidatedInt.Restrict(min = 1)
    int durability;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    @ValidatedInt.Restrict(min = 1)
    int maxCooldownEnchantmentTime;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    @RequiresAction(action = Action.RELOAD_DATA)
    boolean isSpawnableInLoot = true;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    @RequiresAction(action = Action.RELOAD_DATA)
    @ValidatedInt.Restrict(min = 0)
    int generalSpawnWeight;

    @Translation(prefix = "mcdar.mcdar_artifacts_stats_config.artifact_stats")
    @RequiresAction(action = Action.RELOAD_DATA)
    @ValidatedInt.Restrict(min = 0)
    int dungeonSpawnWeight;

    public boolean mcdar$getIsEnabled() {
        return isEnabled;
    }

    public boolean mcdar$getIsSpawnableInLoot() {
        return isSpawnableInLoot;
    }

    public int mcdar$getDurability() {
        return durability;
    }

    public int mcdar$getMaxCooldownEnchantmentTime() {
        return maxCooldownEnchantmentTime;
    }

    public int mcdar$getGeneralArtifactSpawnWeight() {
        return generalSpawnWeight;
    }

    public int mcdar$getDungeonArtifactSpawnWeight() {
        return dungeonSpawnWeight;
    }

    @SuppressWarnings("unused")
    public ArtifactStats() {
    }

    public ArtifactStats(boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight) {
        this.isEnabled = isEnabled;
        this.durability = durability;
        this.maxCooldownEnchantmentTime = maxCooldownEnchantmentTime;
        this.isSpawnableInLoot = isSpawnableInLoot;
        this.generalSpawnWeight = generalSpawnWeight;
        this.dungeonSpawnWeight = dungeonSpawnWeight;
    }
}
