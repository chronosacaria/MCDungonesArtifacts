package dev.timefall.mcdar.config;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.api.GroupedObjectsHelper;
import dev.timefall.mcdar.config.item_sections.*;
import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.config.Config;
import me.fzzyhmstrs.fzzy_config.validation.collection.ValidatedList;
import me.fzzyhmstrs.fzzy_config.validation.minecraft.ValidatedIdentifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@IgnoreVisibility
@SuppressWarnings("FieldMayBeFinal")
public class McdarArtifactsStatsConfig extends Config {

    public static final McdarArtifactsStatsConfig CONFIG = ConfigApiJava.registerAndLoadConfig(McdarArtifactsStatsConfig::new);

    public float ARTIFACT_GENERAL_SPAWN_CHANCE = 0.25f;
    public float ARTIFACT_DUNGEON_SPAWN_CHANCE = 0.1f;

    transient Set<Identifier> villager = GroupedObjectsHelper.VILLAGER_ARTIFACT_GENERAL_LOOT_TABLES.stream().map(RegistryKey::getValue).collect(Collectors.toSet());
    transient Set<Identifier> illager = GroupedObjectsHelper.ILLAGER_ARTIFACT_GENERAL_LOOT_TABLES.stream().map(RegistryKey::getValue).collect(Collectors.toSet());
    transient Set<Identifier> dungeon = GroupedObjectsHelper.ALL_ARTIFACTS_DUNGEON_LOOT_TABLES.stream().map(RegistryKey::getValue).collect(Collectors.toSet());

    // Determines if the table is valid
    private ValidatedList<Identifier> villagerLootTables = ValidatedIdentifier.ofDynamicKey(RegistryKeys.LOOT_TABLE, "mcdar_artifact_stats_villager_loot_tables", (id, entry) -> true).toList(villager);
    private ValidatedList<Identifier> illagerLootTables = ValidatedIdentifier.ofDynamicKey(RegistryKeys.LOOT_TABLE, "mcdar_artifacts_stats_illager_loot_tables", (id, entry) -> true).toList(illager);
    private ValidatedList<Identifier> dungeonLootTables = ValidatedIdentifier.ofDynamicKey(RegistryKeys.LOOT_TABLE, "mcdar_artifacts_stats_dungeon_loot_tables", (id, entry) -> true).toList(dungeon);

    private DamagingArtifactStats damagingArtifactStats = new DamagingArtifactStats(villager, illager, dungeon);
    private AgilityArtifactStats agilityArtifactStats = new AgilityArtifactStats(villager, illager, dungeon);
    private DefensiveArtifactStats defensiveArtifactStats = new DefensiveArtifactStats(villager, illager, dungeon);
    private QuiverArtifactStats quiverArtifactStats = new QuiverArtifactStats(villager, illager, dungeon);
    private StatusInflictingArtifactStats statusInflictingArtifactStats = new StatusInflictingArtifactStats(villager, illager, dungeon);
    private SummoningArtifactStats summoningArtifactStats = new SummoningArtifactStats(villager, illager, dungeon);

    public DamagingArtifactStats mcdar$getDamagingArtifactStats() {
        return damagingArtifactStats;
    }

    public AgilityArtifactStats mcdar$getAgilityArtifactStats() {
        return agilityArtifactStats;
    }

    public DefensiveArtifactStats mcdar$getDefensiveArtifactStats() {
        return defensiveArtifactStats;
    }

    public QuiverArtifactStats mcdar$getQuiverArtifactStats() {
        return quiverArtifactStats;
    }

    public StatusInflictingArtifactStats mcdar$getStatusInflictingArtifactStats() {
        return statusInflictingArtifactStats;
    }

    public List<Identifier> mcdar$getVillagerLootTables() {
        return villagerLootTables;
    }

    public List<Identifier> mcdar$getIllagerLootTables() {
        return illagerLootTables;
    }

    public List<Identifier> mcdar$getDungeonLootTables() {
        return dungeonLootTables;
    }

    public SummoningArtifactStats mcdar$getSummoningArtifactStats() {
        return summoningArtifactStats;
    }

    public McdarArtifactsStatsConfig() {
        super(ModConstants.ID("mcdar_artifacts_stats_config"));
    }
}