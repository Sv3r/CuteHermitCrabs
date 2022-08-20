package me.sv3r.cutehermitcrabs.common.event;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.common.registry.CHCEntityRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CuteHermitCrabs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents
{
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(CHCEntityRegistry.HERMIT_CRAB.get(), HermitCrabEntity.createAttributes().build());
    }
}