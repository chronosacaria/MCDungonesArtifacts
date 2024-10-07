package dev.timefall.mcdar.api;

import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.enums.*;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;

public class CleanlinessHelper {

    @SuppressWarnings("deprecation")
    public static final net.minecraft.util.math.random.Random RANDOM = Random.createThreadSafe();

    public static void playCenteredSound(LivingEntity center, SoundEvent soundEvent, float volume, float pitch) {
        playCenteredSound(center, soundEvent, SoundCategory.PLAYERS, volume, pitch);
    }

    public static void playCenteredSound(LivingEntity center, SoundEvent soundEvent, SoundCategory soundCategory, float volume, float pitch) {
        center.getWorld().playSound(null,
                center.getX(), center.getY(), center.getZ(),
                soundEvent, soundCategory,
                volume, pitch);
    }

    public static boolean percentToOccur (int chance) {
        return RANDOM.nextInt(100) + 1 <= chance;
    }

    public static void createLoreTTips(ItemStack stack, List<Text> tooltip) {
        String str = stack.getItem().getTranslationKey().toLowerCase(Locale.ROOT).substring(11);
        String translationKey = String.format("tooltip_info_item.mcdar.%s_", str);
        int i = 1;
        while (I18n.hasTranslation(translationKey + i)) {
            tooltip.add(Text.translatable(translationKey + i).formatted(Formatting.ITALIC));
            i++;
        }
    }

    public static void mcdar$dropItem(LivingEntity le, Item item) {
        mcdar$dropItem(le, item, 1);
    }

    public static void mcdar$dropItem(LivingEntity le, ItemStack itemStack) {
        ItemEntity it = new ItemEntity(
                le.getWorld(), le.getX(), le.getY(), le.getZ(),
                itemStack);
        le.getWorld().spawnEntity(it);
    }

    public static void mcdar$dropItem(LivingEntity le, Item item, int amount) {
        mcdar$dropItem(le, new ItemStack(item, amount));
    }

    public static boolean isCoolingDown(PlayerEntity player, Item item) {
        return player.getItemCooldownManager().isCoolingDown(item);
    }

