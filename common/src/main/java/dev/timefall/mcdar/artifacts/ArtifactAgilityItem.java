package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.AgilityArtifactID;
import net.minecraft.item.Item;

public class ArtifactAgilityItem extends Item {

    public final AgilityArtifactID id;

    public ArtifactAgilityItem(AgilityArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
