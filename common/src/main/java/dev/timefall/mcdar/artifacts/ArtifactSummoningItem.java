package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactSummoningItem extends Item {

    public ArtifactSummoningItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
