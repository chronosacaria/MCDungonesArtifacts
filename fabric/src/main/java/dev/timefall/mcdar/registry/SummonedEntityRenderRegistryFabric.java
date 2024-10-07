package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.entities.renderers.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class SummonedEntityRenderRegistryFabric {
    public static void init(){
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfRenderer::new);
        EntityRendererRegistry.register(SummonedEntityRegistryFabric.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaRenderer::new);
    }
}
