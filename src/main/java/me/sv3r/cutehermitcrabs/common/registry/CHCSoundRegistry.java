package me.sv3r.cutehermitcrabs.common.registry;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CHCSoundRegistry
{
    // Sound Registry
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CuteHermitCrabs.MOD_ID);

    // Hermit Crab Sounds
    public static final RegistryObject<SoundEvent> HERMIT_CRAB_HURT = SOUNDS.register("hermit_crab_hurt", () -> (
            new SoundEvent(new ResourceLocation(CuteHermitCrabs.MOD_ID, "hermit_crab_hurt"))
    ));

    public static void register(IEventBus eventBus)
    {
        SOUNDS.register(eventBus);
    }
}
