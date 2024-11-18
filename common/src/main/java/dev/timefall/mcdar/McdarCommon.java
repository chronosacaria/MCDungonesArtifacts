package dev.timefall.mcdar;

import dev.timefall.mcdar.registry.*;

public class McdarCommon {

    public static void initialize() {
        //CONFIG = AutoConfig.getConfigHolder(McdarConfig.class).getConfig();
        ArtifactsRegistry.register();
        ItemGroupRegistry.register();
        EnchantmentRegistry.register();
        StatusEffectRegistry.register();
        SummonedEntityAttributeRegistry.register();
        //SummonedEntityRegistry.register();
    }
}
