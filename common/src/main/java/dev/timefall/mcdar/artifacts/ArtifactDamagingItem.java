package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactDamagingItem extends Item {

    public ArtifactDamagingItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
