package com.noobieteam.fallacia.handler;

import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    /**
     * Configuration object
     */
    public static Configuration configuration;
    /**
     * a example config value
     */
    public static boolean configValue = true;

    /**
     * Initializes de config object
     * and syncs it
     * @param configFile
     */
    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            syncConfiguration();
        }
    }

    /**
     * syncs the config if it has changed
     */
    private static void syncConfiguration() {
        configValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL,
                configValue, "This is an example config");
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    /**
     * Event that works with the GuiFactory.. if the evene changed the config then we sync it
     * @param event
     */
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            syncConfiguration();
        }
    }
}
