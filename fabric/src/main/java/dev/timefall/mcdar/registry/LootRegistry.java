package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.api.GroupedObjectsHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.IArtifactItem;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.List;

public class LootRegistry {

    public static void register(){
            LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
                Identifier id = key.getValue();
                mcdar$artifactsGeneralLootBuilder(GroupedObjectsHelper.illagerArtifacts, id, tableBuilder);
                mcdar$artifactsGeneralLootBuilder(GroupedObjectsHelper.villagerArtifacts, id, tableBuilder);
                mcdar$artifactsDungeonLootBuilder(id, tableBuilder);
        }));
    }

    private static void mcdar$artifactsGeneralLootBuilder(List<IArtifactItem> artifactItemList, Identifier id, FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(McdarArtifactsStatsConfig.CONFIG.ARTIFACT_GENERAL_SPAWN_CHANCE));
        for (IArtifactItem artifactItem : artifactItemList) {
            if (!artifactItem.mcdar$isEnabled())
                continue;
            artifactItem.mcdar$insertIntoGeneralLootPool(lootPoolBuilder, id);
        }
        tableBuilder.pool(lootPoolBuilder.build());
    }
    private static void mcdar$artifactsDungeonLootBuilder(Identifier id, FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(McdarArtifactsStatsConfig.CONFIG.ARTIFACT_DUNGEON_SPAWN_CHANCE));
        for (IArtifactItem artifactItem : GroupedObjectsHelper.allArtifacts) {
            if (!artifactItem.mcdar$isEnabled())
                continue;
            artifactItem.mcdar$insertIntoDungeonLootPool(lootPoolBuilder, id);
        }
        tableBuilder.pool(lootPoolBuilder.build());
    }
}
