package com.noobieteam.fallacia.item;

import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FallaciaItem extends Item {

    /**
     * Constructor default
     */
    public FallaciaItem() {
        super();
        setCreativeTab(CreativeTabFallacia.tabFallacia);
    }

    /**
     * Override the default get unlocalized name for making the naming
     * and localizing better.
     * @return item.fallacia:itemname.name
     */
    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * Another override of getUnlocalizedName that works as
     * the one above
     * @param itemStack
     * @return
     */
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":",
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * Register the icons formatting the string to match the textures folder.
     * @param iconRegister
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(String.format("%s",
                getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    /**
     * Formatting helper.
     * @param unlocalizedName
     * @return
     */
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }
}
