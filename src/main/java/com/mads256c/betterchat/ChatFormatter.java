package com.mads256c.betterchat;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mads on 12-09-2016.
 */

public class ChatFormatter {

    //region Variables

    public static String[] PlayersTag = new String[10];

    public static List<String> Players1Color = new ArrayList<String>();
    public static List<String> Players2Color = new ArrayList<String>();
    public static List<String> Players3Color = new ArrayList<String>();
    public static List<String> Players4Color = new ArrayList<String>();
    public static List<String> Players5Color = new ArrayList<String>();
    public static List<String> Players6Color = new ArrayList<String>();
    public static List<String> Players7Color = new ArrayList<String>();
    public static List<String> Players8Color = new ArrayList<String>();
    public static List<String> Players9Color = new ArrayList<String>();
    public static List<String> Players10Color = new ArrayList<String>();


    public static List<String> Players1 = new ArrayList<String>();
    public static List<String> Players2 = new ArrayList<String>();
    public static List<String> Players3 = new ArrayList<String>();
    public static List<String> Players4 = new ArrayList<String>();
    public static List<String> Players5 = new ArrayList<String>();
    public static List<String> Players6 = new ArrayList<String>();
    public static List<String> Players7 = new ArrayList<String>();
    public static List<String> Players8 = new ArrayList<String>();
    public static List<String> Players9 = new ArrayList<String>();
    public static List<String> Players10 = new ArrayList<String>();

    //endregion


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
            finalString += EnumChatFormatting.DARK_GRAY.toString() + "[No Group]";
        }

        finalString += EnumChatFormatting.RESET + " ";

        return finalString;
    }
    //endregion
}
