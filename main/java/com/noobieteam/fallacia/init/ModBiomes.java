package com.noobieteam.fallacia.init;

import com.noobieteam.fallacia.world.biome.BiomeGenMagical;

import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomes {
	
	
	public static BiomeGenBase biomeMagical;
	
	
	public static void init()
	{
		biomeMagical = new BiomeGenMagical(137);
	}

}
