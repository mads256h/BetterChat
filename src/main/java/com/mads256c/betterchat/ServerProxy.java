package com.mads256c.betterchat;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import java.util.Arrays;


public class ServerProxy
        extends CommonProxy


{
    Boolean isRegistered = false;

    public static Configuration config;

    //region Config Defaults
    static String[] Default1 = {"the_master256c", "miliku"};
    static String[] Default2 = {"miliku"};
    static String[] Default3 = {"the_master256c"};
    static String[] Default4 = {"example"};
    static String[] Default5 = {"example"};
    static String[] Default6 = {"example"};
    static String[] Default7 = {"example"};
    static String[] Default8 = {"example"};
    static String[] Default9 = {"example"};
    static String[] Default10 = {"example"};

    static String[] DefaultColor1 = {"BOLD", "DARK_AQUA"};
    static String[] DefaultColor2 = {"DARK_PURPLE"};
    static String[] DefaultColor3 = {"UNDERLINE"};
    static String[] DefaultColor4 = {"RED"};
    static String[] DefaultColor5 = {"GOLD"};
    static String[] DefaultColor6 = {"BLACK"};
    static String[] DefaultColor7 = {"AQUA"};
    static String[] DefaultColor8 = {"DARK_GRAY"};
    static String[] DefaultColor9 = {"BOLD"};
    static String[] DefaultColor10 = {"STRIKETHROUGH"};

    static String[] DefaultTag = {"Admin", "Mod", "Dev", "A", "B", "C"};
//endregion


    public void preInit(FMLPreInitializationEvent e)
    {
        config = new Configuration(e.getSuggestedConfigurationFile());

        ConfigHandler.getConfig(config);

        super.preInit(e);
    }

    public void init(FMLInitializationEvent e)
    {
        super.init(e);
        if (!isRegistered) { MinecraftForge.EVENT_BUS.register(new EventHandler()); isRegistered = true; }
    }

    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
        BetterChat.bLog.info("BetterChat has loaded server-side.");
    }
}

