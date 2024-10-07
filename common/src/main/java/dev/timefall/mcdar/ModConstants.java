package dev.timefall.mcdar;

import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModConstants {

    public static final String MOD_ID = "mcdar";
    public static Identifier ID (String path){
        return Identifier.of(MOD_ID, path);
    }
    public static final RegistryKey<ItemGroup> ARTIFACTS = RegistryKey.of(RegistryKeys.ITEM_GROUP, ModConstants.ID("artifacts"));

    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

}
