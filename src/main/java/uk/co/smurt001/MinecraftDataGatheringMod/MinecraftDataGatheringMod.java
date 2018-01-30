// Author: Sokol Murturi PhD candidate at Goldsmiths University of London
// Feild: Artificial Intelligence and CO-Creation
// Main Supervisor: Jeremy Gow
// Contact Details: smurt001@gold.ac.uk

//The aim of this mod will be to develop a system that gathers data about where people place blocks when creating houses
// or structures within the game Minecraft. This information will then be stored within an SQL Database.
// This information will then, hopefully be used to help train a DNN or any other NN to build an agent which
// will work alongside the player to create structures in the game.

////////////////////////////////////Refrences and Tutorials used for Code.//////////////////////////////////////////
//https://www.youtube.com/watch?v=jRq9Kg6Qqxs Tutorials used to get to grips with Modding in Minecraft

package uk.co.smurt001.MinecraftDataGatheringMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import uk.co.smurt001.MinecraftDataGatheringMod.proxy.CommonProxy;
import uk.co.smurt001.MinecraftDataGatheringMod.tab.CreativeTab;

@Mod(modid = MinecraftDataGatheringMod.MODID, name = MinecraftDataGatheringMod.NAME, version = MinecraftDataGatheringMod.VERSION)
public class MinecraftDataGatheringMod
{
    //Naming and setting up mod so it can be used by people
    public static final String MODID = "minecraftdatagatheringmod";
    public static final String NAME = "Minecraft Data Gathering Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static CreativeTab tab;

    //Client and serverside access for mod so everything talks
    @SidedProxy(clientSide = "uk.co.smurt001.MinecraftDataGatheringMod.proxy.ClientProxy", serverSide = "uk.co.smurt001.MinecraftDataGatheringMod.proxy.CommonProxy")
    public static CommonProxy proxy;

    //Incase we need to set up things Like GUIs to tell the player what to do (blue prints for buildings they will be building.
    @Mod.Instance
    public static MinecraftDataGatheringMod instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Gets access to the custom Building Tab which will have our infinate blocks for the player to use.
        tab = new CreativeTab(CreativeTabs.getNextID(), "Building_Tools_Tab");
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new MinecraftDataGatheringEventHandler());
        proxy.postInit(event);
    }
}
