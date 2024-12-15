package dev.timefall.mcdar.entity.renderers;

import dev.timefall.mcdar.entity.EnchantedGrassRedSheepEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.util.Identifier;

public class EnchantedGrassRedSheepRenderer extends MobEntityRenderer<EnchantedGrassRedSheepEntity,
        SheepEntityModel<EnchantedGrassRedSheepEntity>> {
    public EnchantedGrassRedSheepRenderer(EntityRendererFactory.Context context){
        super(context, new SheepEntityModel<>(context.getPart(EntityModelLayers.SHEEP)), 0.7F);
        this.addFeature(new EnchantedGrassRedSheepWoolFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(EnchantedGrassRedSheepEntity entity){
        return Identifier.of("textures/entity/sheep/sheep.png");
    }

}
