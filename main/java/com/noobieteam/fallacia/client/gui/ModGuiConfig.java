package com.noobieteam.fallacia.client.gui;

import com.noobieteam.fallacia.handler.ConfigurationHandler;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {
    /**
     * the Mods Gui configuration. dont change a thing cuz i dont even know what i did here
     * followed minalien's tut.
     * @param parentScreen
     */
    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(
                        Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID, false, false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
