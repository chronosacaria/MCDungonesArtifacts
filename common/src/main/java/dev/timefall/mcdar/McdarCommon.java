package dev.timefall.mcdar;

import dev.timefall.mcdar.registry.*;

public class McdarCommon {

    public static void initialize() {
        ArtifactsRegistry.register();
        ItemGroupRegistry.register();
        EnchantmentRegistry.register();
        StatusEffectRegistry.register();
        SummonedEntityRegistry.register();
    }
}
