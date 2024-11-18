package dev.timefall.mcdar.client;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.registry.SummonedEntityRenderRegistryFabric;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class McdarClientFabric implements ClientModInitializer {
    @SuppressWarnings({"deprecation", "Note: ResourceManagerHelper.registerBuiltinResourcePack isn't actually deprecated, but overloaded."})
    private static void loadOptionalResourcePack(ModContainer modContainer) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                Identifier.of(ModConstants.MOD_ID, "2dmcdar"),
                modContainer,
                "Legacy MCDAR",
                ResourcePackActivationType.NORMAL);
    }

    @Override
    public void onInitializeClient() {

        //SummonedEntityRenderRegistry.register();
        SummonedEntityRenderRegistryFabric.register();

        // Optional Resource Pack
        FabricLoader.getInstance().getModContainer(ModConstants.MOD_ID).ifPresent(
                McdarClientFabric::loadOptionalResourcePack);
    }
}
