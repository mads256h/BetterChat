package com.mads256c.betterchat;

import net.minecraftforge.common.config.Configuration;

/**
 * Created by Mads on 13-09-2016.
 */
public class ConfigHandler
{
    public static String[] Players;
    public static String[] GroupColors;
    public static String[] GroupTag;

    public static String NoGroupColor;
    public static String NoGroupTag;

    public static String NoGroupJoinMessage;
    public static boolean NoGroupJoinMessageEnabled;

    public static String[] DefaultPlayers = {"the_master256c, miliku", "miliku", "the_master256c"};
    public static String[] DefaultGroupColors = {"BOLD, DARK_AQUA", "ITALIC, DARK_PURPLE"};
    public static String[] DefaultGroupTag = {"[Dev]", "[Admin]", "[Mod]"};

    public static String DefaultNoGroupColor = "DARK_GRAY";
    public static String DefaultNoGroupTag = "[NoGroup]";

    public static String DefaultNoGroupJoinMessage = "You don't have a group ask an admin to add you to one.";
    public static boolean DefaultNoGroupJoinMessageEnabled = false;


    public static void getConfig(Configuration config)
    {
        config.load();

            Players = config.getStringList("Players", Configuration.CATEGORY_GENERAL, DefaultPlayers, "Assign people to groups here. Separate with enter");
            GroupColors = config.getStringList("GroupColors", Configuration.CATEGORY_GENERAL, DefaultGroupColors, "Assign group color here. Separate with enter");
            GroupTag = config.getStringList("GroupTag", Configuration.CATEGORY_GENERAL, DefaultGroupTag, "Assign group tag here. Separate with enter");

            NoGroupColor = config.getString("NoGroupColor", "NoGroup", DefaultNoGroupColor, "Assign no group color here");
            NoGroupTag = config.getString("NoGroupTag", "NoGroup", DefaultNoGroupTag, "Assign no group tag here");
            NoGroupJoinMessage = config.getString("NoGroupMessage", "NoGroup", DefaultNoGroupJoinMessage, "A message to display to a NoGroup user joining");
            NoGroupJoinMessageEnabled = config.getBoolean("NoGroupMessageEnabled", "NoGroup", DefaultNoGroupJoinMessageEnabled, "Enable / Disable the NoGroupMessage");

        config.save();
    }

    public static String[][] MultiArrayParser(String[] array)
    {
        String[][] finalArray = new String[array.length][];

        for (int i = 0; i < array.length; i++)
        {
            finalArray[i] = array[i].split("\\s*,\\s*");
        }

        return finalArray;
    }
}
