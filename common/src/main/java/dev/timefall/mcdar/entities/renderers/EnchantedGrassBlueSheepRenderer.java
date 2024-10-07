package dev.timefall.mcdar.entities.renderers;

import dev.timefall.mcdar.entities.EnchantedGrassBlueSheepEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.util.Identifier;

public class EnchantedGrassBlueSheepRenderer extends MobEntityRenderer<EnchantedGrassBlueSheepEntity, SheepEntityModel<EnchantedGrassBlueSheepEntity>> {
    public EnchantedGrassBlueSheepRenderer(EntityRendererFactory.Context context){
        super(context, new SheepEntityModel<>(context.getPart(EntityModelLayers.SHEEP)), 0.7f);
        this.addFeature(new EnchantedGrassBlueSheepWoolFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(EnchantedGrassBlueSheepEntity entity){
        return Identifier.of("textures/entity/sheep/sheep.png");
    }
}
