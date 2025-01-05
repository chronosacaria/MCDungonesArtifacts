package dev.timefall.mcdar.entity.renderers;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class EnchantedGrassSheepRenderer extends MobEntityRenderer<SheepEntity, SheepEntityModel<SheepEntity>> {
    public EnchantedGrassSheepRenderer(EntityRendererFactory.Context context, DyeColor color) {
        super(context, new SheepEntityModel<>(context.getPart(EntityModelLayers.SHEEP)), 0.7f);
        this.addFeature(new EnchantedGrassSheepWoolFeatureRenderer(this, context.getModelLoader(), color));
    }

    @Override
    public Identifier getTexture(SheepEntity entity){
        return Identifier.of("textures/entity/sheep/sheep.png");
    }
}