    public static TypedActionResult<ItemStack> mcdar$cleanUseWithOptionalStatus(
            PlayerEntity player,
            Hand hand,
            Item artifact,
            int maxCooldown,
            @Nullable RegistryEntry<StatusEffect> statusEffect,
            @Nullable Integer statusEffectDuration,
            @Nullable Integer statusEffectAmplifier,
            @Nullable RegistryEntry<StatusEffect> statusEffect1,
            @Nullable Integer statusEffectDuration1,
            @Nullable Integer statusEffectAmplifier1,
            @Nullable RegistryEntry<StatusEffect> statusEffect2,
            @Nullable Integer statusEffectDuration2,
            @Nullable Integer statusEffectAmplifier2
    ) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (statusEffect != null && statusEffectDuration != null && statusEffectAmplifier != null) {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(statusEffect, statusEffectDuration, statusEffectAmplifier);
            player.addStatusEffect(statusEffectInstance);
        }
        if (statusEffect1 != null && statusEffectDuration1 != null && statusEffectAmplifier1 != null) {
            StatusEffectInstance statusEffectInstance1 = new StatusEffectInstance(statusEffect1, statusEffectDuration1, statusEffectAmplifier1);
            player.addStatusEffect(statusEffectInstance1);
        }
        if (statusEffect2 != null && statusEffectDuration2 != null && statusEffectAmplifier2 != null) {
            StatusEffectInstance statusEffectInstance2 = new StatusEffectInstance(statusEffect2, statusEffectDuration2, statusEffectAmplifier2);
            player.addStatusEffect(statusEffectInstance2);
        }
        if (!player.isCreative()) {
            EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            itemStack.damage(1, player, equipmentSlot);
        }
        McdarEnchantmentHelper.mcdar$cooldownHelper(player, artifact, maxCooldown);
        return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
    }

    public static ActionResult mcdar$cleanUseSummon(
            ItemUsageContext itemUsageContext,
            Item artifact,
            EntityType<?> summon,
            int cooldown
    ) {
        if (itemUsageContext.getWorld() instanceof ServerWorld serverWorld) {
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();
            if (itemUsageContextPlayer != null) {
                if (SummoningHelper.mcdar$summonSummonableEntity(
                        (LivingEntity) summon.create(serverWorld),
                        itemUsageContextPlayer,
                        itemUsageContext.getBlockPos())) {

                    if (!itemUsageContextPlayer.isCreative()) {
                        Hand hand = itemUsageContext.getHand();
                        EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemUsageContext.getStack().damage(1, itemUsageContextPlayer, equipmentSlot);
                    }

                    McdarEnchantmentHelper.mcdar$cooldownHelper(
                            itemUsageContextPlayer,
                            artifact,
                            cooldown);
                    return ActionResult.CONSUME;
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    public static int mcdar$artifactIDToItemCooldownTime(Item artifactItem) {
        int cooldownLevel = 1/*EnchantmentHelper.getLevel(RegistryEntry.of(EnchantsRegistry.COOLDOWN), artifactItem.getDefaultStack())*/;
        //if (artifactItem instanceof IArtifactItem) {
            for (AgilityArtifactID agilityArtifactID : AgilityArtifactID.values())
                if (artifactItem.asItem() == agilityArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS.get(agilityArtifactID)
                            .mcdar$getIsEnabled())
                    return McdarArtifactsStatsConfig.CONFIG.AGILITY_ARTIFACT_STATS.get(agilityArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
            for (DamagingArtifactID damagingArtifactID : DamagingArtifactID.values())
                if (artifactItem.asItem() == damagingArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.DAMAGING_ARTIFACT_STATS.get(damagingArtifactID)
                            .mcdar$getIsEnabled())
                    return McdarArtifactsStatsConfig.CONFIG.DAMAGING_ARTIFACT_STATS.get(damagingArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
            for (DefensiveArtifactID defensiveArtifactID : DefensiveArtifactID.values())
                if (artifactItem.asItem() == defensiveArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.DEFENSIVE_ARTIFACT_STATS.get(defensiveArtifactID)
                            .mcdar$getIsEnabled() && artifactItem.asItem() != DefensiveArtifactID.SOUL_HEALER.mcdar$getItem())
                    return McdarArtifactsStatsConfig.CONFIG.DEFENSIVE_ARTIFACT_STATS.get(defensiveArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
            for (QuiverArtifactID quiverArtifactID : QuiverArtifactID.values())
                if (artifactItem.asItem() == quiverArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.QUIVER_ARTIFACT_STATS.get(quiverArtifactID)
                            .mcdar$getIsEnabled())
                    return (cooldownLevel + 1) * McdarArtifactsStatsConfig.CONFIG.QUIVER_ARTIFACT_STATS.get(quiverArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
            for (StatusInflictingArtifactID statusInflictingArtifactID : StatusInflictingArtifactID.values())
                if (artifactItem.asItem() == statusInflictingArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.STATUS_INFLICTING_ARTIFACT_STATS.get(statusInflictingArtifactID)
                            .mcdar$getIsEnabled())
                    return McdarArtifactsStatsConfig.CONFIG.STATUS_INFLICTING_ARTIFACT_STATS.get(statusInflictingArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
            for (SummoningArtifactID summoningArtifactID : SummoningArtifactID.values())
                if (artifactItem.asItem() == summoningArtifactID.mcdar$getItem()
                        && McdarArtifactsStatsConfig.CONFIG.SUMMONING_ARTIFACT_STATS.get(summoningArtifactID)
                            .mcdar$getIsEnabled())
                    return McdarArtifactsStatsConfig.CONFIG.SUMMONING_ARTIFACT_STATS.get(summoningArtifactID)
                            .mcdar$getMaxCooldownEnchantmentTime();
        //}
        return 0;
    }
}
