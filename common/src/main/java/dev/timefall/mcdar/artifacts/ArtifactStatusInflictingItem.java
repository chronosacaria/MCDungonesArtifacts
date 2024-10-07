package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.StatusInflictingArtifactID;
import net.minecraft.item.Item;

public class ArtifactStatusInflictingItem extends Item {

    public final StatusInflictingArtifactID id;

    public ArtifactStatusInflictingItem(StatusInflictingArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
