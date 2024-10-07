package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ComplexArtifactStats;
import dev.timefall.mcdar.config.artifact_types.StatusGrantingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class AgilityArtifactStats extends ConfigSection {

    public AgilityArtifactStats(Set<Identifier> villager, Set<Identifier> illager, Set<Identifier> dungeon) {
        super();
        this.BOOTS_OF_SWIFTNESS_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(40, 2),
                true,
                true,
                64,
                100,
                2,
                1,
                villager,
                dungeon
        );
        this.DEATH_CAP_MUSHROOM_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(180, 3, 1),
                true,
                true,
                64,
                600,
                2,
                1,
                illager,
                dungeon
        );
        this.GHOST_CLOAK_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(60, 0, 3, 0),
                true,
                true,
                64,
                120,
                2,
                1,
                villager,
                dungeon
        );
        this.LIGHT_FEATHER_STATS = new ComplexArtifactStats<>(
                new StatusGrantingArtifactStats(60, 0, 0, 4),
                true,
                true,
                64,
                120,
                2,
                1,
                villager,
                dungeon
        );
    }
    
    public ComplexArtifactStats<StatusGrantingArtifactStats> BOOTS_OF_SWIFTNESS_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> DEATH_CAP_MUSHROOM_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> GHOST_CLOAK_STATS;
    public ComplexArtifactStats<StatusGrantingArtifactStats> LIGHT_FEATHER_STATS;
}
