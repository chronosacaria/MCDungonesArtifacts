package dev.timefall.mcdar.config.item_sections;

import dev.timefall.mcdar.config.artifact_types.ArtifactStats;
import me.fzzyhmstrs.fzzy_config.config.ConfigSection;
import net.minecraft.util.Identifier;

import java.util.Set;

public class SummoningArtifactStats extends ConfigSection {

    public SummoningArtifactStats(Set<Identifier> villager, Set<Identifier> illager, Set<Identifier> dungeon) {
        super();
        this.BUZZY_NEST_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1,
                villager,
                dungeon
        );
        this.ENCHANTED_GRASS_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1,
                villager,
                dungeon
        );
        this.GOLEM_KIT_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1,
                villager,
                dungeon
        );
        this.TASTY_BONE_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1,
                villager,
                dungeon
        );
        this.WONDERFUL_WHEAT_STATS = new ArtifactStats(
                true,
                true,
                8,
                600,
                2,
                1,
                villager,
                dungeon
        );
    }

    public ArtifactStats BUZZY_NEST_STATS;
    public ArtifactStats ENCHANTED_GRASS_STATS;
    public ArtifactStats GOLEM_KIT_STATS;
    public ArtifactStats TASTY_BONE_STATS;
    public ArtifactStats WONDERFUL_WHEAT_STATS;
}
