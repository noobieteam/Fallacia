package com.noobieteam.fallacia.creativetab;

import com.noobieteam.fallacia.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabFallacia {
    /**
     * Creates a basic creative tab to store our mod's items and blocks
     */
    public static final CreativeTabs tabFallacia = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return null;
        }
    };
}
