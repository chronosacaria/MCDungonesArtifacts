package dev.timefall.mcdar.enchants;
/*
import dev.timefall.mcdar.McdarCommon;
import dev.timefall.mcdar.registries.ItemGroupRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public class BeastBurstEnchantment extends Enchantment {

    public BeastBurstEnchantment(Rarity rarity, EnchantmentTarget enchantmentTarget, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentTarget, equipmentSlots);
        if (McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsEnabled()) {
            Registry.register(Registries.ENCHANTMENT, McdarCommon.ID("beast_burst"), this);
            ItemGroupEvents.modifyEntriesEvent(ItemGroupRegistry.ARTIFACTS).register(entries -> {
                // For loop creates first 3 levels of enchanted books
                for (int i = 1; i <= getMaxLevel(); i++)
                    entries.add(EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(this, i)));
            });
        }
    }

    @Override
    public int getMaxLevel(){
        return McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getMaxLevel();
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsEnabled()
                && McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsAvailableForRandomSelection();
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsEnabled()
                && McdarCommon.CONFIG.mcdarEnchantmentsConfig.ENCHANTMENT_CONFIG.get(EnchantmentsID.BEAST_BURST).mcdar$getIsAvailableForEnchantedBookOffer();
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ArmorItem;
    }

}

 */
