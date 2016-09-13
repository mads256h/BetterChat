package com.mads256c.betterchat;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import java.util.Arrays;


public class ServerProxy
        extends CommonProxy


{
    Boolean isRegistered = false;

    public static Configuration config;

    //region Config Defaults
    static String[] Default1 = {"the_master256c", "miliku"};
    static String[] Default2 = {"miliku"};
    static String[] Default3 = {"the_master256c"};
    static String[] Default4 = {"example"};
    static String[] Default5 = {"example"};
    static String[] Default6 = {"example"};
    static String[] Default7 = {"example"};
    static String[] Default8 = {"example"};
    static String[] Default9 = {"example"};
    static String[] Default10 = {"example"};

    static String[] DefaultColor1 = {"BOLD", "DARK_AQUA"};
    static String[] DefaultColor2 = {"DARK_PURPLE"};
    static String[] DefaultColor3 = {"UNDERLINE"};
    static String[] DefaultColor4 = {"RED"};
    static String[] DefaultColor5 = {"GOLD"};
    static String[] DefaultColor6 = {"BLACK"};
    static String[] DefaultColor7 = {"AQUA"};
    static String[] DefaultColor8 = {"DARK_GRAY"};
    static String[] DefaultColor9 = {"BOLD"};
    static String[] DefaultColor10 = {"STRIKETHROUGH"};

    static String[] DefaultTag = {"Admin", "Mod", "Dev", "A", "B", "C"};
//endregion

    //region Configuration
    public static void getConfig()
    {
        config.load();

        String[] PlayersGroupTag = config.getStringList("PlayersGroupTag", Configuration.CATEGORY_GENERAL, DefaultTag, "Group name tags 1, 2, 3 ,4 ect... Up to 10 groups. Seperate with enter");


        String[] PlayerColors1 = config.getStringList("PlayerGroup1Color", "Color", DefaultColor1, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors2 = config.getStringList("PlayerGroup2Color", "Color", DefaultColor2, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors3 = config.getStringList("PlayerGroup3Color", "Color", DefaultColor3, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors4 = config.getStringList("PlayerGroup4Color", "Color", DefaultColor4, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors5 = config.getStringList("PlayerGroup5Color", "Color", DefaultColor5, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors6 = config.getStringList("PlayerGroup6Color", "Color", DefaultColor6, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors7 = config.getStringList("PlayerGroup7Color", "Color", DefaultColor7, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors8 = config.getStringList("PlayerGroup8Color", "Color", DefaultColor8, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors9 = config.getStringList("PlayerGroup9Color", "Color", DefaultColor9, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");
        String[] PlayerColors10 = config.getStringList("PlayerGroup10Color", "Color", DefaultColor10, "Valid formatting: AQUA, BLACK, BLUE, BOLD, DARK_AQUA, DARK_BLUE, DARK_GRAY, DARK_GREEN, DARK_PURPLE, DARK_RED, GOLD, GRAY, GREEN, ITALIC, LIGHT_PURPLE, OBFUSCATED, RED, RESET, STRIKETHROUGH, UNDERLINE, WHITE, YELLOW. Seperate with enter");


        String[] PlayersArray1 = config.getStringList("PlayerGroup1", Configuration.CATEGORY_GENERAL, Default1, "Group 1 players. Separate with enter");
        String[] PlayersArray2 = config.getStringList("PlayerGroup2", Configuration.CATEGORY_GENERAL, Default2, "Group 2 players. Separate with enter");
        String[] PlayersArray3 = config.getStringList("PlayerGroup3", Configuration.CATEGORY_GENERAL, Default3, "Group 3 players. Separate with enter");
        String[] PlayersArray4 = config.getStringList("PlayerGroup4", Configuration.CATEGORY_GENERAL, Default4, "Group 4 players. Separate with enter");
        String[] PlayersArray5 = config.getStringList("PlayerGroup5", Configuration.CATEGORY_GENERAL, Default5, "Group 5 players. Separate with enter");
        String[] PlayersArray6 = config.getStringList("PlayerGroup6", Configuration.CATEGORY_GENERAL, Default6, "Group 6 players. Separate with enter");
        String[] PlayersArray7 = config.getStringList("PlayerGroup7", Configuration.CATEGORY_GENERAL, Default7, "Group 7 players. Separate with enter");
        String[] PlayersArray8 = config.getStringList("PlayerGroup8", Configuration.CATEGORY_GENERAL, Default8, "Group 8 players. Separate with enter");
        String[] PlayersArray9 = config.getStringList("PlayerGroup9", Configuration.CATEGORY_GENERAL, Default9, "Group 9 players. Separate with enter");
        String[] PlayersArray10 = config.getStringList("PlayerGroup10", Configuration.CATEGORY_GENERAL, Default10, "Group 10 players. Separate with enter");



        config.save();

        ChatFormatter.PlayersTag = PlayersGroupTag;

        ChatFormatter.Players1Color = Arrays.asList(PlayerColors1);
        ChatFormatter.Players2Color = Arrays.asList(PlayerColors2);
        ChatFormatter.Players3Color = Arrays.asList(PlayerColors3);
        ChatFormatter.Players4Color = Arrays.asList(PlayerColors4);
        ChatFormatter.Players5Color = Arrays.asList(PlayerColors5);
        ChatFormatter.Players6Color = Arrays.asList(PlayerColors6);
        ChatFormatter.Players7Color = Arrays.asList(PlayerColors7);
        ChatFormatter.Players8Color = Arrays.asList(PlayerColors8);
        ChatFormatter.Players9Color = Arrays.asList(PlayerColors9);
        ChatFormatter.Players10Color = Arrays.asList(PlayerColors10);



        ChatFormatter.Players1 = Arrays.asList(PlayersArray1);
        ChatFormatter.Players2 = Arrays.asList(PlayersArray2);
        ChatFormatter.Players3 = Arrays.asList(PlayersArray3);
        ChatFormatter.Players4 = Arrays.asList(PlayersArray4);
        ChatFormatter.Players5 = Arrays.asList(PlayersArray5);
        ChatFormatter.Players6 = Arrays.asList(PlayersArray6);
        ChatFormatter.Players7 = Arrays.asList(PlayersArray7);
        ChatFormatter.Players8 = Arrays.asList(PlayersArray8);
        ChatFormatter.Players9 = Arrays.asList(PlayersArray9);
        ChatFormatter.Players10 = Arrays.asList(PlayersArray10);

    }
//endregion

    public void preInit(FMLPreInitializationEvent e)
    {
        config = new Configuration(e.getSuggestedConfigurationFile());

        getConfig();

        super.preInit(e);
    }

    public void init(FMLInitializationEvent e)
    {
        super.init(e);
        if (!isRegistered) { MinecraftForge.EVENT_BUS.register(new EventHandler()); isRegistered = true; }
    }

    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
        BetterChat.bLog.info("BetterChat has loaded server-side.");
    }
}

