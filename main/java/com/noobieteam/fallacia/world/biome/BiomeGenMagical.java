package com.noobieteam.fallacia.world.biome;

import java.util.Random;

import com.noobieteam.fallacia.world.treegen.WorldGenMagicalTree;

import scala.reflect.internal.TreeGen;
import scala.tools.nsc.ast.parser.TreeBuilder;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;



public class BiomeGenMagical extends BiomeGenBase{

	public BiomeGenMagical(int id) {
		super(id);
		this.setTemperatureRainfall(0.7F, 0.8F);
		this.topBlock = Blocks.glass;
		//this.theBiomeDecorator.treesPerChunk = 10;
	}
}
