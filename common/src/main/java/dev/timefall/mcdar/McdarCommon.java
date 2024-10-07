package dev.timefall.mcdar;

import dev.timefall.mcdar.registries.ArtifactsRegistry;
import dev.timefall.mcdar.registries.ItemGroupRegistry;
import dev.timefall.mcdar.registries.StatusEffectRegistry;
import dev.timefall.mcdar.registries.SummonedEntityAttributeRegistry;

public class McdarCommon {

    public static void initialize() {
        //CONFIG = AutoConfig.getConfigHolder(McdarConfig.class).getConfig();
        ArtifactsRegistry.register();
        ItemGroupRegistry.register();
        //EnchantsRegistry.register();
        StatusEffectRegistry.register();
        SummonedEntityAttributeRegistry.register();
        //SummonedEntityRegistry.register();
    }
}
