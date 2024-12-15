package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.DamageArtifactStats;
import dev.timefall.mcdar.config.artifact_types.ExperienceDrainingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;

public class DamagingArtifactStats extends ConfigSection {

    public DamagingArtifactStats() {
        super();
        this.BLAST_FUNGUS_STATS = new DamageArtifactStats(
                5f,
                4f,
                true,
                true,
                64,
                120,
                2,
                1
        );
        this.HARVESTER_STATS = new ExperienceDrainingArtifactStats(
                40,
                3f,
                15f,
                true,
                true,
                64,
                60,
                2,
                1
        );
        this.LIGHTNING_ROD_STATS = new DamageArtifactStats(
                5f,
                5f,
                true,
                true,
                64,
                40,
                2,
                1
        );
        this.POWERSHAKER_STATS = new DamageArtifactStats(
                1f,
                1f,
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.UPDRAFT_TOME_STATS = new DamageArtifactStats(
                1f,
                1f,
                true,
                true,
                64,
                300,
                2,
                1
        );
    }

    public DamageArtifactStats BLAST_FUNGUS_STATS;
    public ExperienceDrainingArtifactStats HARVESTER_STATS;
    public DamageArtifactStats LIGHTNING_ROD_STATS;
    public DamageArtifactStats POWERSHAKER_STATS;
    public DamageArtifactStats UPDRAFT_TOME_STATS;
}
