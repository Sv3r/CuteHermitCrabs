package me.sv3r.cutehermitcrabs.common.registry;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.item.HermitCrabShellItem;
import me.sv3r.cutehermitcrabs.common.misc.CHCArmorMaterials;
import me.sv3r.cutehermitcrabs.common.misc.CHCFoodValues;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CHCItemRegistry
{

    // Item Registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CuteHermitCrabs.MOD_ID);

    // Basic Items
    public static final RegistryObject<Item> HERMIT_CRAB_SHELL_PIECE = ITEMS.register("hermit_crab_shell_piece", () -> (
            new Item(new Item.Properties()
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB))
    ));

    // Armor Items
    public static final RegistryObject<Item> HERMIT_CRAB_SHELL = ITEMS.register("hermit_crab_shell", () -> (
            new HermitCrabShellItem(CHCArmorMaterials.SHELL, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB))
    ));

    // Entity Related
    public static final RegistryObject<ForgeSpawnEggItem> HERMIT_CRAB_SPAWN_EGG = ITEMS.register("hermit_crab_spawn_egg", () -> (
            new ForgeSpawnEggItem(CHCEntityRegistry.HERMIT_CRAB, 0xad4040, 0x793030, new Item.Properties()
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB))
    ));
    public static final RegistryObject<MobBucketItem> BUCKET_OF_HERMIT_CRAB = ITEMS.register("bucket_of_hermit_crab", () -> (
            new MobBucketItem(CHCEntityRegistry.HERMIT_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties()
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB).stacksTo(1))
    ));

    // Foods
    public static final RegistryObject<Item> RAW_HERMIT_CRAB = ITEMS.register("raw_hermit_crab", () -> (
            new Item(new Item.Properties().food(CHCFoodValues.RAW_HERMIT_CRAB)
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB))
    ));
    public static final RegistryObject<Item> COOKED_HERMIT_CRAB = ITEMS.register("cooked_hermit_crab", () -> (
            new Item(new Item.Properties().food(CHCFoodValues.COOKED_HERMIT_CRAB)
                    .tab(CuteHermitCrabs.CREATIVE_MODE_TAB))
    ));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
