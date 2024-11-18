package dev.timefall.mcdar.data.providers;

import dev.timefall.mcdar.registry.ArtifactsRegistry;
import dev.timefall.mcdar.registry.tag.TagKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class McdarTagProvider extends FabricTagProvider.ItemTagProvider {

    public McdarTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(TagKeys.VILLAGER_ARTIFACT)
                .add(ArtifactsRegistry.BOOTS_OF_SWIFTNESS)
                .add(ArtifactsRegistry.GHOST_CLOAK)
                .add(ArtifactsRegistry.LIGHT_FEATHER)
                .add(ArtifactsRegistry.UPDRAFT_TOME)
                .add(ArtifactsRegistry.IRON_HIDE_AMULET)
                .add(ArtifactsRegistry.WIND_HORN)
                .add(ArtifactsRegistry.FLAMING_QUIVER)
                .add(ArtifactsRegistry.BUZZY_NEST)
                .add(ArtifactsRegistry.ENCHANTED_GRASS)
                .add(ArtifactsRegistry.GOLEM_KIT)
                .add(ArtifactsRegistry.TASTY_BONE)
                .add(ArtifactsRegistry.WONDERFUL_WHEAT)
                .add(ArtifactsRegistry.SATCHEL_OF_ELIXERS)
                .add(ArtifactsRegistry.SATCHEL_OF_SNACKS);
        getOrCreateTagBuilder(TagKeys.ILLAGER_ARTIFACT)
                .add(ArtifactsRegistry.DEATH_CAP_MUSHROOM)
                .add(ArtifactsRegistry.BLAST_FUNGUS)
                .add(ArtifactsRegistry.HARVESTER)
                .add(ArtifactsRegistry.LIGHTNING_ROD)
                .add(ArtifactsRegistry.POWERSHAKER)
                .add(ArtifactsRegistry.ENCHANTERS_TOME)
                .add(ArtifactsRegistry.SOUL_HEALER)
                .add(ArtifactsRegistry.TOTEM_OF_REGENERATION)
                .add(ArtifactsRegistry.TOTEM_OF_SHIELDING)
                .add(ArtifactsRegistry.TOTEM_OF_SOUL_PROTECTION)
                .add(ArtifactsRegistry.HARPOON_QUIVER)
                .add(ArtifactsRegistry.THUNDERING_QUIVER)
                .add(ArtifactsRegistry.TORMENT_QUIVER)
                .add(ArtifactsRegistry.CORRUPTED_SEEDS)
                .add(ArtifactsRegistry.GONG_OF_WEAKENING)
                .add(ArtifactsRegistry.LOVE_MEDALLION)
                .add(ArtifactsRegistry.SATCHEL_OF_ELEMENTS)
                .add(ArtifactsRegistry.SHOCK_POWDER);
        getOrCreateTagBuilder(TagKeys.ALL_ARTIFACT)
                .addOptionalTag(TagKeys.VILLAGER_ARTIFACT)
                .addOptionalTag(TagKeys.ILLAGER_ARTIFACT);
    }
}
