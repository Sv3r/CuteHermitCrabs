package me.sv3r.cutehermitcrabs.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
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
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 2, false, false, true));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced)
    {
        tooltipComponents.add(new TranslatableComponent("item.modifiers.sneaking").withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(new TranslatableComponent("attribute.modifier.plus").withStyle(ChatFormatting.BLUE)
                .append(new TranslatableComponent(MobEffects.DAMAGE_RESISTANCE.getDisplayName().getString()).withStyle(ChatFormatting.BLUE)).append(" ")
                .append(new TranslatableComponent("potion.potency.2")).withStyle(ChatFormatting.BLUE));

        super.appendHoverText(itemStack, level, tooltipComponents, isAdvanced);
    }
}