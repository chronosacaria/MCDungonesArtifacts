package dev.timefall.mcdar.registry;

import com.mojang.serialization.MapCodec;
import dev.timefall.mcdar.ModConstants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class EnchantmentRegistry {
    public static RegistryKey<Enchantment> COOLDOWN = of("cooldown");
    public static RegistryKey<Enchantment> BEAST_BOSS = of("beast_boss");
    public static RegistryKey<Enchantment> BEAST_BURST = of("beast_burst");
    public static RegistryKey<Enchantment> BEAST_SURGE = of("beast_surge");


    private static <T extends EnchantmentEntityEffect>MapCodec<T> registerEnchantmentEffect(String id, MapCodec<T> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, ModConstants.ID(id), codec);
    }

    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, ModConstants.ID(id));
    }

    public static void register() {
    }
}

