package com.noobieteam.fallacia.init;

/**
 * Main Initializers for the mod's recipes
 * Registers them..
 */
public class Recipes {
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	GameRegistry.addRecipe(new ItemStack(fallaciaBlock), new Object[]{
    		"y y",//Must be in the correct format: a 3x3 grid for the crafting table
    		"xyx",
    		"y y",
    		'y', Blocks.obsidian, 'x', new ItemStack(Blocks.stained_glass, 1, 9) //dictates what x and y equal
    		                                                                     //Use itemstack if you want to use a varation (such as a color of wool)
    	});                                                                          //put in by Abob78
    	GameRegistry.addRecipe(new ItemStack(magicalWood), new Object[]{
    		"y y",
    		"xyx",
    		"y y",
    		'y', Blocks.obsidian, 'x', new ItemStack(Blocks.stained_glass, 1, 9) //change the block accordingly
    	});                                                                          //you can change it to with no itemstack if u just want a base block
    	GameRegistry.addRecipe(new ItemStack(magicalLeaves), new Object[]{
    		"y y",
    		"xyx",
    		"y y",
    		'y', Blocks.obsidian, 'x', new ItemStack(Blocks.stained_glass, 1, 9) 
    	});   
    	GameRegistry.addRecipe(new ItemStack(magicalSapling), new Object[]{
    		"y y",
    		"xyx",
    		"y y",
    		'y', Blocks.obsidian, 'x', new ItemStack(Blocks.stained_glass, 1, 9) 
    	});   
    }
