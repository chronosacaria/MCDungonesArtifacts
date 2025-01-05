package dev.timefall.mcdar.statuseffect;

import dev.timefall.mcdar.goal.LoveMedallionAttackGoal;
import dev.timefall.mcdar.mixin.MobEntityAccessor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.MobEntity;

public class CooldownResetStatusEffect extends StatusEffect {
    //TODO get mixin to grab this properly from the call sites
    private LivingEntity entity;

    public CooldownResetStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        this.entity = entity;
        if (entity instanceof MobEntity mobEntity) {
            for (PrioritizedGoal prioritizedGoal : ((MobEntityAccessor) mobEntity).targetSelector().getGoals()) {
                if (prioritizedGoal.getGoal() instanceof LoveMedallionAttackGoal) {
                    return;
                }
            }
            ((MobEntityAccessor) mobEntity).targetSelector().add(0, new LoveMedallionAttackGoal(mobEntity));
        }
    }

    @Override
    public void onRemoved(AttributeContainer attributes) {
        if (entity != null && entity instanceof MobEntity mobEntity) {
            Goal goal = null;
            for (PrioritizedGoal prioritizedGoal : ((MobEntityAccessor) mobEntity).targetSelector().getGoals()) {
                if (prioritizedGoal.getGoal() instanceof LoveMedallionAttackGoal) {
                    goal = prioritizedGoal.getGoal();
                    break;
                }
            }
            if (goal != null) {
                ((MobEntityAccessor) mobEntity).targetSelector().remove(goal);
                entity.damage(entity.getWorld().getDamageSources().magic(), (float) attributes.getValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));
            }
        }
    }
}
