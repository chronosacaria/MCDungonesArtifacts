package chronosacaria.mcdar.artefacts;

import chronosacaria.mcdar.Mcdar;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.List;

import static chronosacaria.mcdar.api.AOECloudHelper.spawnShieldingCloudAtPos;

public class TotemOfShieldingItem extends ArtefactDefenciveItem{
    public TotemOfShieldingItem(Settings settings, String id) {
        super(settings);
        Registry.register(Registry.ITEM, new Identifier(Mcdar.MOD_ID, id), this);
    }

    public ActionResult useOnBlock (ItemUsageContext itemUsageContext){
        World world = itemUsageContext.getWorld();

        if (world.isClient){
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemUsageContextItem = itemUsageContext.getStack();
            PlayerEntity itemUsageContextPlayer = itemUsageContext.getPlayer();
            Hand itemUseContextHand = itemUsageContext.getHand();
            BlockPos itemUseContextBlockPos = itemUsageContext.getBlockPos();
            Direction itemUseContextFacing = itemUsageContext.getPlayerFacing();
            BlockState blockState = world.getBlockState(itemUseContextBlockPos);

            BlockPos blockPos;
            if (blockState.getCollisionShape(world, itemUseContextBlockPos).isEmpty()){
                blockPos = itemUseContextBlockPos;
            } else {
                blockPos = itemUseContextBlockPos.offset(itemUseContextFacing);
            }
            if (itemUsageContextPlayer != null){

                spawnShieldingCloudAtPos(itemUsageContextPlayer,blockPos, 500);
                if (!itemUsageContextPlayer.isCreative()){
                    itemUsageContextItem.damage(1, itemUsageContextPlayer,
                            (entity) -> entity.sendToolBreakStatus(itemUseContextHand));
                }
                itemUsageContextPlayer.getItemCooldownManager().set(this, 500);
            }
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.totem_of_shielding_1").formatted(Formatting.ITALIC));
        tooltip.add(new TranslatableText("tooltip_info_item.mcdar.totem_of_shielding_2").formatted(Formatting.ITALIC));
    }
}