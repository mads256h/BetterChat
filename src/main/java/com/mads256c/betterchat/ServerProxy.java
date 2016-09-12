package com.mads256c.betterchat;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import java.util.Arrays;
import java.util.List;


public class ServerProxy
        extends CommonProxy


{
    Boolean isRegistered = false;

    public static Configuration config;

    static String[] DefaultDev = {"the_master256c", "miliku"};
    static String[] DefaultB = {"miliku"};
    static String[] DefaultC = {"the_master256c"};

    public static void getConfig()
    {
        config.load();

        String[] DevPlayersArray = config.getStringList("DevPlayers", Configuration.CATEGORY_GENERAL, DefaultDev, "Players who are Dev's get the Dev tag. Separate with enter");
        String[] BPlayersArray = config.getStringList("BPlayers", Configuration.CATEGORY_GENERAL, DefaultB, "Players who should get the B tag. Separate with enter");
        String[] CPlayersArray = config.getStringList("CPlayers", Configuration.CATEGORY_GENERAL, DefaultC, "Players who should get the C tag. Separate with enter");


        config.save();

        EventHandler.DevPlayers = Arrays.asList(DevPlayersArray);
        EventHandler.BPlayers = Arrays.asList(BPlayersArray);
        EventHandler.CPlayers = Arrays.asList(CPlayersArray);

    }

    public void preInit(FMLPreInitializationEvent e)
    {

        config = new Configuration(e.getSuggestedConfigurationFile());

        getConfig();

        super.preInit(e);
    }

    public void init(FMLInitializationEvent e)
    {
        super.init(e);
        if (!isRegistered) {
            MinecraftForge.EVENT_BUS.register(new EventHandler());
            isRegistered = true;
        }
    }

    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
        System.out.println("BetterChat has loaded server-side.");
    }
}

