package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactAgilityItem extends Item {

    public ArtifactAgilityItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
