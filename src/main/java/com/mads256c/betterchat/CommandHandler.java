package com.mads256c.betterchat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

/**
 * Created by Mads on 12-09-2016.
 */

//region Commmand Handler
public class CommandHandler extends CommandBase
{

    @Override
    public String getCommandName() {
        return "reloadchat";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "Reloads BetterChat config.";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) {
        if (iCommandSender instanceof EntityPlayer)
        {
            ServerProxy.getConfig();
            BetterChat.bLog.info("Reloaded BetterChat config...");
            EntityPlayer player = (EntityPlayer)iCommandSender;
                    player.addChatMessage(new ChatComponentText("Reloaded BetterChat config..."));
        }
        else
        {
            ServerProxy.getConfig();
            BetterChat.bLog.info("Reloaded BetterChat config...");
        }
    }
}
//endregion