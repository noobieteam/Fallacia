package com.noobieteam.fallacia.init;


import com.noobieteam.fallacia.block.FallaciaBlock;
import com.noobieteam.fallacia.block.tree.MagicalLeaves;
import com.noobieteam.fallacia.block.tree.MagicalSapling;
import com.noobieteam.fallacia.block.tree.MagicalWood;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Main init mod initializers for blocks
 * Register the Blocks on GameRegistry
 */
public class ModBlocks {
    // CREATE ALL MOD BLOCK's INSTANCES IN HERE
    public static Block fallaciaBlock = new FallaciaBlock(Material.rock);
        public static Block magicalWood = new MagicalWood();
        public static Block magicalSapling = new MagicalSapling();
        public static Block magicalLeaves = new MagicalLeaves();

    /**
     * Call all the GameRegistry.registerBlock in here..
     */
    @Mod.EventHandler
    public static void preinit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(fallaciaBlock, "fallaciaBlock");
        GameRegistry.registerBlock(magicalWood, "magicalWood");
        GameRegistry.registerBlock(magicalLeaves, "magicalLeaves");
        GameRegistry.registerBlock(magicalSapling, "magicalSapling");
    }
}
