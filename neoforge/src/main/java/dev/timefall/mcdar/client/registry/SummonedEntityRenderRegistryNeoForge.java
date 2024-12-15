package dev.timefall.mcdar.client.registry;

import dev.timefall.mcdar.entity.renderers.*;
import dev.timefall.mcdar.registry.SummonedEntityRegistry;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

public class SummonedEntityRenderRegistryNeoForge {

    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SummonedEntityRegistry.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfRenderer::new);
        event.registerEntityRenderer(SummonedEntityRegistry.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaRenderer::new);
    }
}
