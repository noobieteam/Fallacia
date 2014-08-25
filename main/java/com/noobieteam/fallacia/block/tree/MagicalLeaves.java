package com.noobieteam.fallacia.block.tree;

import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.reference.Reference;
import com.noobieteam.fallacia.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;


public class MagicalLeaves extends BlockLeaves {

    public MagicalLeaves() {
        super();
        this.setBlockName("magicalLeaves");
        setCreativeTab(CreativeTabFallacia.tabFallacia);
    }

    /**
     * This is the right way to set textures on leaves.. it's a multi texture block...
     */
    public static final String[][] typeTypes = new String[][]{
            {"magical"}, {"magical_opaque"}};
    public static final String[] types = new String[]{"magical"};

    protected void func_150124_c(World world, int x, int y, int z, int var1, int var2) {
        if ((var1 & 3) == 1 && world.rand.nextInt(var2) == 0) {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int damage) {
        return super.damageDropped(damage) + 4;
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World world, int x, int y, int z) {
        return world.getBlockMetadata(x, y, z) & 3;
    }

    @Override
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return (meta) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creative, List list) {
        //Warning here idk..
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (int i = 0; i < typeTypes.length; ++i) {
            this.field_150129_M[i] = new IIcon[typeTypes[i].length];

            for (int j = 0; j < typeTypes[i].length; ++j) {
                this.field_150129_M[i][j] = iconRegister.registerIcon("fallacia:leaves_" + typeTypes[i][j]);
            }
        }
    }

    @Override
    public String[] func_150125_e() {
        return types;
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
     * Helper method for the formatting.
     *
     * @param unlocalizedName string for the unlocalized name to be unwrapped
     * @return unwrapped version of the unlocalized name
     */
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
