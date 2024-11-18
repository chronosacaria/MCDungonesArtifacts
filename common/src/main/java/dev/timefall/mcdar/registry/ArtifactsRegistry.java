package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.artifacts.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.InstrumentTags;


public class ArtifactsRegistry {

    // Illager Artifacts
    public static final Item DEATH_CAP_MUSHROOM = new DeathCapMushroomItem();
    public static final Item BLAST_FUNGUS = new BlastFungusItem();
    public static final Item HARVESTER = new HarvesterItem();
    public static final Item LIGHTNING_ROD = new LightningRodItem();
    public static final Item POWERSHAKER = new PowershakerItem();
    public static final Item ENCHANTERS_TOME = new EnchantersTomeItem();
    public static final Item SOUL_HEALER = new SoulHealerItem();
    public static final Item TOTEM_OF_REGENERATION = new TotemOfRegenerationItem();
    public static final Item TOTEM_OF_SHIELDING = new TotemOfShieldingItem();
    public static final Item TOTEM_OF_SOUL_PROTECTION = new TotemOfSoulProtectionItem();
    public static final Item HARPOON_QUIVER = new HarpoonQuiverItem();
    public static final Item THUNDERING_QUIVER = new ThunderingQuiverItem();
    public static final Item TORMENT_QUIVER = new TormentQuiverItem();
    public static final Item CORRUPTED_SEEDS = new CorruptedSeedsItem();
    public static final Item GONG_OF_WEAKENING = new GongOfWeakeningItem();
    public static final Item LOVE_MEDALLION = new LoveMedallionItem();
    public static final Item SATCHEL_OF_ELEMENTS = new SatchelOfElementsItem();
    public static final Item SHOCK_POWDER = new ShockPowderItem();

    // Villager Artifacts
    public static final Item BOOTS_OF_SWIFTNESS = new BootsOfSwiftnessItem();
    public static final Item GHOST_CLOAK = new GhostCloakItem();
    public static final Item LIGHT_FEATHER = new LightFeatherItem();
    public static final Item UPDRAFT_TOME = new UpdraftTomeItem();
    public static final Item IRON_HIDE_AMULET = new IronHideAmuletItem();
    public static final Item WIND_HORN = new WindHornItem(InstrumentTags.GOAT_HORNS);
    public static final Item FLAMING_QUIVER = new FlamingQuiverItem();
    public static final Item BUZZY_NEST = new BuzzyNestItem();
    public static final Item ENCHANTED_GRASS = new EnchantedGrassItem();
    public static final Item GOLEM_KIT = new GolemKitItem();
    public static final Item TASTY_BONE = new TastyBoneItem();
    public static final Item WONDERFUL_WHEAT = new WonderfulWheatItem();
    public static final Item SATCHEL_OF_SNACKS = new SatchelOfSnacksItem();
    public static final Item SATCHEL_OF_ELIXERS = new SatchelOfElixirsItem();

    public static void register() {
        registerArtifacts("death_cap_mushroom", DEATH_CAP_MUSHROOM);
        registerArtifacts("blast_fungus", BLAST_FUNGUS);
        registerArtifacts("harvester", HARVESTER);
        registerArtifacts("lightning_rod", LIGHTNING_ROD);
        registerArtifacts("powershaker", POWERSHAKER);
        registerArtifacts("enchanters_tome", ENCHANTERS_TOME);
        registerArtifacts("soul_healer", SOUL_HEALER);
        registerArtifacts("totem_of_regeneration", TOTEM_OF_REGENERATION);
        registerArtifacts("totem_of_shielding", TOTEM_OF_SHIELDING);
        registerArtifacts("totem_of_soul_protection", TOTEM_OF_SOUL_PROTECTION);
        registerArtifacts("harpoon_quiver", HARPOON_QUIVER);
        registerArtifacts("thundering_quiver", THUNDERING_QUIVER);
        registerArtifacts("torment_quiver", TORMENT_QUIVER);
        registerArtifacts("corrupted_seeds", CORRUPTED_SEEDS);
        registerArtifacts("gong_of_weakening", GONG_OF_WEAKENING);
        registerArtifacts("love_medallion", LOVE_MEDALLION);
        registerArtifacts("satchel_of_elements", SATCHEL_OF_ELEMENTS);
        registerArtifacts("shock_powder", SHOCK_POWDER);

        registerArtifacts("boots_of_swiftness", BOOTS_OF_SWIFTNESS);
        registerArtifacts("ghost_cloak", GHOST_CLOAK);
        registerArtifacts("light_feather", LIGHT_FEATHER);
        registerArtifacts("updraft_tome", UPDRAFT_TOME);
        registerArtifacts("iron_hide_amulet", IRON_HIDE_AMULET);
        registerArtifacts("wind_horn", WIND_HORN);
        registerArtifacts("flaming_quiver", FLAMING_QUIVER);
        registerArtifacts("buzzy_nest", BUZZY_NEST);
        registerArtifacts("enchanted_grass", ENCHANTED_GRASS);
        registerArtifacts("golem_kit", GOLEM_KIT);
        registerArtifacts("tasty_bone", TASTY_BONE);
        registerArtifacts("wonderful_wheat", WONDERFUL_WHEAT);
    }

    protected static void registerArtifacts(String id, Item item) {
        Registry.register(Registries.ITEM, ModConstants.ID(id), item);
    }

}
