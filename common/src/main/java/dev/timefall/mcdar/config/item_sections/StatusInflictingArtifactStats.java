package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ExperienceDrainingArtifactStats;
import dev.timefall.mcdar.config.artifact_types.StatusGrantingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;

public class StatusInflictingArtifactStats  extends ConfigSection {

    public StatusInflictingArtifactStats() {
        super();
        this.CORRUPTED_SEEDS_STATS = new StatusGrantingArtifactStats(
                140,
                4,
                1,
                5.0f,
                true,
                true,
                64,
                100,
                2,
                1
        );
        this.GONG_OF_WEAKENING_STATS = new StatusGrantingArtifactStats(
                140,
                1,
                -2,
                5.0f,
                true,
                true,
                64,
                100,
                2,
                1
        );
        this.LOVE_MEDALLION_STATS = new StatusGrantingArtifactStats(
                200,
                0,
                6.0f,
                true,
                true,
                64,
                120,
                2,
                1
        );
        this.SATCHEL_OF_ELEMENTS_STATS = new ExperienceDrainingArtifactStats(
                15,
                5.0f,
                5.0f,
                100,
                0,
                0,
                4,
                true,
                true,
                64,
                60,
                2,
                1
        );
        this.SHOCK_POWDER_STATS = new StatusGrantingArtifactStats(
                100,
                0,
                0,
                4,
                0.5f,
                true,
                true,
                64,
                300,
                2,
                1
        );
    }

    public StatusGrantingArtifactStats CORRUPTED_SEEDS_STATS;
    public StatusGrantingArtifactStats GONG_OF_WEAKENING_STATS;
    public StatusGrantingArtifactStats LOVE_MEDALLION_STATS;
    public ExperienceDrainingArtifactStats SATCHEL_OF_ELEMENTS_STATS;
    public StatusGrantingArtifactStats SHOCK_POWDER_STATS;
}
