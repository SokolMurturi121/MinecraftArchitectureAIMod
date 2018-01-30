package uk.co.smurt001.MinecraftDataGatheringMod;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//Event handler class, this class is being used to check where the player is placing blocks, what blocks they are placing
//and looking out for marker blocks. This information is then pass onto an SQL database

public class MinecraftDataGatheringEventHandler

{
    //Messing around with event system to see what i can do to the player (such as giving custom blocks at the start of the game to be used when building
    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            player.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND_SHOVEL));
        }
    }

    // determins what is dropped on the death of an enemy or animal within game doing this as it allows me to check relative position inside the world for block placement tests
    @SubscribeEvent
    public void livingDropsEvent(LivingDropsEvent event)
    {
        if(event.getEntity() instanceof EntityMob)
        {
            event.getDrops().add(new EntityItem(event.getEntity().world, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(Items.DIAMOND_AXE)));
        }
    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event)
    {

    }

  //  @SubscribeEvent
  //  public void itemPickUp(PlayerEvent.ItemPickupEvent event)
  //  {

//    }

    @SubscribeEvent
    public void livingUpdate(LivingEvent.LivingUpdateEvent event)
    {

    }
}
