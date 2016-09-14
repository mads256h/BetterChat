package com.mads256c.betterchat;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;


//region Command Handler
public class CommandHandler extends CommandBase
{

    @Override
    public String getCommandName() {
        return "betterchat";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/betterchat help for help";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] args) {
        if (args.length != 0) {
                if (args[0].equals("reload")) {
                    ConfigHandler.getConfig(ServerProxy.config);
                    iCommandSender.addChatMessage(new ChatComponentText("Reloaded BetterChat config..."));
                }
                else if (args[0].equals("help")) {
                    iCommandSender.addChatMessage(new ChatComponentText("BetterChat help"));
                    iCommandSender.addChatMessage(new ChatComponentText("'/betterchat reload' to reload the config file"));
                }
            }
        else {
            iCommandSender.addChatMessage(new ChatComponentText(getCommandUsage(iCommandSender)));
        }
    }

}
//endregion