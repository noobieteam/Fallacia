package com.noobieteam.fallacia.init;


import com.noobieteam.fallacia.block.tree.MagicalLeaves;
import com.noobieteam.fallacia.block.tree.MagicalSapling;
import com.noobieteam.fallacia.block.tree.MagicalWood;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Main init mod initializers for blocks
 * Register the Blocks on GameRegistry
 */
public class ModBlocks {
    // CREATE ALL MOD BLOCK's INSTANCES IN HERE
    private static MagicalWood magicalWood = new MagicalWood();
    private static MagicalLeaves magicalLeaves = new MagicalLeaves();
    private static MagicalSapling magicalSapling = new MagicalSapling();

    /**
     * Call all the GameRegistry.registerBlock in here..
     */
    public static void init() {
        GameRegistry.registerBlock(magicalWood, "magicalWood");
        GameRegistry.registerBlock(magicalLeaves, "magicalLeaves");
        GameRegistry.registerBlock(magicalSapling, "magicalSapling");
    }
}
