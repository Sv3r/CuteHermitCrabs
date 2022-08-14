package me.sv3r.cutehermitcrabs.common;

import me.sv3r.cutehermitcrabs.common.registry.ModEntityTypes;
import me.sv3r.cutehermitcrabs.common.registry.ModItems;
import me.sv3r.cutehermitcrabs.common.registry.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CuteHermitCrabs.MOD_ID)
public class CuteHermitCrabs
{
    public static final String MOD_ID = "cutehermitcrabs";

    public CuteHermitCrabs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITIES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}