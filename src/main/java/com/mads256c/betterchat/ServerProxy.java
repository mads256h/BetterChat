package com.mads256c.betterchat;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;


public class ServerProxy
        extends CommonProxy


{
    Boolean isRegistered = false;

    public static Configuration config;



    public void preInit(FMLPreInitializationEvent e)
    {
        config = new Configuration(e.getSuggestedConfigurationFile());

        config.setCategoryRequiresMcRestart(Configuration.CATEGORY_GENERAL, false);
        config.setCategoryRequiresWorldRestart(Configuration.CATEGORY_GENERAL, false);

        config.setCategoryRequiresMcRestart("NoGroup", false);
        config.setCategoryRequiresWorldRestart("NoGroup", false);


        config.setCategoryComment(Configuration.CATEGORY_GENERAL, "Valid colors are: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW.");
        config.setCategoryComment("NoGroup", "Here you can configure the tag and color of the unassigned group.");
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

