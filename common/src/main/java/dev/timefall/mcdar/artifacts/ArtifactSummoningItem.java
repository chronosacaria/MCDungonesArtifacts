package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.SummoningArtifactID;
import net.minecraft.item.Item;

public class ArtifactSummoningItem extends Item {

    public final SummoningArtifactID id;

    public ArtifactSummoningItem(SummoningArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
