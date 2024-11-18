package dev.timefall.mcdar.data.providers;

import dev.timefall.mcdar.registry.EnchantmentRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.block.Block;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class McdarEnchantmentsProvider extends FabricDynamicRegistryProvider {
    public McdarEnchantmentsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "Mcdar Enchantment Generation";
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
        RegistryEntryLookup<DamageType> damageTypeLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.DAMAGE_TYPE);
        RegistryEntryLookup<Enchantment> enchantmentLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntryLookup<Item> itemLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.ITEM);
        RegistryEntryLookup<Block> blockLookup = wrapperLookup.getWrapperOrThrow(RegistryKeys.BLOCK);

        // COOLDOWN
        register(
                entries,
                EnchantmentRegistry.COOLDOWN,
                Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                1,
                                3,
                                Enchantment.leveledCost(1, 10),
                                Enchantment.leveledCost(16, 10),
                                2,
                                AttributeModifierSlot.ARMOR
                        )
                )
        );
        register(
                entries,
                EnchantmentRegistry.BEAST_BOSS,
                Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                1,
                                3,
                                Enchantment.leveledCost(1, 10),
                                Enchantment.leveledCost(16, 10),
                                2,
                                AttributeModifierSlot.ARMOR
                        )
                )
        );
        register(
                entries,
                EnchantmentRegistry.BEAST_BURST,
                Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                1,
                                3,
                                Enchantment.leveledCost(1, 10),
                                Enchantment.leveledCost(16, 10),
                                2,
                                AttributeModifierSlot.ARMOR
                        )
                )
        );
        register(
                entries,
                EnchantmentRegistry.BEAST_SURGE,
                Enchantment.builder(
                        Enchantment.definition(
                                itemLookup.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                                1,
                                3,
                                Enchantment.leveledCost(1, 10),
                                Enchantment.leveledCost(16, 10),
                                2,
                                AttributeModifierSlot.ARMOR
                        )
                )
        );
    }

    private void register(Entries entries, RegistryKey<Enchantment> enchantmentRegistryKey, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(enchantmentRegistryKey, builder.build(enchantmentRegistryKey.getValue()), resourceConditions);
    }

}
