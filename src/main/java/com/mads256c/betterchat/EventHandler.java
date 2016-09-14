package com.mads256c.betterchat;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

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

    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void playerJoin(EntityJoinWorldEvent i)
    {
        if(i.entity instanceof EntityPlayer && ConfigHandler.NoGroupJoinMessageEnabled) {
            List<String> color = new ArrayList<String>();
            color.add(ConfigHandler.NoGroupColor);
            if (ChatFormatter.ChatParser((EntityPlayerMP) i.entity).equals(ChatFormatter.ColorParser(color) + ConfigHandler.NoGroupTag + EnumChatFormatting.RESET.toString() + " ")) {
                ((EntityPlayer) i.entity).addChatMessage(new ChatComponentText(ConfigHandler.NoGroupJoinMessage));
            }
        }
    }
}