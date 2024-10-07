package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.enums.DefensiveArtifactID;
import net.minecraft.item.Item;

public class ArtifactDefensiveItem extends Item {

    public final DefensiveArtifactID id;

    public ArtifactDefensiveItem(DefensiveArtifactID id, int artifactDurability) {
        super(new Settings().maxCount(1).maxDamage(artifactDurability));
        this.id = id;
    }
}
