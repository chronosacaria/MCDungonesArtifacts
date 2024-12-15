package dev.timefall.mcdar.statuseffect;

import dev.timefall.mcdar.goal.LoveMedallionAttackGoal;
import dev.timefall.mcdar.mixin.MobEntityAccessor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;

public class CharmedStatusEffect extends StatusEffect {
    private LivingEntity entity;

    public CharmedStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
        //Registry.register(Registries.STATUS_EFFECT, Identifier.of(ModConstants.MOD_ID, id), this);
    }

    private static Goal inLoveIdiot;

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        this.entity = entity;
        if (entity instanceof MobEntity mobEntity) {
            inLoveIdiot = new LoveMedallionAttackGoal(mobEntity);
            ((MobEntityAccessor) mobEntity).targetSelector().add(0, inLoveIdiot);
        }
    }

    @Override
    public void onRemoved(AttributeContainer attributes) {
        if (entity != null && entity instanceof MobEntity mobEntity) {
            if (inLoveIdiot != null) {
                ((MobEntityAccessor) mobEntity).targetSelector().remove(inLoveIdiot);
                entity.damage(entity.getWorld().getDamageSources().magic(), (float) attributes.getValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
            }
        }
    }
}
