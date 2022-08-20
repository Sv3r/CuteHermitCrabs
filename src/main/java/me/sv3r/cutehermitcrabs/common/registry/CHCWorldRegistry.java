package me.sv3r.cutehermitcrabs.common.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.world.biomemods.CHCEntitySpawns;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CHCWorldRegistry
{
    // Biome Modifier Registry
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, CuteHermitCrabs.MOD_ID);

    // Biome Modifiers
    public static RegistryObject<Codec<CHCEntitySpawns>> ENTITY_SPAWNS = BIOME_MODIFIERS.register("entity_spawn", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("spawnableBiomes").forGetter(CHCEntitySpawns::spawnableBiomes),
                    Biome.LIST_CODEC.fieldOf("unspawnableBiomes").forGetter(CHCEntitySpawns::unspawnableBiomes),
                    Registry.ENTITY_TYPE.byNameCodec().fieldOf("entityType").forGetter(CHCEntitySpawns::entityType)
            ).apply(builder, CHCEntitySpawns::new)));

    public static void register(IEventBus eventBus)
    {
        BIOME_MODIFIERS.register(eventBus);
    }
}