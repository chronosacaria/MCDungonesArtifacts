package dev.timefall.mcdar;

import dev.timefall.mcdar.registry.ItemGroupRegistryFabric;
import dev.timefall.mcdar.registry.LootRegistry;
import dev.timefall.mcdar.registry.SummonedEntityRegistryFabric;
import net.fabricmc.api.ModInitializer;

public class McdarFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ItemGroupRegistryFabric.register();
        SummonedEntityRegistryFabric.register();
        LootRegistry.register();
    }
}
