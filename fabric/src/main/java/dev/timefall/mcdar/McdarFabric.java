package dev.timefall.mcdar;

import dev.timefall.mcdar.event.McdarFabricEvents;
import dev.timefall.mcdar.registry.DefaultAttributeRegistryFabric;
import dev.timefall.mcdar.registry.LootRegistryFabric;
import net.fabricmc.api.ModInitializer;

public class McdarFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        McdarCommon.initialize();
        DefaultAttributeRegistryFabric.registerAttributes();
        McdarFabricEvents.registerEvents();
        LootRegistryFabric.register();
    }
}
