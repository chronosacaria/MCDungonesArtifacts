package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactStatusInflictingItem extends Item {

    public ArtifactStatusInflictingItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
