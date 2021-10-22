package com.strejdajara.multicommandblock;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;

@Mod.EventBusSubscriber(Dist.DEDICATED_SERVER)
public class ModServerNetworkingOperator extends net.minecraftforge.eventbus.api.Event {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final java.util.Properties config = new java.util.Properties();

/*
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void Serverevent(ServerChatEvent event){
        LOGGER.info("tady volam ze serveru");
    }*/

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void ServerChatEvent(ServerChatEvent event) {

        //String command = "say nothing";
        String commandPrefix = "*+*/";
        //String chatMSG = "*+*/say nothing";
        String chatMSG = event.getMessage();

        LOGGER.info("Something became on server: " + chatMSG);

        String gotPrefix = returnPrefixFromMSG(chatMSG, commandPrefix.length());
        if (gotPrefix.equals(commandPrefix)) {
            LOGGER.info("heeeeeeeeeeeeeeeeeeeeeeeeej");
            saveProperty(config, returnCommandBehindPrefix(chatMSG, commandPrefix.length()));
        }
    }

    private static String returnPrefixFromMSG(String chatMSG, int prefixLenght) {
        String prefix = "";

        if (chatMSG.length() > prefixLenght) {
            prefix = chatMSG.substring(0, prefixLenght);
        }
        LOGGER.info("commmand prefix: ," + prefix + ",");
        return prefix;
    }

    private static String returnCommandBehindPrefix(String chatMSG, int prefixLenght) {
        //String command = "say nothing";
        int msgLenght = chatMSG.length();

        String command = chatMSG.substring(prefixLenght, msgLenght);
        LOGGER.info("now we have command");
        return command;
    }

    private static File returnConfigFilePath() {
        //String name = Minecraft.getInstance().getIntegratedServer().getFolderName();
        //String pathToFolder = (".\\saves\\" + name + "\\multiCommandBlockCommands");
        String pathToFolder = (".\\world");
        String pathToConfFile = ("configScripts.dat");

  /*      File file = new File(pathToFolder);
        //Creating the directory
        boolean bool = file.mkdirs();
        if (bool) {
            System.out.println("Directory created successfully");
        } else {
            System.out.println("Sorry couldnt create specified directory");
        }
*/
        File configFile = new File(pathToConfFile);
        LOGGER.info("now we have file for commands");
        return configFile;
    }

    private static final String USERNAME_PROPERTY_KEY = "username2";

    private static void saveProperty(java.util.Properties config, String command) {
        config.setProperty(USERNAME_PROPERTY_KEY, command);
        File configFile = returnConfigFilePath();
        try {
            FileOutputStream outputStream = new FileOutputStream(configFile);
            config.store(outputStream, null);
            outputStream.close();
            LOGGER.info("Successfully writed to config");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
