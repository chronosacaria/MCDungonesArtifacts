package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ArtifactStats;
import dev.timefall.mcdar.config.artifact_types.ExperienceDrainingArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;

public class QuiverArtifactStats extends ConfigSection {

    public QuiverArtifactStats() {
        super();
        this.FLAMING_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.HARPOON_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.THUNDERING_QUIVER_STATS = new ArtifactStats(
                true,
                true,
                64,
                600,
                2,
                1
        );
        this.TORMENT_QUIVER_STATS = new ExperienceDrainingArtifactStats(
                20,
                true,
                true,
                64,
                600,
                2,
                1
        );
    }

    public ArtifactStats FLAMING_QUIVER_STATS;
    public ArtifactStats HARPOON_QUIVER_STATS;
    public ArtifactStats THUNDERING_QUIVER_STATS;
    public ExperienceDrainingArtifactStats TORMENT_QUIVER_STATS;
}
