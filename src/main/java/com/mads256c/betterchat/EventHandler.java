package com.mads256c.betterchat;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.ServerChatEvent;

public class EventHandler
{
    public static final String Dev = EnumChatFormatting.BOLD.toString() + EnumChatFormatting.DARK_PURPLE.toString() + "[Dev] " + EnumChatFormatting.RESET.toString();
    public static final String B = EnumChatFormatting.ITALIC.toString() + EnumChatFormatting.DARK_AQUA.toString() + "[1.B] " + EnumChatFormatting.RESET.toString();
    public static final String C = EnumChatFormatting.ITALIC.toString() + EnumChatFormatting.DARK_GREEN.toString() + "[1.C] " + EnumChatFormatting.RESET.toString();
    public static final String NoGroup = EnumChatFormatting.DARK_GRAY.toString() + "[No Group] " + EnumChatFormatting.RESET.toString();






    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void onServerChat(ServerChatEvent e)
    {


        EntityPlayerMP sender = e.player;

        List<EntityPlayerMP> players = MinecraftServer.getServer().getConfigurationManager().playerEntityList;


        String finalMessage = ChatFormatter.ChatParser(sender);


        for (EntityPlayerMP receiver : players)
        {
            receiver.addChatMessage(new ChatComponentText(finalMessage + "<" + sender.getDisplayName() + ">: " + e.message));
        }

        System.out.println(sender.getDisplayName() + " said: " + e.message);
        e.setCanceled(true);
    }
}