package com.noobieteam.fallacia.handler

import java.util.Random;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DropHandler
{
public static Random random;
public static int dropped;

@SubscribeEvent
public void onEntityDrop(LivingDropsEvent event)
{
random = new Random();
dropped = random.nextInt(2) + 1; //DO NOT CHANGE THIS

if(event.entityLiving instanceof EntityCow)//ENITITY OF MOD HERE
{
event.entityLiving.entityDropItem(new ItemStack(Items.apple), dropped);//ITEM DROPPEDD HERE
}

}

}
