package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.QuiverArtifactID;
import net.minecraft.item.Item;

public class ArtifactQuiverItem extends Item {

    public final QuiverArtifactID id;

    public ArtifactQuiverItem(QuiverArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
