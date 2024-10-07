package dev.timefall.mcdar.registries;

import dev.timefall.mcdar.entities.*;
import dev.timefall.mcdar.mixin.DefaultAttributeRegistryAccessor;

public class SummonedEntityAttributeRegistry {

    private static void registerAttributes() {
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeEntity.createBeeAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.ENCHANTED_GRASS_GREEN_SHEEP_ENTITY, EnchantedGrassGreenSheepEntity.createEnchantedGreenSheepAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.ENCHANTED_GRASS_BLUE_SHEEP_ENTITY, EnchantedGrassBlueSheepEntity.createEnchantedBlueSheepAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.ENCHANTED_GRASS_RED_SHEEP_ENTITY, EnchantedGrassRedSheepEntity.createEnchantedRedSheepAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.GOLEM_KIT_GOLEM_ENTITY, GolemKitGolemEntity.createIronGolemAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.TASTY_BONE_WOLF_ENTITY, TastyBoneWolfEntity.createTastyBoneWolfAttributes().build());
        DefaultAttributeRegistryAccessor.getRegistry().put(SummonedEntityType.WONDERFUL_WHEAT_LLAMA_ENTITY, WonderfulWheatLlamaEntity.createWonderfulWheatLlamaAttributes().build());
    }

    public static void register() {
        registerAttributes();
    }

}
