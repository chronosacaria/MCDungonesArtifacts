package dev.timefall.mcdar.config.artifact_types;

import me.fzzyhmstrs.fzzy_config.annotations.Action;
import me.fzzyhmstrs.fzzy_config.annotations.IgnoreVisibility;
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction;
import me.fzzyhmstrs.fzzy_config.util.Walkable;
import me.fzzyhmstrs.fzzy_config.validation.collection.ValidatedSet;
import me.fzzyhmstrs.fzzy_config.validation.minecraft.ValidatedIdentifier;
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedInt;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Set;

//ComplexArtifactStats<T extends Walkable>(...) extends ArtifactStats

@IgnoreVisibility
public class ArtifactStats implements Walkable {

    // The visual order of the elements in the config is defined by the order of the fields below
    boolean isEnabled = true;
    @RequiresAction(action = Action.RESTART)
    @ValidatedInt.Restrict(min = 1)
        int durability;
    @ValidatedInt.Restrict(min = 1)
        int maxCooldownEnchantmentTime;
    @RequiresAction(action = Action.RELOAD_DATA)
        boolean isSpawnableInLoot = true;
    @RequiresAction(action = Action.RELOAD_DATA)
    @ValidatedInt.Restrict(min = 0)
        int generalSpawnWeight;
    @RequiresAction(action = Action.RELOAD_DATA)
        ValidatedSet<Identifier> generalLootTables = ValidatedIdentifier.ofRegistryKey(RegistryKeys.LOOT_TABLE).toSet();
    @RequiresAction(action = Action.RELOAD_DATA)
    @ValidatedInt.Restrict(min = 0)
        int dungeonSpawnWeight;
    @RequiresAction(action = Action.RELOAD_DATA)
        ValidatedSet<Identifier> dungeonLootTables = ValidatedIdentifier.ofRegistryKey(RegistryKeys.LOOT_TABLE).toSet();

    public boolean mcdar$getIsEnabled() {
        return isEnabled;
    }

    public boolean mcdar$getIsSpawnableInLoot() {
        return isSpawnableInLoot;
    }

    public int mcdar$getDurability() {
        return durability;
    }

    public int mcdar$getMaxCooldownEnchantmentTime() {
        return maxCooldownEnchantmentTime;
    }

    public int mcdar$getGeneralArtifactSpawnWeight() {
        return generalSpawnWeight;
    }

    public int mcdar$getDungeonArtifactSpawnWeight() {
        return dungeonSpawnWeight;
    }
    public Set<Identifier> mcdar$getGeneralLootTables() {
        return generalLootTables;
    }

    public Set<Identifier> mcdar$getDungeonLootTables() {
        return dungeonLootTables;
    }

    @SuppressWarnings("unused")
    public ArtifactStats() {
    }

    public ArtifactStats(boolean isEnabled, boolean isSpawnableInLoot, int durability, int maxCooldownEnchantmentTime, int generalSpawnWeight, int dungeonSpawnWeight, Set<Identifier> generalLootTables, Set<Identifier> dungeonLootTables) {
        this.isEnabled = isEnabled;
        this.durability = durability;
        this.maxCooldownEnchantmentTime = maxCooldownEnchantmentTime;
        this.isSpawnableInLoot = isSpawnableInLoot;
        this.generalSpawnWeight = generalSpawnWeight;
        this.dungeonSpawnWeight = dungeonSpawnWeight;
        this.generalLootTables.validateAndSet(generalLootTables);
        this.dungeonLootTables.validateAndSet(dungeonLootTables);
    }
}
