package dev.timefall.mcdar.client;

import dev.timefall.mcdar.entity.SummonedEntityType;
import dev.timefall.mcdar.entity.renderers.BuzzyNestBeeRenderer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;

import java.util.Map;

public class SummonedEntityRenderers extends EntityRenderers {
    private static final Map<EntityType<?>, EntityRendererFactory<?>> RENDERER_FACTORIES = new Object2ObjectOpenHashMap<>();

    private static <T extends Entity> void register(EntityType<? extends T> type, EntityRendererFactory<T> factory) {
        RENDERER_FACTORIES.put(type, factory);
    }

    static {
        register(SummonedEntityType.BUZZY_NEST_BEE_ENTITY, BuzzyNestBeeRenderer::new);
    }

}
