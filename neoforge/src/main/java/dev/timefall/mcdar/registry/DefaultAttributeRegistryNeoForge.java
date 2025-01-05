package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.entity.*;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class DefaultAttributeRegistryNeoForge {

    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SummonedEntityRegistry.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeEntity.createBeeAttributes().build());
        event.put(SummonedEntityRegistry.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepEntity.createEnchantedGreenSheepAttributes().build());
        event.put(SummonedEntityRegistry.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepEntity.createEnchantedBlueSheepAttributes().build());
        event.put(SummonedEntityRegistry.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepEntity.createEnchantedRedSheepAttributes().build());
        event.put(SummonedEntityRegistry.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemEntity.createIronGolemAttributes().build());
        event.put(SummonedEntityRegistry.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfEntity.createTastyBoneWolfAttributes().build());
        event.put(SummonedEntityRegistry.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaEntity.createWonderfulWheatLlamaAttributes().build());
    }
}
