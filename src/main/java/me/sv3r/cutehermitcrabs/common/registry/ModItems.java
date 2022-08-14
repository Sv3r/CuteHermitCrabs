package me.sv3r.cutehermitcrabs.common.registry;

import me.sv3r.cutehermitcrabs.common.CuteHermitCrabs;
import me.sv3r.cutehermitcrabs.common.item.HermitCrabShellItem;
import me.sv3r.cutehermitcrabs.common.item.ModArmorMaterials;
import me.sv3r.cutehermitcrabs.common.ModCreativeModeTab;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    // Item Registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CuteHermitCrabs.MOD_ID);

    // Basic Items
    public static final RegistryObject<Item> HERMIT_CRAB_SHELL_PIECE = ITEMS.register("hermit_crab_shell_piece", () -> (
            new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.TAB))
    ));

    // Armor Items
    public static final RegistryObject<Item> HERMIT_CRAB_SHELL = ITEMS.register("hermit_crab_shell", () -> (
            new HermitCrabShellItem(ModArmorMaterials.SHELL, EquipmentSlot.HEAD, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB))
    ));

    // Entity Related
    public static final RegistryObject<ForgeSpawnEggItem> HERMIT_CRAB_SPAWN_EGG = ITEMS.register("hermit_crab_spawn_egg", () -> (
            new ForgeSpawnEggItem(ModEntityTypes.HERMIT_CRAB, 0xad4040, 0x793030, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB))
    ));
    public static final RegistryObject<MobBucketItem> BUCKET_OF_HERMIT_CRAB = ITEMS.register("bucket_of_hermit_crab", () -> (
            new MobBucketItem(ModEntityTypes.HERMIT_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties()
                    .tab(ModCreativeModeTab.TAB).stacksTo(1))
    ));

    // Foods
    public static final RegistryObject<Item> RAW_HERMIT_CRAB = ITEMS.register("raw_hermit_crab", () -> (
            new Item(new Item.Properties().food(FoodValues.RAW_HERMIT_CRAB)
                    .tab(ModCreativeModeTab.TAB))
    ));
    public static final RegistryObject<Item> COOKED_HERMIT_CRAB = ITEMS.register("cooked_hermit_crab", () -> (
            new Item(new Item.Properties().food(FoodValues.COOKED_HERMIT_CRAB)
                    .tab(ModCreativeModeTab.TAB))
    ));
}
