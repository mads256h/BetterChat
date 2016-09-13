package com.mads256c.betterchat;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;

import org.apache.logging.log4j.Logger;

import static net.minecraft.server.MinecraftServer.getServer;

@Mod(modid=Refrence.MODID, name=Refrence.NAME, acceptableRemoteVersions="*", version=Refrence.VERSION)
public class BetterChat
{
    public static final String MODID = Refrence.MODID;
    public static final String VERSION = Refrence.MODID;

    public static Logger bLog;

    //region Proxy

    @SidedProxy(clientSide="com.mads256c.betterchat.ClientProxy", serverSide="com.mads256c.betterchat.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        BetterChat.bLog = e.getModLog();
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverStart(FMLServerStartingEvent e)
    {
        MinecraftServer server = getServer();
        ICommandManager iCommandManager = server.getCommandManager();
        ServerCommandManager serverCommandManager = (ServerCommandManager)iCommandManager;

        serverCommandManager.registerCommand(new CommandHandler());
    }
    //endregion
}