package me.sv3r.cutehermitcrabs.core;

import me.sv3r.cutehermitcrabs.client.renderer.entity.HermitCrabRenderer;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.core.registry.ModEntityTypes;
import me.sv3r.cutehermitcrabs.core.registry.ModItems;
import me.sv3r.cutehermitcrabs.core.registry.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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

        ModItems.REGISTRY.register(modEventBus);
        ModEntityTypes.REGISTRY.register(modEventBus);
        ModSounds.REGISTRY.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> SpawnPlacements.register(ModEntityTypes.HERMIT_CRAB.get(),
                SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HermitCrabEntity::canSpawn));
    }

    @OnlyIn(Dist.CLIENT)
    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.HERMIT_CRAB.get(), HermitCrabRenderer::new);
    }
}