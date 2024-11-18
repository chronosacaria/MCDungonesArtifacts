package dev.timefall.mcdar.artifacts;

import dev.timefall.mcdar.api.CleanlinessHelper;
import dev.timefall.mcdar.api.SummoningHelper;
import dev.timefall.mcdar.config.McdarArtifactsStatsConfig;
import dev.timefall.mcdar.effects.EnchantmentEffects;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.List;

public class EnchantedGrassItem extends ArtifactSummoningItem{
    public EnchantedGrassItem() {
        super(
                McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().ENCHANTED_GRASS_STATS.mcdar$getDurability()
        );
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        int maxCooldownEnchantmentTime = McdarArtifactsStatsConfig.CONFIG.mcdar$getSummoningArtifactStats().ENCHANTED_GRASS_STATS.mcdar$getMaxCooldownEnchantmentTime();
        int modifiedCooldownEnchantmentTime = EnchantmentEffects.cooldownEffect(maxCooldownEnchantmentTime, itemUsageContext.getPlayer(), itemUsageContext.getWorld());

        if (itemUsageContext.getWorld() instanceof ServerWorld serverWorld) {
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();

            if (itemUsageContextPlayer != null) {

                int effectInt = CleanlinessHelper.RANDOM.nextInt(3);
                SheepEntity sheep = SummoningHelper.SHEEP.get(effectInt).create(serverWorld);

                if (SummoningHelper.mcdar$summonSummonableEntity(sheep, itemUsageContextPlayer, itemUsageContext.getBlockPos())) {
                    if (sheep != null && CleanlinessHelper.percentToOccur(1))
                        sheep.setCustomName(Text.literal("Lilly"));
                    SummoningHelper.mcdar$summonedSheepEffect(sheep, effectInt);

                    if (!itemUsageContextPlayer.isCreative()) {
                        Hand hand = itemUsageContext.getHand();
                        EquipmentSlot equipmentSlot = hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                        itemUsageContext.getStack().damage(1, itemUsageContextPlayer, equipmentSlot);
                    }


                    itemUsageContextPlayer.getItemCooldownManager().set(this, modifiedCooldownEnchantmentTime);
                    return ActionResult.CONSUME;
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext tooltipContext, List<Text> tooltip, TooltipType type){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
