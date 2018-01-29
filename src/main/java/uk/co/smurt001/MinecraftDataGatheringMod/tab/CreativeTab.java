package uk.co.smurt001.MinecraftDataGatheringMod.tab;

// This Tab will be used to give the player specific items for the mod.(infinate building materials.)

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs
{
    public CreativeTab(int index, String label)
    {
        super(index,label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return ItemStack.EMPTY;
    }
}

