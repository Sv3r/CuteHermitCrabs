package me.sv3r.cutehermitcrabs.common.registry;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CHCEntityRegistry
{
    // EntityType Registry
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CuteHermitCrabs.MOD_ID);

    // Water Creatures
    public static final RegistryObject<EntityType<HermitCrabEntity>> HERMIT_CRAB = ENTITY_TYPES.register("hermit_crab", () -> (
            EntityType.Builder.of(HermitCrabEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.5f, 0.5f)
                    .build(new ResourceLocation(CuteHermitCrabs.MOD_ID, "hermit_crab").toString())
    ));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
