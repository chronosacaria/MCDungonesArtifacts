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
                .add(ArtifactsRegistry.BOOTS_OF_SWIFTNESS.getKey())
                .add(ArtifactsRegistry.GHOST_CLOAK.getKey())
                .add(ArtifactsRegistry.LIGHT_FEATHER.getKey())
                .add(ArtifactsRegistry.UPDRAFT_TOME.getKey())
                .add(ArtifactsRegistry.IRON_HIDE_AMULET.getKey())
                .add(ArtifactsRegistry.WIND_HORN.getKey())
                .add(ArtifactsRegistry.FLAMING_QUIVER.getKey())
                .add(ArtifactsRegistry.BUZZY_NEST.getKey())
                .add(ArtifactsRegistry.ENCHANTED_GRASS.getKey())
                .add(ArtifactsRegistry.GOLEM_KIT.getKey())
                .add(ArtifactsRegistry.TASTY_BONE.getKey())
                .add(ArtifactsRegistry.WONDERFUL_WHEAT.getKey())
                .add(ArtifactsRegistry.SATCHEL_OF_ELIXERS.getKey())
                .add(ArtifactsRegistry.SATCHEL_OF_SNACKS.getKey());
        getOrCreateTagBuilder(TagKeys.ILLAGER_ARTIFACT)
                .add(ArtifactsRegistry.DEATH_CAP_MUSHROOM.getKey())
                .add(ArtifactsRegistry.BLAST_FUNGUS.getKey())
                .add(ArtifactsRegistry.HARVESTER.getKey())
                .add(ArtifactsRegistry.LIGHTNING_ROD.getKey())
                .add(ArtifactsRegistry.POWERSHAKER.getKey())
                .add(ArtifactsRegistry.ENCHANTERS_TOME.getKey())
                .add(ArtifactsRegistry.SOUL_HEALER.getKey())
                .add(ArtifactsRegistry.TOTEM_OF_REGENERATION.getKey())
                .add(ArtifactsRegistry.TOTEM_OF_SHIELDING.getKey())
                .add(ArtifactsRegistry.TOTEM_OF_SOUL_PROTECTION.getKey())
                .add(ArtifactsRegistry.HARPOON_QUIVER.getKey())
                .add(ArtifactsRegistry.THUNDERING_QUIVER.getKey())
                .add(ArtifactsRegistry.TORMENT_QUIVER.getKey())
                .add(ArtifactsRegistry.CORRUPTED_SEEDS.getKey())
                .add(ArtifactsRegistry.GONG_OF_WEAKENING.getKey())
                .add(ArtifactsRegistry.LOVE_MEDALLION.getKey())
                .add(ArtifactsRegistry.SATCHEL_OF_ELEMENTS.getKey())
                .add(ArtifactsRegistry.SHOCK_POWDER.getKey());
        getOrCreateTagBuilder(TagKeys.ALL_ARTIFACT)
                .addOptionalTag(TagKeys.VILLAGER_ARTIFACT)
                .addOptionalTag(TagKeys.ILLAGER_ARTIFACT);
    }
}
