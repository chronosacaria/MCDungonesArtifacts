package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactQuiverItem extends Item {

    public ArtifactQuiverItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
