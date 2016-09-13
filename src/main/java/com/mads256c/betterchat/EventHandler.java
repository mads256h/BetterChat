package com.mads256c.betterchat;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;

public class EventHandler
{
    //region Chat handler
    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void onServerChat(ServerChatEvent e)
    {
        EntityPlayerMP sender = e.player;
        List<EntityPlayerMP> players = MinecraftServer.getServer().getConfigurationManager().playerEntityList;


        String finalMessage = ChatFormatter.ChatParser(sender);


        for (EntityPlayerMP receiver : players)
        {receiver.addChatMessage(new ChatComponentText(finalMessage + "<" + e.username + ">: " + e.message));
        }

        BetterChat.bLog.info(sender.getDisplayName() + " said: " + e.message);
        e.setCanceled(true);
    }
    //endregion
}