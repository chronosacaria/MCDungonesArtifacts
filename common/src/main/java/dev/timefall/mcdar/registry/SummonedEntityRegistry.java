package dev.timefall.mcdar.registry;

import com.google.common.collect.Maps;
import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.entity.*;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.registry.Registries;

import java.util.Map;

public class SummonedEntityRegistry {

    private static final Registrar<EntityType<?>> ENTITY_TYPE = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.ENTITY_TYPE);

    public static final Map<EntityType<? extends LivingEntity>, DefaultAttributeContainer> ATTRIBUTES =
            Maps.newHashMap();
    public static final EntityType<BuzzyNestBeeEntity> BUZZY_NEST_BEE_ENTITY =
            EntityType.Builder
                    .create(BuzzyNestBeeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<EnchantedGrassGreenSheepEntity> ENCHANTED_GRASS_GREEN_SHEEP_ENTITY =
            EntityType.Builder
                    .create(EnchantedGrassGreenSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<EnchantedGrassBlueSheepEntity> ENCHANTED_GRASS_BLUE_SHEEP_ENTITY =
            EntityType.Builder
                    .create(EnchantedGrassBlueSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<EnchantedGrassRedSheepEntity> ENCHANTED_GRASS_RED_SHEEP_ENTITY =
            EntityType.Builder
                    .create(EnchantedGrassRedSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<GolemKitGolemEntity> GOLEM_KIT_GOLEM_ENTITY =
            EntityType.Builder
                    .create(GolemKitGolemEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<TastyBoneWolfEntity> TASTY_BONE_WOLF_ENTITY =
            EntityType.Builder
                    .create(TastyBoneWolfEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);
    public static final EntityType<WonderfulWheatLlamaEntity> WONDERFUL_WHEAT_LLAMA_ENTITY =
            EntityType.Builder
                    .create(WonderfulWheatLlamaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1, 2)
                    .build(null);

    public static void register() {
        ENTITY_TYPE.init();
        registerEntity("buzzy_nest_bee", BeeEntity.createBeeAttributes(), BUZZY_NEST_BEE_ENTITY);
        registerEntity("enchanted_blue_sheep", EnchantedGrassBlueSheepEntity.createEnchantedBlueSheepAttributes(), ENCHANTED_GRASS_BLUE_SHEEP_ENTITY);
        registerEntity("enchanted_green_sheep", EnchantedGrassGreenSheepEntity.createEnchantedGreenSheepAttributes(), ENCHANTED_GRASS_GREEN_SHEEP_ENTITY);
        registerEntity("enchanted_red_sheep", EnchantedGrassRedSheepEntity.createEnchantedRedSheepAttributes(), ENCHANTED_GRASS_RED_SHEEP_ENTITY);
        registerEntity("golem_kit_golem", IronGolemEntity.createIronGolemAttributes(), GOLEM_KIT_GOLEM_ENTITY);
        registerEntity("tasty_bone_wolf", TastyBoneWolfEntity.createTastyBoneWolfAttributes(), TASTY_BONE_WOLF_ENTITY);
        registerEntity("wonderful_wheat_llama", WonderfulWheatLlamaEntity.createWonderfulWheatLlamaAttributes(), WONDERFUL_WHEAT_LLAMA_ENTITY);
    }

    public static void registerEntity(String name,
                                      DefaultAttributeContainer.Builder attributes,
                                      EntityType<? extends LivingEntity> entityType){
        ENTITY_TYPE.register(name, () -> entityType);
    }
}
