package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class DefaultAttributeRegistryFabric {

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(SummonedEntityType.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeEntity.createBeeAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepEntity.createEnchantedGreenSheepAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepEntity.createEnchantedBlueSheepAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepEntity.createEnchantedRedSheepAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemEntity.createIronGolemAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfEntity.createTastyBoneWolfAttributes().build());
        FabricDefaultAttributeRegistry.register(SummonedEntityType.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaEntity.createWonderfulWheatLlamaAttributes().build());
    }
}
