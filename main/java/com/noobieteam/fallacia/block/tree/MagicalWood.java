package com.noobieteam.fallacia.block.tree;

import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;


public class MagicalWood extends BlockLog {

    public static final String[] types = new String[]{"magical"};

    public MagicalWood() {
        super();
        this.setBlockName("magicalWood");
        setCreativeTab(CreativeTabFallacia.tabFallacia);
    }

    /**
     * returns a list of blocks with the same ID, but different meta.
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    /**
     * reformats the unlocalized name for the mod blocks...
     * the regex is:
     * Helps with the localization
     *
     * @return tile.fallacia:magicalWood.name
     */
    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":",
                getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    /**
     * Helps with the block icon registering.
     * Formatting the string to match the path for
     * textures.
     * fallacia:magicalWood
     * fallacia:magicalWood_top
     * Put the textures on assets.fallacia.textures.blocks
     * with the names name.png and name_top.png !
     *
     * @param iconRegister IconRegister interface
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.field_150167_a = new IIcon[types.length];
        this.field_150166_b = new IIcon[types.length];

        for (int i = 0; i < types.length; i++) {
            this.field_150167_a[i] = iconRegister.registerIcon("fallacia:log_" + types[i]);
            this.field_150166_b[i] = iconRegister.registerIcon("fallacia:log_" + types[i] + "_top");
        }
    }

    /**
     * Helper method for the formatting.
     *
     * @param unlocalizedName string for the unlocalized name to be unwrapped
     * @return unwrapped version of the unlocalized name
     */
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
