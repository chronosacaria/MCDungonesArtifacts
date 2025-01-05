package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import dev.timefall.mcdar.statuseffect.CharmedStatusEffect;
import dev.timefall.mcdar.statuseffect.ShieldingStatusEffect;
import dev.timefall.mcdar.statuseffect.SoulProtectionStatusEffect;
import dev.timefall.mcdar.statuseffect.StunnedStatusEffect;
import me.fzzyhmstrs.fzzy_config.api.ConfigApiJava;
import me.fzzyhmstrs.fzzy_config.util.platform.Registrar;
import me.fzzyhmstrs.fzzy_config.util.platform.RegistrySupplier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;

public class StatusEffectRegistry {

    private static final Registrar<StatusEffect> STATUS_EFFECT = ConfigApiJava.platform().createRegistrar(ModConstants.MOD_ID, Registries.STATUS_EFFECT);

    public static RegistrySupplier<StatusEffect> CHARMED         = registerStatus("charmed", new CharmedStatusEffect(StatusEffectCategory.HARMFUL, 0xC7005B));
    public static RegistrySupplier<StatusEffect> SHIELDING       = registerStatus("shielding", new ShieldingStatusEffect(StatusEffectCategory.BENEFICIAL, 0x808080));
    public static RegistrySupplier<StatusEffect> SOUL_PROTECTION = registerStatus("soul_protection", new SoulProtectionStatusEffect(StatusEffectCategory.BENEFICIAL, 0x2552a5));
    public static RegistrySupplier<StatusEffect> STUNNED         = registerStatus("stunned", new StunnedStatusEffect(StatusEffectCategory.HARMFUL, 0xFFFF00));

    protected static RegistrySupplier<StatusEffect> registerStatus(String id, StatusEffect statusEffect) {
        return STATUS_EFFECT.register(id, () -> statusEffect);
    }

    public static void register() {}
}
