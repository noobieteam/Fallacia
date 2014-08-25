package com.noobieteam.fallacia.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaplingBlocks extends ItemBlockWithMetadata{
	
	public static final String[] saplings = new String[] {"Magical", "Golem", "Troll"};

	public ItemSaplingBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= saplings.length)
		{
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + saplings[i];
	}
	
	@Override
	public int getMetadata (int meta)
	{
		return meta;
	}

}
