package chronosacaria.mcdar.client;

import chronosacaria.mcdar.Mcdar;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class McdarClient implements ClientModInitializer {
    @SuppressWarnings({"deprecation", "Note: ResourceManagerHelper.registerBuiltinResourcePack isn't actually deprecated, but overloaded."})
    private static void loadOptionalResourcePack(ModContainer modContainer) {
        ResourceManagerHelper.registerBuiltinResourcePack(
                new Identifier(Mcdar.MOD_ID, "2dmcdar"),
                modContainer,
                "Legacy MCDAR",
                ResourcePackActivationType.NORMAL);
    }

    @Override
    public void onInitializeClient() {

        //SummonedEntityRenderRegistry.register();
        SummonedEntityRenderRegistry.init();

        // Optional Resource Pack
        FabricLoader.getInstance().getModContainer(Mcdar.MOD_ID).ifPresent(
                McdarClient::loadOptionalResourcePack);
    }
}
