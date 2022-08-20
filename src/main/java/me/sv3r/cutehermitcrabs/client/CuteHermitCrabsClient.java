package me.sv3r.cutehermitcrabs.client;

import me.sv3r.cutehermitcrabs.client.renderer.entity.HermitCrabRenderer;
import me.sv3r.cutehermitcrabs.client.renderer.entity.model.HermitCrabModel;
import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.registry.CHCEntityRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = CuteHermitCrabs.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CuteHermitCrabsClient
{
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event)
    {
        CuteHermitCrabs.Tags.init();
        EntityRenderers.register(CHCEntityRegistry.HERMIT_CRAB.get(), HermitCrabRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(HermitCrabModel.LAYER_LOCATION, HermitCrabModel::createBodyLayer);
    }
}
