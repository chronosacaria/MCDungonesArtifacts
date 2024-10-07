package dev.timefall.mcdar.api;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public class McdarEnchantmentHelper {

    public static void mcdar$cooldownHelper(PlayerEntity player, Item item, int maxCooldown) {
        int cooldownLevel = mcdar$getCooldownLevel(EnchantsRegistry.COOLDOWN, player);
        player.getItemCooldownManager().set(item,
                cooldownLevel == 0 ? maxCooldown :
                        (int) (maxCooldown - (maxCooldown * mcdar$cooldownCalcHelper(cooldownLevel))));
    }

    public static void mcdar$cooldownHelper(PlayerEntity player, Item item) {
        int cooldownLevel = mcdar$getCooldownLevel(EnchantsRegistry.COOLDOWN, player);
        int maxCooldown = CleanlinessHelper.mcdar$artifactIDToItemCooldownTime(item);
        player.getItemCooldownManager().set(item,
                cooldownLevel == 0 ? maxCooldown :
                        (int) (maxCooldown - (maxCooldown * mcdar$cooldownCalcHelper(cooldownLevel))));
    }

    public static float mcdar$cooldownCalcHelper(int level) {
        float modifier = 0.18f;
        for (int i = 0 ; i < level - 1 ; i++) {
            float j = 0.11f - (0.02f * i);
            // Level 1: 18
            // 2 onward : 29, 38, 45, 51, 55, 58, 61, 64, 67, 71, 73
            modifier += Math.max(j == 5 || j == 3 ? j + 1 : j, 0.03f);
        }
        return modifier;
    }

    public static int mcdar$getCooldownLevel(Enchantment enchantment, PlayerEntity playerEntity){
        int totalLevel = 0;
        for (ItemStack itemStack : enchantment.getEquipment(playerEntity).values())
            totalLevel += EnchantmentHelper.getLevel(RegistryEntry.of(enchantment), itemStack);

        return totalLevel;
    }
}
