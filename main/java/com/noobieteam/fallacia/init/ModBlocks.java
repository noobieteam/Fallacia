package com.noobieteam.fallacia.init;


import javax.security.auth.login.FailedLoginException;

import com.noobieteam.fallacia.block.FallaciaBlock;
import com.noobieteam.fallacia.block.tree.FLeaf;
import com.noobieteam.fallacia.block.tree.FLog;
import com.noobieteam.fallacia.block.tree.FSapling;
import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.item.ItemLeafBlocks;
import com.noobieteam.fallacia.item.ItemLogBlocks;
import com.noobieteam.fallacia.item.ItemSaplingBlocks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Main init mod initializers for blocks
 * Register the Blocks on GameRegistry
 */
public class ModBlocks {
    // CREATE ALL MOD BLOCK's INSTANCES IN HERE
    public static Block fallaciaBlock = new FallaciaBlock(Material.rock);
        
        //Tree
        public static Block blockLog = new FLog().setBlockName("Log").setCreativeTab(CreativeTabFallacia.tabFallacia);
        
        //Leafs
        public static Block blockleaf = new FLeaf().setBlockName("Leaf").setCreativeTab(CreativeTabFallacia.tabFallacia);
        
        //Saplings
        public static Block blockSapling = new FSapling().setBlockName("Sapling").setCreativeTab(CreativeTabFallacia.tabFallacia);

    /**
     * Call all the GameRegistry.registerBlock in here..
     */
    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(fallaciaBlock, "fallaciaBlock");
        
        //Tree
        GameRegistry.registerBlock(blockLog, ItemLogBlocks.class, blockLog.getUnlocalizedName().substring(5));
        
        //Leafs
        GameRegistry.registerBlock(blockleaf, ItemLeafBlocks.class, blockleaf.getUnlocalizedName().substring(5));
        
      //Saplings
        GameRegistry.registerBlock(blockSapling, ItemSaplingBlocks.class, blockSapling.getUnlocalizedName().substring(5));
    }
}
