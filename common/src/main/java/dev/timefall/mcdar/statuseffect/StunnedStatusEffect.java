package dev.timefall.mcdar.statuseffect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class StunnedStatusEffect extends StatusEffect {
    public StunnedStatusEffect(StatusEffectCategory type, int color) {
        super(type, color);
        //Registry.register(Registries.STATUS_EFFECT, Identifier.of(ModConstants.MOD_ID, id), this);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }

}
