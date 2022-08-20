package me.sv3r.cutehermitcrabs.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CHCConfig
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> RESISTANCE_LEVEL;
    public static final ForgeConfigSpec.ConfigValue<Integer> SPAWN_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> MIN_GROUP_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Integer> MAX_GROUP_SIZE;

    static
    {
        BUILDER.push("Cute Hermit Crabs");

        RESISTANCE_LEVEL = BUILDER
                .comment("Hermit Crab Shell Resistance Level")
                .define("Resistance Level", 3);
        SPAWN_WEIGHT = BUILDER
                .comment("Hermit Crab Spawn Weight")
                .define("Spawn Weight", 10);
        MIN_GROUP_SIZE = BUILDER
                .comment("Hermit Crab Min Group Size")
                .define("Min Group Size", 2);
        MAX_GROUP_SIZE = BUILDER
                .comment("Hermit Crab Max Group Size")
                .define("Max Group Size", 6);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
