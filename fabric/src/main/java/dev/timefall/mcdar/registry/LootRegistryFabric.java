package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.artifacts.ArtifactItem;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.registry.tag.TagKeys;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class LootRegistryFabric {

    public static void register(){
            LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
                Identifier id = key.getValue();
                if (McdarArtifactsStatsConfig.CONFIG.mcdar$getIllagerLootTables().contains(id))
                    mcdar$artifactsLootBuilder(TagKeys.ILLAGER_ARTIFACT, McdarArtifactsStatsConfig.CONFIG.mcdar$getGeneralSpawnChance(), false, tableBuilder);
                if (McdarArtifactsStatsConfig.CONFIG.mcdar$getVillagerLootTables().contains(id))
                    mcdar$artifactsLootBuilder(TagKeys.VILLAGER_ARTIFACT, McdarArtifactsStatsConfig.CONFIG.mcdar$getGeneralSpawnChance(), false, tableBuilder);
                if (McdarArtifactsStatsConfig.CONFIG.mcdar$getDungeonLootTables().contains(id))
                    mcdar$artifactsLootBuilder(TagKeys.ALL_ARTIFACT, McdarArtifactsStatsConfig.CONFIG.mcdar$getDungeonSpawnChance(), true, tableBuilder);
        }));
    }

    /*private static void mcdar$artifactsGeneralLootBuilder(TagKey<Item> itemTagKey, int weight, FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(McdarArtifactsStatsConfig.CONFIG.mcdar$getGeneralSpawnChance()));
        LeafEntry.Builder<?> tagEntry = TagEntry.expandBuilder(itemTagKey);
        lootPoolBuilder.with(tagEntry);
        tableBuilder.pool(lootPoolBuilder.build());
    }*/

    private static void mcdar$artifactsLootBuilder(TagKey<Item> itemTagKey, float chance, boolean dungeon, FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(chance));
        for (var regEntry : Registries.ITEM.iterateEntries(itemTagKey)) {
            Item item = regEntry.value();
            if (item instanceof ArtifactItem artifactItem && artifactItem.mcdar$getStats().mcdar$getIsSpawnableInLoot()) {
                LeafEntry.Builder<?> itemEntry = ItemEntry.builder(artifactItem).weight(
                        dungeon
                                ? artifactItem.mcdar$getStats().mcdar$getDungeonArtifactSpawnWeight()
                                : artifactItem.mcdar$getStats().mcdar$getGeneralArtifactSpawnWeight()
                );
                lootPoolBuilder.with(itemEntry);
            }
        }
        tableBuilder.pool(lootPoolBuilder.build());
    }
}
