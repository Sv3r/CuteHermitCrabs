package me.sv3r.cutehermitcrabs.core;

import me.sv3r.cutehermitcrabs.core.registry.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB = new CreativeModeTab("cute_hermit_crabs_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.HERMIT_CRAB_SHELL_PIECE.get());
        }
    };
}
