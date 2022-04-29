package me.sv3r.cutehermitcrabs.common;

import net.minecraft.world.food.FoodProperties;

public class Foods {

    // Meats
    public static final FoodProperties RAW_HERMIT_CRAB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties COOKED_HERMIT_CRAB = (new FoodProperties.Builder()).nutrition(6).saturationMod(6f).build();
}
