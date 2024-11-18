package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.*;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class StatusInflictingArtifactStats  extends ConfigSection {

    public StatusInflictingArtifactStats(Set<Identifier> villager, Set<Identifier> illager, Set<Identifier> dungeon) {
        super();
        this.CORRUPTED_SEEDS_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(140, 4, 1, 5.0f),
                true,
                true,
                64,
                100,
                2,
                1,
                illager,
                dungeon
        );
        this.GONG_OF_WEAKENING_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(140, 1, -2, 5.0f),
                true,
                true,
                64,
                100,
                2,
                1,
                illager,
                dungeon
        );
        this.LOVE_MEDALLION_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(200, 0, 6.0f),
                true,
                true,
                64,
                120,
                2,
                1,
                illager,
                dungeon
        );
        this.SATCHEL_OF_ELEMENTS_STATS = new ComplexArtifactStats<>(
                new ExperienceDrainingArtifactStats(15, 5.0f, 5.0f, 100, 0, 0, 4),
                true,
                true,
                64,
                60,
                2,
                1,
                illager,
                dungeon
        );
        this.SHOCK_POWDER_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(100, 0, 0, 4, 0.5f),
                true,
                true,
                64,
                300,
                2,
                1,
                illager,
                dungeon
        );
    }

    public ComplexArtifactStats<StatusGrantingArtifactStats> CORRUPTED_SEEDS_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> GONG_OF_WEAKENING_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> LOVE_MEDALLION_STATS;
    public ComplexArtifactStats<ExperienceDrainingArtifactStats> SATCHEL_OF_ELEMENTS_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> SHOCK_POWDER_STATS;
}
