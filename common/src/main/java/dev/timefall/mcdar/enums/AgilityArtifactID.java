package dev.timefall.mcdar.enums;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.registries.ArtifactsRegistry;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.Set;

public enum AgilityArtifactID implements IArtifactItem {
    BOOTS_OF_SWIFTNESS,
    DEATH_CAP_MUSHROOM,
    GHOST_CLOAK,
    LIGHT_FEATHER;

    public static EnumMap<AgilityArtifactID, Item> getItemsEnum() {
        return ArtifactsRegistry.AGILITY_ARTIFACT;
    }

    @Override
    public Boolean mcdar$isEnabled() {
        return McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS.get(this).mcdar$getIsEnabled();
    }

    @Override
    public Item mcdar$getItem() {
        return getItemsEnum().get(this);
    }

    @Override
    public Set<String> mcdar$getGeneralLootTables() {
        return McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS.get(this).mcdar$getGeneralLootTables();
    }
    @Override
    public Set<String> mcdar$getDungeonLootTables() {
        return McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS.get(this).mcdar$getDungeonLootTables();
    }

    @Override
    public void mcdar$insertIntoGeneralLootPool(LootPool.Builder lootPoolBuilder, Identifier id) {
        if (this.mcdar$getGeneralLootTables().contains(id.toString())) {
            lootPoolBuilder
                    .with(ItemEntry.builder(this.mcdar$getItem())
                            .weight(McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS
                                    .get(this).mcdar$getGeneralArtifactSpawnWeight()));
        }
    }

    @Override
    public void mcdar$insertIntoDungeonLootPool(LootPool.Builder lootPoolBuilder, Identifier id) {
        if (this.mcdar$getDungeonLootTables().contains(id.toString())) {
            lootPoolBuilder
                    .with(ItemEntry.builder(this.mcdar$getItem())
                            .weight(McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS
                                    .get(this).mcdar$getDungeonArtifactSpawnWeight()));
        }
    }
}
