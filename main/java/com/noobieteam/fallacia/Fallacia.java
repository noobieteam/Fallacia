package com.noobieteam.fallacia;

import com.noobieteam.fallacia.proxy.IProxy;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Main mod Class
 *
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Fallacia {
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
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    }

    /**
     * Initialization of stuff!
     * Like recipes and event handlers
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }


    /**
     * Post initialization of stuff
     * like loggin and such (dont really know =P)
     * @param event
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
