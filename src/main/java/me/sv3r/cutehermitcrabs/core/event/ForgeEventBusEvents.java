package me.sv3r.cutehermitcrabs.core.event;

import me.sv3r.cutehermitcrabs.core.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.core.registry.ModEntityTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CuteHermitCrabs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusEvents {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void biomeLoadingEvent(BiomeLoadingEvent event) {
        if(event.getName().equals(new ResourceLocation("minecraft:beach"))) {
            event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntityTypes.HERMIT_CRAB.get(), 10, 2, 6));
        }
    }
}
