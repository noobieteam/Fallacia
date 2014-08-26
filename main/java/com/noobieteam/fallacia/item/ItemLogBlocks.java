package com.noobieteam.fallacia.item;

import akka.event.LogSource;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlock{
	
	public static final String[] logs = new String[] {"Magical", "Golem", "Troll"};

	public ItemLogBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= logs.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + logs[i];
	}
	
	@Override
	public int getMetadata (int meta)
	{
		return meta;
	}

}
