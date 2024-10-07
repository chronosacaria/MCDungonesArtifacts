package dev.timefall.mcdar;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ModConstants.MOD_ID)
public class McdarNeoForge {
    public McdarNeoForge(IEventBus modEventBus) {
        ModConstants.LOGGER.info("Hello NeoForge!");
        McdarCommon.initialize();
    }
}
