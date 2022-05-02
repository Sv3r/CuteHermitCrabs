package me.sv3r.cutehermitcrabs.core;

import me.sv3r.cutehermitcrabs.core.registry.ModEntityTypes;
import me.sv3r.cutehermitcrabs.core.registry.ModItems;
import me.sv3r.cutehermitcrabs.core.registry.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CuteHermitCrabs.MOD_ID)
public class CuteHermitCrabs
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cutehermitcrabs";

    public CuteHermitCrabs() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITIES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}