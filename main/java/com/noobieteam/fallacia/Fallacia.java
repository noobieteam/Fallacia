package com.noobieteam.fallacia;

import com.noobieteam.fallacia.init.ModBlocks;
import com.noobieteam.fallacia.proxy.IProxy;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import scala.tools.nsc.backend.icode.TypeKinds;
import com.noobieteam.fallacia.block.FallaciaBlock;
import com.noobieteam.fallacia.block.tree;
import net.minecraft.block.Block;

/**
 * Main mod Class
 *
 * public class Fallacia makes the variables for the blocks so they can be registered
 * but block info and properites need ot be on the class files
 * (put in by Abob78)
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Fallacia {
        public static Block fallaciaBlock = new FallaciaBlock();
        public static Block magicalWood = new MagicalWood();
        public static Block magicalSapling = new MagicalSapling();
        public static Block magicalLeaves = new MagicalLeaves();

}
    /**
     * This registers a static instance of the mod's class. It is useful for
     * the proxy and gui stuff
     */
    @Mod.Instance(Reference.MOD_ID)
    public static Fallacia instance;

    /**
     * This handles the proxy stuff. Don't really know why but it stays here =P
     */
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    /**
     * Pre initialization of stuff!
     * like Blocks, Items and Such
     * @param event
     * 
     * Registers Blocks to the game (put in by Abob78)
     */
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        GameRegistry.registerBlock(fallaciaBlock, "Fallacia Block");
        GameRegistry.registerBlock(magicalLeaves, "Magical Leaves");
        GameRegistry.registerBlock(magicalWood, "Magical Wood");
        GameRegistry.registerBlock(magicalSapling, "Magical Sapling");
    }

    /**
     * Initialization of stuff!
     * Like recipes and event handlers
     * @param event
     * 
     * Registers Recipes for the blocks
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {


    /**
     * Post initialization of stuff
     * like loggin and such (dont really know =P)
     * @param event
     */
    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
