package chronosacaria.mcdar.artifacts;

import chronosacaria.mcdar.Mcdar;
import chronosacaria.mcdar.api.AOEHelper;
import chronosacaria.mcdar.api.CleanlinessHelper;
import chronosacaria.mcdar.api.McdarEnchantmentHelper;
import chronosacaria.mcdar.enums.StatusInflictingArtifactID;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.List;

public class SatchelOfElementsItem extends ArtifactStatusInflictingItem{
    public SatchelOfElementsItem() {
        super(
                StatusInflictingArtifactID.SATCHEL_OF_ELEMENTS,
                Mcdar.CONFIG.mcdarArtifactsStatsConfig.STATUS_INFLICTING_ARTIFACT_STATS
                        .get(StatusInflictingArtifactID.SATCHEL_OF_ELEMENTS).mcdar$getDurability()
        );
    }

    @Override
    public ActionResult useOnBlock (ItemUsageContext context) {
        if (context.getPlayer() != null && context.getPlayer().getWorld().getServer() != null) {
            ServerPlayerEntity user = context.getPlayer().getWorld().getServer().getPlayerManager().getPlayer(context.getPlayer().getUuid());
            if (user != null) {
                Hand hand = user.getActiveHand();
                ItemStack itemStack = user.getStackInHand(hand);

                if (user.totalExperience >= 15 || user.isCreative()) {
                    AOEHelper.satchelOfElementsEffects(user);

                    if (!user.isCreative()) {
                        user.addExperience(-15);
                        itemStack.damage(1, user, (entity) -> entity.sendToolBreakStatus(hand));
                    }
                    McdarEnchantmentHelper.mcdar$cooldownHelper(
                            user,
                            this
                    );
                    return ActionResult.CONSUME;
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext tooltipContext){
        CleanlinessHelper.createLoreTTips(stack, tooltip);
    }
}
