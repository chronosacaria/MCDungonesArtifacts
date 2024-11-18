package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.registry.tag.TagKeys;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class LootRegistry {

    public static void register(){
            LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
                Identifier id = key.getValue();
                if (key.isOf(TagKeys.ILLAGER_ARTIFACT.registry()))
                    mcdar$artifactsGeneralLootBuilder(TagKeys.ILLAGER_ARTIFACT, id, tableBuilder);
                if (key.isOf(TagKeys.VILLAGER_ARTIFACT.registry()))
                    mcdar$artifactsGeneralLootBuilder(TagKeys.VILLAGER_ARTIFACT, id, tableBuilder);
                if (key.isOf(TagKeys.ALL_ARTIFACT.registry()))
                    mcdar$artifactsDungeonLootBuilder(TagKeys.ALL_ARTIFACT, id, tableBuilder);
        }));
    }

    private static void mcdar$artifactsGeneralLootBuilder(TagKey<Item> itemTagKey, Identifier id, FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(McdarArtifactsStatsConfig.CONFIG.ARTIFACT_GENERAL_SPAWN_CHANCE));
        LeafEntry.Builder<?> tagEntry = TagEntry.expandBuilder(itemTagKey);
        lootPoolBuilder.with(tagEntry);
        tableBuilder.pool(lootPoolBuilder.build());
    }

    private static void mcdar$artifactsDungeonLootBuilder(TagKey<Item> itemTagKey, Identifier id,  FabricLootTableBuilder tableBuilder) {
        LootPool.Builder lootPoolBuilder = LootPool.builder();
        lootPoolBuilder.rolls(ConstantLootNumberProvider.create(1))
                .conditionally(RandomChanceLootCondition.builder(McdarArtifactsStatsConfig.CONFIG.ARTIFACT_DUNGEON_SPAWN_CHANCE));
        LeafEntry.Builder<?> tagEntry = TagEntry.expandBuilder(itemTagKey);
        lootPoolBuilder.with(tagEntry);
        tableBuilder.pool(lootPoolBuilder.build());
    }
}
