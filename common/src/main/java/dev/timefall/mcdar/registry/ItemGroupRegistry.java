package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

public class ItemGroupRegistry {

    private static final Registrar<ItemGroup> ITEM_GROUP = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.ITEM_GROUP);

    public static void register() {
        ITEM_GROUP.init();
        ITEM_GROUP.register("artifacts", () -> ItemGroup.create(null, -1)
                .displayName(Text.translatable("itemGroup.mcdar.artifacts"))
                .icon(() -> new ItemStack(ArtifactsRegistry.LIGHTNING_ROD.get()))
                .entries((displayContext, entries) -> {
                    // AGILITY ARTEFACTS
                    entries.add(ArtifactsRegistry.BOOTS_OF_SWIFTNESS.get());
                    entries.add(ArtifactsRegistry.DEATH_CAP_MUSHROOM.get());
                    entries.add(ArtifactsRegistry.GHOST_CLOAK.get());
                    entries.add(ArtifactsRegistry.LIGHT_FEATHER.get());

                    // DAMAGING ARTEFACTS
                    entries.add(ArtifactsRegistry.BLAST_FUNGUS.get());
                    //entries.add(ArtifactsRegistry.CORRUPTED_BEACON.get());
                    entries.add(ArtifactsRegistry.HARVESTER.get());
                    entries.add(ArtifactsRegistry.LIGHTNING_ROD.get());
                    entries.add(ArtifactsRegistry.POWERSHAKER.get());
                    entries.add(ArtifactsRegistry.UPDRAFT_TOME.get());

                    // DEFENSIVE ARTEFACTS
                    entries.add(ArtifactsRegistry.ENCHANTERS_TOME.get());
                    entries.add(ArtifactsRegistry.IRON_HIDE_AMULET.get());
                    entries.add(ArtifactsRegistry.SATCHEL_OF_ELIXERS.get());
                    entries.add(ArtifactsRegistry.SATCHEL_OF_SNACKS.get());
                    entries.add(ArtifactsRegistry.SOUL_HEALER.get());
                    entries.add(ArtifactsRegistry.TOTEM_OF_REGENERATION.get());
                    entries.add(ArtifactsRegistry.TOTEM_OF_SHIELDING.get());
                    entries.add(ArtifactsRegistry.TOTEM_OF_SOUL_PROTECTION.get());
                    entries.add(ArtifactsRegistry.WIND_HORN.get());

                    // QUIVER ARTEFACTS
                    entries.add(ArtifactsRegistry.FLAMING_QUIVER.get());
                    entries.add(ArtifactsRegistry.HARPOON_QUIVER.get());
                    entries.add(ArtifactsRegistry.THUNDERING_QUIVER.get());
                    entries.add(ArtifactsRegistry.TORMENT_QUIVER.get());


                    // STATUS INFLICTING ARTEFACTS
                    entries.add(ArtifactsRegistry.CORRUPTED_SEEDS.get());
                    entries.add(ArtifactsRegistry.GONG_OF_WEAKENING.get());
                    entries.add(ArtifactsRegistry.LOVE_MEDALLION.get());
                    entries.add(ArtifactsRegistry.SATCHEL_OF_ELEMENTS.get());
                    entries.add(ArtifactsRegistry.SHOCK_POWDER.get());

                    // SUMMONING ARTEFACTS
                    entries.add(ArtifactsRegistry.BUZZY_NEST.get());
                    entries.add(ArtifactsRegistry.ENCHANTED_GRASS.get());
                    entries.add(ArtifactsRegistry.GOLEM_KIT.get());
                    entries.add(ArtifactsRegistry.TASTY_BONE.get());
                    entries.add(ArtifactsRegistry.WONDERFUL_WHEAT.get());
                })
                .build());
    }
}
