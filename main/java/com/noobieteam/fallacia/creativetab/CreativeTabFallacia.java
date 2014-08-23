package com.noobieteam.fallacia.creativetab;

import com.noobieteam.fallacia.Fallacia;
import com.noobieteam.fallacia.block.FallaciaBlock;
import com.noobieteam.fallacia.block.tree.MagicalWood;
import com.noobieteam.fallacia.init.ModBlocks;
import com.noobieteam.fallacia.init.ModItems;
import com.noobieteam.fallacia.item.FallaciaItem;
import com.noobieteam.fallacia.reference.Reference;

import net.minecraft.creativetab.CreativeTabs;
<<<<<<< HEAD
import net.minecraft.init.Blocks;
=======
>>>>>>> origin/master
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabFallacia {
    /**
     * Creates a basic creative tab to store our mod's items and blocks
     */
    public static final CreativeTabs tabFallacia = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
<<<<<<< HEAD
            return Items.emerald;
=======
            return Items.emerald; //Needs to be changed to Fallacia Items when we add them
>>>>>>> origin/master
        }
    };
}
