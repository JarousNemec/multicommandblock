package com.strejdajara.multicommandblock.util;

import com.strejdajara.multicommandblock.MultiCommandBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerRegistry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CommandExecutor {
    private static Logger LOGGER;

    public static void main(String[] args) {
        LOGGER = MultiCommandBlock.getLogger();
    }

    ArrayList<String> commandsList;

    private ServerPlayerEntity playerEntity;


    public void Processor(String filename) {

        commandsList = new ArrayList<String>();
        try {
            playerEntity = Minecraft.getInstance().getIntegratedServer().getPlayerList().getPlayers().get(0);
            Scanner myReader = new Scanner(new File(filename));
            readData(myReader);
        } catch (FileNotFoundException e) {
            LOGGER.info("Script file %s doesn't exist.",filename);
        }
    }

    private void readData(Scanner myReader) {

        try {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                LOGGER.info(data);


            }
            myReader.close();
        } catch (Exception e) {
            LOGGER.error("CommandExecutor - Read commands from script file failed. ", e);
        } finally {
            myReader.close();
        }
    }


    private void prepareCommand() {

    }


    private void Execute() {

    }
}
