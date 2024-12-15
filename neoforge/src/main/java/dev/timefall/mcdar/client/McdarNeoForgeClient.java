package dev.timefall.mcdar.client;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.client.registry.SummonedEntityRenderRegistryNeoForge;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = ModConstants.MOD_ID, dist = {Dist.CLIENT})
public class McdarNeoForgeClient {
    public McdarNeoForgeClient(IEventBus modEventBus) {
        modEventBus.addListener(SummonedEntityRenderRegistryNeoForge::register);
    }
}
