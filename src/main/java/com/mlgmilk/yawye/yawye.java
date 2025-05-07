// src/main/java/com/mlgmilk/yawye/yawye.java
package com.mlgmilk.yawye;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.item.Item;
import net.minecraft.item.Items;


public class yawye implements ModInitializer {
    public static final String MOD_ID = "yawye";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /**
     * Checks if the given item is considered a raw meat or fish.
     * This method is static so it can be called from the Mixin.
     */
    public static boolean IsRawFood(Item item) {
        // Consider using a Set for better performance and readability if this list grows
        if (item == Items.BEEF || item == Items.CHICKEN || item == Items.COD ||
                item == Items.SALMON || item == Items.MUTTON || item == Items.PORKCHOP ||
                item == Items.RABBIT) {
            return true;
        }
        return false;
    }

    @Override
    public void onInitialize() {
        LOGGER.info("YAWYE Initializing with Mixin for food effects!");

        // THE UseItemCallback.EVENT.register(...) BLOCK IS NOW REMOVED FROM HERE.
        // Its logic has been moved to ItemFinishUsingMixin.
    }
}