package dev.timefall.mcdar.api;

import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.registry.RegistryKey;

import java.util.Set;

public class GroupedObjectsHelper {
    public static final Set<RegistryKey<LootTable>> ILLAGER_ARTIFACT_GENERAL_LOOT_TABLES =
            Set.of(LootTables.WOODLAND_MANSION_CHEST, LootTables.PILLAGER_OUTPOST_CHEST);

    public static final Set<RegistryKey<LootTable>> VILLAGER_ARTIFACT_GENERAL_LOOT_TABLES =
            Set.of(LootTables.VILLAGE_ARMORER_CHEST, LootTables.VILLAGE_BUTCHER_CHEST,
                    LootTables.VILLAGE_CARTOGRAPHER_CHEST, LootTables.VILLAGE_FISHER_CHEST,
                    LootTables.VILLAGE_FLETCHER_CHEST, LootTables.VILLAGE_DESERT_HOUSE_CHEST,
                    LootTables.VILLAGE_MASON_CHEST, LootTables.VILLAGE_PLAINS_CHEST,
                    LootTables.VILLAGE_SAVANNA_HOUSE_CHEST, LootTables.VILLAGE_SHEPARD_CHEST,
                    LootTables.VILLAGE_SNOWY_HOUSE_CHEST, LootTables.VILLAGE_TAIGA_HOUSE_CHEST,
                    LootTables.VILLAGE_TANNERY_CHEST, LootTables.VILLAGE_TEMPLE_CHEST,
                    LootTables.VILLAGE_TOOLSMITH_CHEST);

    public static final Set<RegistryKey<LootTable>> ALL_ARTIFACTS_DUNGEON_LOOT_TABLES =
            Set.of(LootTables.ABANDONED_MINESHAFT_CHEST, LootTables.SIMPLE_DUNGEON_CHEST, LootTables.SHIPWRECK_TREASURE_CHEST);
}
