package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.config.artifact_types.ArtifactStats;
import net.minecraft.item.Item;

public class ArtifactItem extends Item {
    protected ArtifactStats artifactStats;

    public ArtifactStats mcdar$getStats() {
        return artifactStats;
    }

    public ArtifactItem(ArtifactStats artifactStats) {
        super(new Settings().maxCount(1).maxDamage(artifactStats.mcdar$getDurability()));
        this.artifactStats = artifactStats;
    }
}
