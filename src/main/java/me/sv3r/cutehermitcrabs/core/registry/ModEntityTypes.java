package me.sv3r.cutehermitcrabs.core.registry;

import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.core.CuteHermitCrabs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    // EntityType Registry
    public static DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, CuteHermitCrabs.MOD_ID);

    // Water Creatures
    public static final RegistryObject<EntityType<HermitCrabEntity>> HERMIT_CRAB = REGISTRY.register("hermit_crab",
            () -> EntityType.Builder.of(HermitCrabEntity::new, MobCategory.WATER_CREATURE).sized(0.5f, 0.5f)
                    .build(new ResourceLocation(CuteHermitCrabs.MOD_ID, "hermit_crab").toString()));
}
