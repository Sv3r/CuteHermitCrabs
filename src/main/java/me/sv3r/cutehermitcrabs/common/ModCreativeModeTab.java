package me.sv3r.cutehermitcrabs.common;

import me.sv3r.cutehermitcrabs.common.registry.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
public class ModCreativeModeTab
{
    public static final CreativeModeTab TAB = new CreativeModeTab("cute_hermit_crabs_tab")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(ModItems.HERMIT_CRAB_SHELL_PIECE.get());
        }
    };
}
