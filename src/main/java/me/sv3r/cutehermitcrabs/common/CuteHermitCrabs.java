package me.sv3r.cutehermitcrabs.common;

import me.sv3r.cutehermitcrabs.common.config.CHCConfig;
import me.sv3r.cutehermitcrabs.common.entity.HermitCrabEntity;
import me.sv3r.cutehermitcrabs.common.registry.CHCEntityRegistry;
import me.sv3r.cutehermitcrabs.common.registry.CHCItemRegistry;
import me.sv3r.cutehermitcrabs.common.registry.CHCSoundRegistry;
import me.sv3r.cutehermitcrabs.common.registry.CHCWorldRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CuteHermitCrabs.MOD_ID)
@MethodsReturnNonnullByDefault
public class CuteHermitCrabs
{
    public static final String MOD_ID = "cutehermitcrabs";

    public static final CreativeModeTab CREATIVE_MODE_TAB = new CreativeModeTab("cute_hermit_crabs_tab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(CHCItemRegistry.HERMIT_CRAB_SHELL_PIECE.get());
        }
    };

    public CuteHermitCrabs()
    {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setupCommon);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CHCConfig.SPEC, "cutehermitcrabs.toml");
        registerRegistries(modEventBus);
    }

    public void setupCommon(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
                SpawnPlacements.register(CHCEntityRegistry.HERMIT_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HermitCrabEntity::checkHermitCrabSpawnRules)
        );
    }

    public static void registerRegistries(IEventBus eventBus)
    {
        CHCItemRegistry.register(eventBus);
        CHCEntityRegistry.register(eventBus);
        CHCSoundRegistry.register(eventBus);
        CHCWorldRegistry.register(eventBus);
    }

    public static class Tags
    {
        public static final TagKey<Block> HERMIT_CRAB_SPAWNABLE_BLOCKS = blockTag("hermit_crab_spawnable_blocks");
        public static final TagKey<Biome> HERMIT_CRAB_SPAWNABLE_BIOMES = biomeTag("hermit_crab_spawnable_biomes");
        public static final TagKey<Biome> HERMIT_CRAB_UNSPAWNABLE_BIOMES = biomeTag("hermit_crab_unspawnable_biomes");

        public static TagKey<Block> blockTag(String name)
        {
            return BlockTags.create(new ResourceLocation(CuteHermitCrabs.MOD_ID, name));
        }

        public static TagKey<Biome> biomeTag(String name)
        {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(CuteHermitCrabs.MOD_ID, name));
        }

        public static void init()
        {
        }
    }
}