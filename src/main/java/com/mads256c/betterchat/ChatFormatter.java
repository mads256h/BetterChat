package com.mads256c.betterchat;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mads on 12-09-2016.
 */
public class ChatFormatter {


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

    public static String ChatParser (EntityPlayerMP sender)
    {
        String finalString = "";


        sender.refreshDisplayName();
        if (Players1.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players1Color) + PlayersTag[0];
        }
        if (Players2.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players2Color) + PlayersTag[1];
        }
        if (Players3.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players3Color) + PlayersTag[2];
        }
        if (Players4.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players4Color) + PlayersTag[3];
        }
        if (Players5.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players5Color) + PlayersTag[4];
        }
        if (Players6.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players6Color) + PlayersTag[5];
        }
        if (Players7.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players7Color) + PlayersTag[6];
        }
        if (Players8.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players8Color) + PlayersTag[7];
        }
        if (Players9.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players9Color) + PlayersTag[8];
        }
        if (Players10.contains(sender.getDisplayName())) {
            finalString += ColorParser(Players10Color) + PlayersTag[9];
        }
        else if (finalString.equals("")) {
            finalString += "";
        }

        finalString += EnumChatFormatting.RESET + " ";

        return finalString;
    }
}
