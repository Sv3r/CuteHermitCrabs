package me.sv3r.cutehermitcrabs.common.item;

import me.sv3r.cutehermitcrabs.common.config.CHCConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
public class HermitCrabShellItem extends ArmorItem
{
    public HermitCrabShellItem(ArmorMaterial material, EquipmentSlot slot, Properties properties)
    {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
        if (player.isShiftKeyDown())
        {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, CHCConfig.RESISTANCE_LEVEL.get() - 1, false, false, true));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
    {
        tooltipComponents.add(Component.translatable("item.modifiers.sneaking").withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("attribute.modifier.plus").withStyle(ChatFormatting.BLUE)
                .append(Component.translatable(MobEffects.DAMAGE_RESISTANCE.getDisplayName().getString()).withStyle(ChatFormatting.BLUE)).append(" ")
                .append(Component.translatable("potion.potency." + (CHCConfig.RESISTANCE_LEVEL.get() - 1))).withStyle(ChatFormatting.BLUE));

        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
    }
}