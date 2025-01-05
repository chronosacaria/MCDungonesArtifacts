package dev.timefall.mcdar.client.registry;

import dev.timefall.mcdar.entity.*;
import dev.timefall.mcdar.registry.SummonedEntityRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class SummonedEntityAttributeRegistryFabric {
    public static void register() {
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeEntity.createBeeAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepEntity.createEnchantedBlueSheepAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepEntity.createEnchantedGreenSheepAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepEntity.createEnchantedRedSheepAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemEntity.createIronGolemAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfEntity.createTastyBoneWolfAttributes());
        FabricDefaultAttributeRegistry.register(SummonedEntityRegistry.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaEntity
         .createWonderfulWheatLlamaAttributes());
    }
}
