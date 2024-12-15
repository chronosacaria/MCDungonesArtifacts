package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class SummoningArtifactStats extends ConfigSection {

    public SummoningArtifactStats() {
        super();
        this.BUZZY_NEST_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1
        );
        this.ENCHANTED_GRASS_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1
        );
        this.GOLEM_KIT_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1
        );
        this.TASTY_BONE_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1
        );
        this.WONDERFUL_WHEAT_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1
        );
    }

    public ArtifactStats BUZZY_NEST_STATS;
    public ArtifactStats ENCHANTED_GRASS_STATS;
    public ArtifactStats GOLEM_KIT_STATS;
    public ArtifactStats TASTY_BONE_STATS;
    public ArtifactStats WONDERFUL_WHEAT_STATS;
}
