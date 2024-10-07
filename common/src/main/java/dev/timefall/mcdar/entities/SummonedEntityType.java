package dev.timefall.mcdar.entities;

import dev.timefall.mcdar.ModConstants;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Vec3d;

public class SummonedEntityType {

    public static final EntityType<BuzzyNestBeeEntity> BUZZY_NEST_BEE_ENTITY = registerEntity(
            "buzzy_nest_bee",
            EntityType.Builder.create(BuzzyNestBeeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.7F, 0.6F)
                    .eyeHeight(0.3F)
                    .build(ModConstants.ID("buzzy_nest_bee").toString())
    );
    public static final EntityType<EnchantedGrassGreenSheepEntity> ENCHANTED_GRASS_GREEN_SHEEP_ENTITY = registerEntity(
            "enchanted_grass_green_sheep",
            EntityType.Builder.create(EnchantedGrassGreenSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9F, 1.3F)
                    .eyeHeight(1.235F)
                    .passengerAttachments(1.2375F)
                    //.maxTrackingRange(10)
                    .build(ModConstants.ID("enchanted_grass_green_sheep").toString())
    );
    public static final EntityType<EnchantedGrassBlueSheepEntity> ENCHANTED_GRASS_BLUE_SHEEP_ENTITY = registerEntity(
            "enchanted_grass_blue_sheep",
            EntityType.Builder.create(EnchantedGrassBlueSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9F, 1.3F)
                    .eyeHeight(1.235F)
                    .passengerAttachments(1.2375F)
                    //.maxTrackingRange(10)
                    .build(ModConstants.ID("enchanted_grass_blue_sheep").toString())
    );
    public static final EntityType<EnchantedGrassRedSheepEntity> ENCHANTED_GRASS_RED_SHEEP_ENTITY = registerEntity(
            "enchanted_grass_red_sheep",
            EntityType.Builder.create(EnchantedGrassRedSheepEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9F, 1.3F)
                    .eyeHeight(1.235F)
                    .passengerAttachments(1.2375F)
                    //.maxTrackingRange(10)
                    .build(ModConstants.ID("enchanted_grass_red_sheep").toString())
    );
    public static final EntityType<GolemKitGolemEntity> GOLEM_KIT_GOLEM_ENTITY = registerEntity(
            "golem_kit_golem",
            EntityType.Builder.create(GolemKitGolemEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 2.7f)
                    .build(ModConstants.ID("golem_kit_golem").toString())
    );
    public static final EntityType<TastyBoneWolfEntity> TASTY_BONE_WOLF_ENTITY = registerEntity(
            "tasty_bone_wolf",
            EntityType.Builder.create(TastyBoneWolfEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.6f, 0.85f)
                    .eyeHeight(0.68F)
                    .passengerAttachments(new Vec3d(0.0, 0.81875, -0.0625))
                    .build(ModConstants.ID("tasty_bone_wolf").toString())
    );
    public static final EntityType<WonderfulWheatLlamaEntity> WONDERFUL_WHEAT_LLAMA_ENTITY = registerEntity(
            "wonderful_wheat_llama",
            EntityType.Builder.create(WonderfulWheatLlamaEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9F, 1.87F)
                    .eyeHeight(1.7765F)
                    .passengerAttachments(new Vec3d(0.0, 1.37, -0.3))
                    .build(ModConstants.ID("wonderful_wheat_llama").toString())
    );

    private static <T extends Entity> EntityType<T> registerEntity(String id, EntityType<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, ModConstants.ID(id), type);
    }
}
