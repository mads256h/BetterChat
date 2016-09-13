package com.mads256c.betterchat;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mads on 12-09-2016.
 */

public class ChatFormatter {
    
    //region Color Parser

    //Parses the color(s) from the config returns String finalString
    public static String ColorParser(List<String> Colorlist)
    {
        String finalString = "";

        if (Colorlist.contains("AQUA"))
        {
            finalString += EnumChatFormatting.AQUA.toString();
        }
        if (Colorlist.contains("BLACK"))
        {
            finalString += EnumChatFormatting.BLACK.toString();
        }
        if (Colorlist.contains("BLUE"))
        {
            finalString += EnumChatFormatting.BLUE.toString();
        }
        if (Colorlist.contains("BOLD"))
        {
            finalString += EnumChatFormatting.BOLD.toString();
        }
        if (Colorlist.contains("DARK_AQUA"))
        {
            finalString += EnumChatFormatting.DARK_AQUA.toString();
        }
        if (Colorlist.contains("DARK_BLUE"))
        {
            finalString += EnumChatFormatting.DARK_BLUE.toString();
        }
        if (Colorlist.contains("DARK_GRAY"))
        {
            finalString += EnumChatFormatting.DARK_GRAY.toString();
        }
        if (Colorlist.contains("DARK_GREEN"))
        {
            finalString += EnumChatFormatting.DARK_GREEN.toString();
        }
        if (Colorlist.contains("DARK_PURPLE"))
        {
            finalString += EnumChatFormatting.DARK_PURPLE.toString();
        }
        if (Colorlist.contains("DARK_RED"))
        {
            finalString += EnumChatFormatting.DARK_RED.toString();
        }
        if (Colorlist.contains("GOLD"))
        {
            finalString += EnumChatFormatting.GOLD.toString();
        }
        if (Colorlist.contains("GRAY"))
        {
            finalString += EnumChatFormatting.GRAY.toString();
        }
        if (Colorlist.contains("GREEN"))
        {
            finalString += EnumChatFormatting.GREEN.toString();
        }
        if (Colorlist.contains("ITALIC"))
        {
            finalString += EnumChatFormatting.ITALIC.toString();
        }
        if (Colorlist.contains("LIGHT_PURPLE"))
        {
            finalString += EnumChatFormatting.LIGHT_PURPLE.toString();
        }
        if (Colorlist.contains("OBFUSCATED"))
        {
            finalString += EnumChatFormatting.OBFUSCATED.toString();
        }
        if (Colorlist.contains("RED"))
        {
            finalString += EnumChatFormatting.RED.toString();
        }
        if (Colorlist.contains("RESET"))
        {
            finalString += EnumChatFormatting.RESET.toString();
        }
        if (Colorlist.contains("STRIKETHROUGH"))
        {
            finalString += EnumChatFormatting.STRIKETHROUGH.toString();
        }
        if (Colorlist.contains("UNDERLINE"))
        {
            finalString += EnumChatFormatting.UNDERLINE.toString();
        }
        if (Colorlist.contains("WHITE"))
        {
            finalString += EnumChatFormatting.WHITE.toString();
        }
        if (Colorlist.contains("YELLOW"))
        {
            finalString += EnumChatFormatting.YELLOW.toString();
        }

        return finalString;
    }

    //endregion

    //region Chat Parser

    // Adds color and tags and returns String finalString
    public static String ChatParser (EntityPlayerMP sender)
    {
        String finalString = "";


        sender.refreshDisplayName();



        for (int i = 0; i < ConfigHandler.Players.length; i++)
        {
            for (int i1 = 0; i1 < ConfigHandler.MultiArrayParser(ConfigHandler.Players)[i].length; i1++ )
            {
                if(ConfigHandler.MultiArrayParser(ConfigHandler.Players)[i][i1].equals(sender.getDisplayName()))
                {
                    if (ConfigHandler.MultiArrayParser(ConfigHandler.GroupColors).length > i) {
                        finalString += ColorParser(Arrays.asList(ConfigHandler.MultiArrayParser(ConfigHandler.GroupColors)[i]));
                    }
                    if (ConfigHandler.GroupTag.length > i) {
                        finalString += ConfigHandler.GroupTag[i];
                    }
                    finalString += EnumChatFormatting.RESET;
                }
            }
        }


        if (finalString.equals("")) {
            finalString += ConfigHandler.NoGroupColor + ConfigHandler.NoGroupTag;
        }

        finalString += EnumChatFormatting.RESET + " ";

        return finalString;
    }
    //endregion
}
