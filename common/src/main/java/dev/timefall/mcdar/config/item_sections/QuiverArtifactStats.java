package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ArtifactStats;
import dev.timefall.mcdar.config.artifact_types.ComplexArtifactStats;
import dev.timefall.mcdar.config.artifact_types.ExperienceDrainingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class QuiverArtifactStats extends ConfigSection {

    public QuiverArtifactStats(Set<Identifier> villager, Set<Identifier> illager, Set<Identifier> dungeon) {
        super();
        this.FLAMING_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                100,
                2,
                1,
                villager,
                dungeon
        );
        this.HARPOON_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                600,
                2,
                1,
                illager,
                dungeon
        );
        this.THUNDERING_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                120,
                2,
                1,
                villager,
                dungeon
        );
        this.TORMENT_QUIVER_STATS = new ComplexArtifactStats<>(
                new ExperienceDrainingArtifactStats(20),
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

    public ArtifactStats FLAMING_QUIVER_STATS;
    public ArtifactStats HARPOON_QUIVER_STATS;
    public ArtifactStats THUNDERING_QUIVER_STATS;
    public ComplexArtifactStats<ExperienceDrainingArtifactStats> TORMENT_QUIVER_STATS;
}
