package dev.timefall.mcdar.registry;

import dev.timefall.mcdar.ModConstants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EnchantmentRegistry {
    public static RegistryKey<Enchantment> COOLDOWN = of("cooldown");
    public static RegistryKey<Enchantment> BEAST_BOSS = of("beast_boss");
    public static RegistryKey<Enchantment> BEAST_BURST = of("beast_burst");
    public static RegistryKey<Enchantment> BEAST_SURGE = of("beast_surge");

    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, ModConstants.id(id));
    }

    public static void register() {
    }
}

