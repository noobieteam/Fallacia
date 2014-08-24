package com.noobieteam.fallacia.events;

import com.noobieteam.fallacia.block.tree.MagicalSapling;
import com.noobieteam.fallacia.init.ModBlocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;

/**
 * Created by richard on 24/08/14.
 */
public class BoneMealMagicalEvent {
    private int BlockID;

    @SubscribeEvent
    public void boneMealUsed(BonemealEvent event) {
        if (event.world.getBlock(event.x, event.y, event.z) instanceof MagicalSapling) {
            ((MagicalSapling) ModBlocks.magicalSapling).func_149878_d(event.world,
                    event.x, event.y, event.z, event.world.rand);
        }
    }

}
