package me.sv3r.cutehermitcrabs.common.world.biomemods;

import com.mojang.serialization.Codec;
import me.sv3r.cutehermitcrabs.common.config.CHCConfig;
import me.sv3r.cutehermitcrabs.common.registry.CHCWorldRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record CHCEntitySpawns(HolderSet<Biome> spawnableBiomes, HolderSet<Biome> unspawnableBiomes,
                              EntityType<?> entityType) implements BiomeModifier
{
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder)
    {
        if (phase == Phase.ADD && spawnableBiomes.contains(biome) && !unspawnableBiomes.contains(biome))
        {
            builder.getMobSpawnSettings().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(entityType, CHCConfig.SPAWN_WEIGHT.get(),
                    CHCConfig.MIN_GROUP_SIZE.get(), CHCConfig.MAX_GROUP_SIZE.get()));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec()
    {
        return CHCWorldRegistry.ENTITY_SPAWNS.get();
    }
}
