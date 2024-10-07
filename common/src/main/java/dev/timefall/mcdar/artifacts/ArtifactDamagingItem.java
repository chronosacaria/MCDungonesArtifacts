package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.DamagingArtifactID;
import net.minecraft.item.Item;

public class ArtifactDamagingItem extends Item {

    public final DamagingArtifactID id;

    public ArtifactDamagingItem(DamagingArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
