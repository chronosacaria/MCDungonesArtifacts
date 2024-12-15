package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.StatusGrantingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;

public class AgilityArtifactStats extends ConfigSection {

    public AgilityArtifactStats() {
        super();
        this.BOOTS_OF_SWIFTNESS_STATS = new StatusGrantingArtifactStats(
                40,
                2,
                true,
                true,
                64,
                100,
                2,
                1
        );
        this.DEATH_CAP_MUSHROOM_STATS = new StatusGrantingArtifactStats(
                180,
                3,
                1,
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.GHOST_CLOAK_STATS = new StatusGrantingArtifactStats(
                60,
                0,
                3,
                0,
                true,
                true,
                64,
                120,
                2,
                1
        );
        this.LIGHT_FEATHER_STATS = new StatusGrantingArtifactStats(
                60,
                0,
                0,
                4,
                true,
                true,
                64,
                120,
                2,
                1
        );
    }
    
    public StatusGrantingArtifactStats BOOTS_OF_SWIFTNESS_STATS;
    public StatusGrantingArtifactStats DEATH_CAP_MUSHROOM_STATS;
    public StatusGrantingArtifactStats GHOST_CLOAK_STATS;
    public StatusGrantingArtifactStats LIGHT_FEATHER_STATS;
}
