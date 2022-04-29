package me.sv3r.cutehermitcrabs.core.event;

import me.sv3r.cutehermitcrabs.client.renderer.entity.model.HermitCrabModel;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.core.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.core.registry.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = CuteHermitCrabs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModModEvents {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.HERMIT_CRAB.get(), HermitCrabEntity.createAttributes().build());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(HermitCrabModel.LAYER_LOCATION, HermitCrabModel::createBodyLayer);
    }
}