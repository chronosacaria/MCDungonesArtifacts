package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.enums.*;
import dev.timefall.mcdar.registries.ArtifactsRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

public class ItemGroupRegistryFabric {

    public static void register() {
            Registry.register(Registries.ITEM_GROUP, ModConstants.ARTIFACTS, FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.mcdar.artifacts"))
                    .icon(() -> new ItemStack(ArtifactsRegistry.LIGHTNING_ROD)))
                    .entries((displayContext, entries) -> {
                        entries.add(ArtifactsRegistry.AGILITY_ARTIFACT.get(AgilityArtifactID.BOOTS_OF_SWIFTNESS));
                        entries.add(ArtifactsRegistry.AGILITY_ARTIFACT.get(AgilityArtifactID.DEATH_CAP_MUSHROOM));
                        entries.add(ArtifactsRegistry.AGILITY_ARTIFACT.get(AgilityArtifactID.GHOST_CLOAK));
                        entries.add(ArtifactsRegistry.AGILITY_ARTIFACT.get(AgilityArtifactID.LIGHT_FEATHER));

                        // DAMAGING ARTEFACTS
                        entries.add(ArtifactsRegistry.BLAST_FUNGUS));
                        // entries.add(ArtifactsRegistry.CORRUPTED_BEACON));
                        entries.add(ArtifactsRegistry.HARVESTER));
                        entries.add(ArtifactsRegistry.LIGHTNING_ROD));
                        entries.add(ArtifactsRegistry.POWERSHAKER));
                        entries.add(ArtifactsRegistry.UPDRAFT_TOME));

                        // DEFENSIVE ARTEFACTS
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.ENCHANTERS_TOME));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.IRON_HIDE_AMULET));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.SATCHEL_OF_ELIXIRS));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.SATCHEL_OF_SNACKS));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.SOUL_HEALER));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.TOTEM_OF_REGENERATION));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.TOTEM_OF_SHIELDING));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.TOTEM_OF_SOUL_PROTECTION));
                        entries.add(ArtifactsRegistry.DEFENSIVE_ARTIFACT.get(DefensiveArtifactID.WIND_HORN));

                        // QUIVER ARTEFACTS
                        entries.add(ArtifactsRegistry.QUIVER_ARTIFACT.get(QuiverArtifactID.FLAMING_QUIVER));
                        entries.add(ArtifactsRegistry.QUIVER_ARTIFACT.get(QuiverArtifactID.HARPOON_QUIVER));
                        entries.add(ArtifactsRegistry.QUIVER_ARTIFACT.get(QuiverArtifactID.THUNDERING_QUIVER));
                        entries.add(ArtifactsRegistry.QUIVER_ARTIFACT.get(QuiverArtifactID.TORMENT_QUIVER));


                        // STATUS INFLICTING ARTEFACTS
                        entries.add(ArtifactsRegistry.STATUS_INFLICTING_ARTIFACT.get(StatusInflictingArtifactID.CORRUPTED_SEEDS));
                        entries.add(ArtifactsRegistry.STATUS_INFLICTING_ARTIFACT.get(StatusInflictingArtifactID.GONG_OF_WEAKENING));
                        entries.add(ArtifactsRegistry.STATUS_INFLICTING_ARTIFACT.get(StatusInflictingArtifactID.LOVE_MEDALLION));
                        entries.add(ArtifactsRegistry.STATUS_INFLICTING_ARTIFACT.get(StatusInflictingArtifactID.SATCHEL_OF_ELEMENTS));
                        entries.add(ArtifactsRegistry.STATUS_INFLICTING_ARTIFACT.get(StatusInflictingArtifactID.SHOCK_POWDER));

                        // SUMMONING ARTEFACTS
                        entries.add(ArtifactsRegistry.SUMMONING_ARTIFACT.get(SummoningArtifactID.BUZZY_NEST));
                        entries.add(ArtifactsRegistry.SUMMONING_ARTIFACT.get(SummoningArtifactID.ENCHANTED_GRASS));
                        entries.add(ArtifactsRegistry.SUMMONING_ARTIFACT.get(SummoningArtifactID.GOLEM_KIT));
                        entries.add(ArtifactsRegistry.SUMMONING_ARTIFACT.get(SummoningArtifactID.TASTY_BONE));
                        entries.add(ArtifactsRegistry.SUMMONING_ARTIFACT.get(SummoningArtifactID.WONDERFUL_WHEAT));
                    })
                    .build());
    }
}
