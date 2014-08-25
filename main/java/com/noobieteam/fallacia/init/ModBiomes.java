package com.noobieteam.fallacia.init;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraftforge.common.BiomeManager;
import akka.io.Tcp.Register;

import com.noobieteam.fallacia.world.biome.BiomeGenMagical;

import cpw.mods.fml.common.registry.GameRegistry;



public class ModBiomes {
	
	
	public static BiomeGenBase biomeMagical = new BiomeGenMagical(137).setBiomeName("Magical Woods");	
	
	
	public static void init()
	{
		BiomeManager.coolBiomes.add(new BiomeManager.BiomeEntry(biomeMagical, 100));
		BiomeManager.addSpawnBiome(biomeMagical);
	}
	
	public static void load()
	{
	}
}
