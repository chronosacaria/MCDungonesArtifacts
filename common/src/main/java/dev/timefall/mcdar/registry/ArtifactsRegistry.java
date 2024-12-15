package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.artifacts.*;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.InstrumentTags;


public class ArtifactsRegistry {

    private static final Registrar<Item> ITEM = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.ITEM);

    // Illager Artifacts
    public static final RegistrySupplier<Item> DEATH_CAP_MUSHROOM         = registerArtifacts("death_cap_mushroom",  new DeathCapMushroomItem());
    public static final RegistrySupplier<Item> BLAST_FUNGUS               = registerArtifacts("blast_fungus",  new BlastFungusItem());
    public static final RegistrySupplier<Item> HARVESTER                  = registerArtifacts("harvester",  new HarvesterItem());
    public static final RegistrySupplier<Item> LIGHTNING_ROD              = registerArtifacts("lightning_rod",  new LightningRodItem());
    public static final RegistrySupplier<Item> POWERSHAKER                = registerArtifacts("powershaker",  new PowershakerItem());
    public static final RegistrySupplier<Item> ENCHANTERS_TOME            = registerArtifacts("enchanters_tome",  new EnchantersTomeItem());
    public static final RegistrySupplier<Item> SOUL_HEALER                = registerArtifacts("soul_healer",  new SoulHealerItem());
    public static final RegistrySupplier<Item> TOTEM_OF_REGENERATION      = registerArtifacts("totem_of_regeneration",  new TotemOfRegenerationItem());
    public static final RegistrySupplier<Item> TOTEM_OF_SHIELDING         = registerArtifacts("totem_of_shielding",  new TotemOfShieldingItem());
    public static final RegistrySupplier<Item> TOTEM_OF_SOUL_PROTECTION   = registerArtifacts("totem_of_soul_protection",  new TotemOfSoulProtectionItem());
    public static final RegistrySupplier<Item> HARPOON_QUIVER             = registerArtifacts("harpoon_quiver",  new HarpoonQuiverItem());
    public static final RegistrySupplier<Item> THUNDERING_QUIVER          = registerArtifacts("thundering_quiver",  new ThunderingQuiverItem());
    public static final RegistrySupplier<Item> TORMENT_QUIVER             = registerArtifacts("torment_quiver",  new TormentQuiverItem());
    public static final RegistrySupplier<Item> CORRUPTED_SEEDS            = registerArtifacts("corrupted_seeds",  new CorruptedSeedsItem());
    public static final RegistrySupplier<Item> GONG_OF_WEAKENING          = registerArtifacts("gong_of_weakening",  new GongOfWeakeningItem());
    public static final RegistrySupplier<Item> LOVE_MEDALLION             = registerArtifacts("love_medallion",  new LoveMedallionItem());
    public static final RegistrySupplier<Item> SATCHEL_OF_ELEMENTS        = registerArtifacts("satchel_of_elements",  new SatchelOfElementsItem());
    public static final RegistrySupplier<Item> SHOCK_POWDER               = registerArtifacts("shock_powder",  new ShockPowderItem());

    // Villager Artifacts
    public static final RegistrySupplier<Item> BOOTS_OF_SWIFTNESS         = registerArtifacts("boots_of_swiftness",  new BootsOfSwiftnessItem());
    public static final RegistrySupplier<Item> GHOST_CLOAK                = registerArtifacts("ghost_cloak",  new GhostCloakItem());
    public static final RegistrySupplier<Item> LIGHT_FEATHER              = registerArtifacts("light_feather",  new LightFeatherItem());
    public static final RegistrySupplier<Item> UPDRAFT_TOME               = registerArtifacts("updraft_tome",  new UpdraftTomeItem());
    public static final RegistrySupplier<Item> IRON_HIDE_AMULET           = registerArtifacts("iron_hide_amulet",  new IronHideAmuletItem());
    public static final RegistrySupplier<Item> WIND_HORN                  = registerArtifacts("wind_horn",  new WindHornItem(InstrumentTags.GOAT_HORNS));
    public static final RegistrySupplier<Item> FLAMING_QUIVER             = registerArtifacts("flaming_quiver",  new FlamingQuiverItem());
    public static final RegistrySupplier<Item> BUZZY_NEST                 = registerArtifacts("buzzy_nest",  new BuzzyNestItem());
    public static final RegistrySupplier<Item> ENCHANTED_GRASS            = registerArtifacts("enchanted_grass",  new EnchantedGrassItem());
    public static final RegistrySupplier<Item> GOLEM_KIT                  = registerArtifacts("golem_kit",  new GolemKitItem());
    public static final RegistrySupplier<Item> TASTY_BONE                 = registerArtifacts("tasty_bone",  new TastyBoneItem());
    public static final RegistrySupplier<Item> WONDERFUL_WHEAT            = registerArtifacts("wonderful_wheat",  new WonderfulWheatItem());
    public static final RegistrySupplier<Item> SATCHEL_OF_SNACKS          = registerArtifacts("satchel_of_snacks", new SatchelOfSnacksItem());
    public static final RegistrySupplier<Item> SATCHEL_OF_ELIXERS         = registerArtifacts("satchel_of_elixers", new SatchelOfElixirsItem());

    protected static RegistrySupplier<Item> registerArtifacts(String id, Item item) {
        return ITEM.register(id, () -> item);
    }

    public static void register() {
        ITEM.init();
    }

}
