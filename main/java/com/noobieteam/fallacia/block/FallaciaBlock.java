package com.noobieteam.fallacia.block;


import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Main Block class for all block mods..
 * All mod blocks should extend this one
 */
public class FallaciaBlock extends Block {

    /**
     * Constructor default for mod blocks
     * @param material
     */
    protected FallaciaBlock(Material material) {
        super(material);
        setCreativeTab(CreativeTabFallacia.tabFallacia);
    }

    /**
     * Alternative constructor if you want to generate a block without passing
     * the material.
     */
    protected FallaciaBlock() {
        super(Material.rock);
        setCreativeTab(CreativeTabFallacia.tabFallacia);
    }

    /**
     * reformats the unlocalized name for the mod blocks...
     * the regex is:
     * Helps with the localization
     * @return tile.fallacia:blockname.name
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
     * fallacia:blockname.name
     * @param iconRegister
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s",
                getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    /**
     * Helper method for the formatting.
     * @param unlocalizedName
     * @return
     */
    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }
}
