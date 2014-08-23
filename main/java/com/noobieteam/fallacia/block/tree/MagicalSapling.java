package com.noobieteam.fallacia.block.tree;

import com.noobieteam.fallacia.creativetab.CreativeTabFallacia;
import com.noobieteam.fallacia.world.treegen.WorldGenMagicalTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;


public class MagicalSapling extends BlockBush implements IGrowable {
    /**
     * textureNames is a vector that holds all different types of wood the mod have
     * In this case: one
     */
    public static final String[] textureNames = new String[]{"magicalWood"};
    /**
     * icons holds the Icons for the types of wood.
     */
    private static final IIcon[] icons = new IIcon[textureNames.length];

    public MagicalSapling() {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(CreativeTabFallacia.tabFallacia);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeGrass);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            super.updateTick(world, x, y, z, random);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0) {
                this.func_149879_c(world, x, y, z, random);
            }
        }
    }

    /**
     * This function is a helper for metadata handling
     *
     * @param world  world
     * @param x      x coordinate
     * @param y      y coordinate
     * @param z      z coordinate
     * @param random random number for the growth tick
     */
    public void func_149879_c(World world, int x, int y, int z, Random random) {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0) {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        } else {
            this.func_149878_d(world, x, y, z, random);
        }
    }


    /**
     * This function is responsable for the world-gen of the tree.
     * Steve, please change this stuff to work to our thing... i'm gonna leave it blank for now...
     *
     * @param world  world
     * @param x      x coordinate
     * @param y      y coordinate
     * @param z      z coordinate
     * @param random random number for the growth tick
     */
    public void func_149878_d(World world, int x, int y, int z, Random random) {
        if (!TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        Object object = new WorldGenMagicalTree(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        Block block = Blocks.air;

        if (flag) {
            world.setBlock(x + i1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        } else {
            world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator) object).generate(world, random, x + i1, y, z + j1)) {
            world.setBlock(x, y, z, this, l, 4);
        }
    }

    /**
     * Used if we would want a n by n number of sapplings placed on the world
     * for the tree to grow
     *
     * @param world world
     * @param x     x coordinate
     * @param y     y coordinate
     * @param z     z coordinate
     * @param meta  target metadata
     * @return boolean if found sappling with same metadata as target on the spot
     */
    public boolean checkStructure(World world, int x, int y, int z, int meta) {
        return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == meta;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int damage) {
        return MathHelper.clamp_int(damage & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    /**
     * Registers the icons for the sappling
     *
     * @param iconRegister icon registerer
     */
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (int i = 0; i < icons.length; ++i) {
            icons[i] = iconRegister.registerIcon(String.format("%s",
                    getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        }
    }

    /**
     * Methods from IGrowable
     *
     * @param world world
     * @param x     x coordinate
     * @param y     y coordinate
     * @param z     z coordinate
     * @param bool  boolean value.
     * @return boolean if growable (i think)
     */
    @Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean bool) {
        return true;
    }

    /**
     * Methods from IGrowable
     *
     * @param world  world
     * @param random random number for the growth tick
     * @param x      x coordinate
     * @param y      y coordinate
     * @param z      z coordinate
     * @return boolean if growed
     */
    @Override
    public boolean func_149852_a(World world, Random random, int x, int y, int z) {
        return (double) world.rand.nextFloat() < 0.45D;
    }

    /**
     * Calls the growing function
     *
     * @param world  world
     * @param random random number for the growth tick
     * @param x      x coordinate
     * @param y      y coordinate
     * @param z      z coordinate
     */
    @Override
    public void func_149853_b(World world, Random random, int x, int y, int z) {
        this.func_149879_c(world, x, y, z, random);
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
