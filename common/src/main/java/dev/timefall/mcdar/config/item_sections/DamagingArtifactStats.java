package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ComplexArtifactStats;
import dev.timefall.mcdar.config.artifact_types.DamageArtifactStats;
import dev.timefall.mcdar.config.artifact_types.ExperienceDrainingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class DamagingArtifactStats extends ConfigSection {

    public DamagingArtifactStats(Set<Identifier> villager, Set<Identifier> illager, Set<Identifier> dungeon) {
        super();
        this.BLAST_FUNGUS_STATS = new ComplexArtifactStats<>(
                new DamageArtifactStats(5f, 4f),
                true,
                true,
                64,
                120,
                2,
                1,
                illager,
                dungeon
        );
        this.HARVESTER_STATS = new ComplexArtifactStats<>(
                new ExperienceDrainingArtifactStats(40, 3f, 15f),
                true,
                true,
                64,
                60,
                2,
                1,
                illager,
                dungeon
        );
        this.LIGHTNING_ROD_STATS = new ComplexArtifactStats<>(
                new DamageArtifactStats(5f, 5f),
                true,
                true,
                64,
                40,
                2,
                1,
                illager,
                dungeon
        );
        this.POWERSHAKER_STATS = new ComplexArtifactStats<>(
                new DamageArtifactStats(1f, 1f),
                true,
                true,
                64,
                600,
                2,
                1,
                illager,
                dungeon
        );
        this.UPDRAFT_TOME_STATS = new ComplexArtifactStats<>(
                new DamageArtifactStats(1f, 1f),
                true,
                true,
                64,
                300,
                2,
                1,
                villager,
                dungeon
        );
    }

    public ComplexArtifactStats<DamageArtifactStats> BLAST_FUNGUS_STATS;
    public ComplexArtifactStats<ExperienceDrainingArtifactStats> HARVESTER_STATS;
    public ComplexArtifactStats<DamageArtifactStats> LIGHTNING_ROD_STATS;
    public ComplexArtifactStats<DamageArtifactStats> POWERSHAKER_STATS;
    public ComplexArtifactStats<DamageArtifactStats> UPDRAFT_TOME_STATS;
}
