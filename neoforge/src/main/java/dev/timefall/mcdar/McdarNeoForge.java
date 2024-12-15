package dev.timefall.mcdar;

import dev.timefall.mcdar.event.McdarForgeEventHandler;
import dev.timefall.mcdar.registry.DefaultAttributeRegistryNeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ModConstants.MOD_ID)
public class McdarNeoForge {
    public McdarNeoForge(IEventBus modEventBus) {
        McdarCommon.initialize();

        /*
         * Game Event Bus Events
         */
        NeoForge.EVENT_BUS.addListener(McdarForgeEventHandler::mcdar$playerFinishPotionEvent);
        NeoForge.EVENT_BUS.addListener(McdarForgeEventHandler::mcdar$onPowershakerExplodingKill);
        NeoForge.EVENT_BUS.addListener(McdarForgeEventHandler::mcdar$stunnedStatusPreventItemUsage);
        NeoForge.EVENT_BUS.addListener(McdarForgeEventHandler::mcdar$stunnedStatusPreventAttackEntityBlock);
        NeoForge.EVENT_BUS.addListener(McdarForgeEventHandler::mcdar$stunnedStatusPreventAttackBlock);

        /*
         * Mod Event Bus Events
         */
        modEventBus.addListener(DefaultAttributeRegistryNeoForge::registerAttributes);

        ModConstants.LOGGER.info("Hello NeoForge!");
    }
}
