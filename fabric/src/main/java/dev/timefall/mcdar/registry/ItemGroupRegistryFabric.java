package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

public class ItemGroupRegistryFabric {
    public static final RegistryKey<ItemGroup> MC_DUNGEONS_ARTIFACTS_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, ModConstants.ID("mc_dungeons_artifacts_group_key"));

    public static final ItemGroup MC_DUNGEONS_ARTIFACTS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ArtifactsRegistry.LIGHTNING_ROD))
            .displayName(Text.translatable("itemGroup." + ModConstants.MOD_ID))
            .entries(((displayContext, entries) -> {
                entries.add(ArtifactsRegistry.BOOTS_OF_SWIFTNESS.getDefaultStack());
                entries.add(ArtifactsRegistry.DEATH_CAP_MUSHROOM.getDefaultStack());
                entries.add(ArtifactsRegistry.GHOST_CLOAK.getDefaultStack());
                entries.add(ArtifactsRegistry.LIGHT_FEATHER.getDefaultStack());

                // DAMAGING ARTEFACTS
                entries.add(ArtifactsRegistry.BLAST_FUNGUS);
                // entries.add(ArtifactsRegistry.CORRUPTED_BEACON);
                entries.add(ArtifactsRegistry.HARVESTER);
                entries.add(ArtifactsRegistry.LIGHTNING_ROD);
                entries.add(ArtifactsRegistry.POWERSHAKER);
                entries.add(ArtifactsRegistry.UPDRAFT_TOME);

                // DEFENSIVE ARTEFACTS
                entries.add(ArtifactsRegistry.ENCHANTERS_TOME);
                entries.add(ArtifactsRegistry.IRON_HIDE_AMULET);
                //entries.add(ArtifactsRegistry.SATCHEL_OF_ELIXIRS);
                entries.add(ArtifactsRegistry.SATCHEL_OF_SNACKS);
                entries.add(ArtifactsRegistry.SOUL_HEALER);
                entries.add(ArtifactsRegistry.TOTEM_OF_REGENERATION);
                entries.add(ArtifactsRegistry.TOTEM_OF_SHIELDING);
                entries.add(ArtifactsRegistry.TOTEM_OF_SOUL_PROTECTION);
                entries.add(ArtifactsRegistry.WIND_HORN);

                // QUIVER ARTEFACTS
                entries.add(ArtifactsRegistry.FLAMING_QUIVER);
                entries.add(ArtifactsRegistry.HARPOON_QUIVER);
                entries.add(ArtifactsRegistry.THUNDERING_QUIVER);
                entries.add(ArtifactsRegistry.TORMENT_QUIVER);

                // STATUS INFLICTING ARTEFACTS
                entries.add(ArtifactsRegistry.CORRUPTED_SEEDS);
                entries.add(ArtifactsRegistry.GONG_OF_WEAKENING);
                entries.add(ArtifactsRegistry.LOVE_MEDALLION);
                entries.add(ArtifactsRegistry.SATCHEL_OF_ELEMENTS);
                entries.add(ArtifactsRegistry.SHOCK_POWDER);

                // SUMMONING ARTEFACTS
                entries.add(ArtifactsRegistry.BUZZY_NEST);
                entries.add(ArtifactsRegistry.ENCHANTED_GRASS);
                entries.add(ArtifactsRegistry.GOLEM_KIT);
                entries.add(ArtifactsRegistry.TASTY_BONE);
                entries.add(ArtifactsRegistry.WONDERFUL_WHEAT);
            }))
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, MC_DUNGEONS_ARTIFACTS_GROUP_KEY, MC_DUNGEONS_ARTIFACTS_ITEM_GROUP);
    }
}
