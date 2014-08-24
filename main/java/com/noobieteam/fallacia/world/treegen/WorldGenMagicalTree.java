package com.noobieteam.fallacia.world.treegen;

import com.noobieteam.fallacia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class WorldGenMagicalTree extends WorldGenAbstractTree {

	public WorldGenMagicalTree() {
		super(false);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		while(world.isAirBlock(x, y, z) && y > 2)
		{
			y--;
		}
		
		Block block = world.getBlock(x, y, z);
		
		if(block != Blocks.grass && block != Blocks.dirt)
		{
			return false;
		}
		else {
			for (int i = -2; i <= 2; i++)
			{
				for (int j = -2; j <= 2; j++)
				{
					if (world.isAirBlock(x + i, y - 1, z + j) && world.isAirBlock(x + i, y - 2, z + j) && !world.isAirBlock(x + i, y, z + j))
					{
						return false;
					}
				}
			}
			
			int baselength = 2 + random.nextInt(4);
			int branches = 2 + random.nextInt(4);
			
			int h = 1;
			
			block.onPlantGrow(world, x, y - 1, z, x, y, z);
			
			for (int i = 0; i < baselength; i++)
			{
				buildBlock(world, x, y + h, z, ModBlocks.magicalWood, 0);
				h++;
			}
			
			int c = 1;
			for (int i = 0; i < branches; i++)
			{
				generateBrance(world, random, x, y + h, z, c);
				c++;
				h+=2;
			}
			
			generateTop(world, x, y + h, z);
			return true;
		}
	}
	
	public void generateTop(World world, int x, int y, int z)
	{
		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				buildBlock(world, x + i, y, z + j, ModBlocks.magicalLeaves, 0);
			}
		}
		
		buildBlock(world, x, y, z, ModBlocks.magicalWood, 0);
		buildBlock(world, x, y+1, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x+1, y+1, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x-1, y+1, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+1, z-1, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+1, z+1, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+2, z, ModBlocks.magicalLeaves, 0);


		
	}
	
	public void generateBrance(World world, Random random, int x, int y, int z, int p)
	{
		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				buildBlock(world, x + i, y, z + j, ModBlocks.magicalLeaves, 1);
			}
		}
		buildBlock(world, x+1, y+1, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x-1, y+1, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+1, z-1, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+1, z+1, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y, z, ModBlocks.magicalLeaves, 0);
		buildBlock(world, x, y+1, z, ModBlocks.magicalLeaves, 0);
	}
	
	public void buildBlock(World world, int x, int y, int z, Block block, int meta)
	{
		if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z))
			world.setBlock(x, y, z, block, meta, 2);
	}

   
}
