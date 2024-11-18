package dev.timefall.mcdar.artifacts;

import net.minecraft.item.Item;

public class ArtifactDefensiveItem extends Item {

    public ArtifactDefensiveItem(int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
    }
}
