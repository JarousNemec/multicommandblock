package com.strejdajara.multicommandblock.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.strejdajara.multicommandblock.MultiCommandBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
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
            LOGGER.info("Script file %s doesn't exist.", filename);
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

    /*
        private File returnConfigFilePath() {
            String name = Minecraft.getInstance().getIntegratedServer().getFolderName();
            String pathToFolder = (".\\saves\\" + name + "\\multiCommandBlockCommands");
            String pathToConfFile = (pathToFolder + "\\configScripts.dat");

            File file = new File(pathToFolder);
            //Creating the directory
            boolean bool = file.mkdirs();
            if (bool) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Sorry couldnt create specified directory");
            }

            File configFile = new File(pathToConfFile);
            return configFile;
        }


        private void saveProperty(java.util.Properties config) {
            config.setProperty(USERNAME_PROPERTY_KEY, "jaja");
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
    */
/*
    private void loadProperty(java.util.Properties config, File configFile) {
        try {
            FileInputStream inputStream = new FileInputStream(configFile);
            config.load(inputStream);
            String username = config.getProperty(USERNAME_PROPERTY_KEY);
            LOGGER.info("This is variable from config: " + username);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    /*
    boolean isBlockPoweredYet = false;

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
       LOGGER.info("SAPPHIRE_ORE_HERE4");

        String positionMessage = pos.getX() + "-" + pos.getY() + "-" + pos.getZ();

        //interceptChatMessage(positionMessage);

        java.util.Properties config = new java.util.Properties();

        if (worldIn.isBlockPowered(pos) && worldIn.getRedstonePowerFromNeighbors(pos) == 15) {
            if (!isBlockPoweredYet) {

                LOGGER.info("getRedstonePowerFromNeighbors(pos)...." + worldIn.getRedstonePowerFromNeighbors(pos));
                LOGGER.info("isBlockPowered(pos)...." + worldIn.isBlockPowered(pos));
                //ce.Processor("C:\\Projekty\\MCprojekty\\multicommandblock\\run\\commandsForCommandBlockOne.txt");
                //Random r = new Random();
                //RandomN = r.nextInt(1000);

                //LOGGER.info(RandomN);
                saveProperty(config);


                isBlockPoweredYet = true;
            }

        } else if (worldIn.isBlockPowered(pos) && worldIn.getRedstonePowerFromNeighbors(pos) < 15 && worldIn.getRedstonePowerFromNeighbors(pos) > 1) {
            if (!isBlockPoweredYet) {

                LOGGER.info("getRedstonePowerFromNeighbors(pos)...." + worldIn.getRedstonePowerFromNeighbors(pos));
                LOGGER.info("isBlockPowered(pos)...." + worldIn.isBlockPowered(pos));
                //loadProperty(config, configFile);

            }

        } else {
            LOGGER.info("DEACTIVATED4");
            isBlockPoweredYet = false;
        }

    }


        public static void sendMessage(String text) {
            StringTextComponent component = new StringTextComponent(text);
            ClientChatReceivedEvent event = new ClientChatReceivedEvent(ChatType.CHAT, component);
            MinecraftForge.EVENT_BUS.post(event); // Let other mods pick up the new message
            if (!event.isCanceled()) {
                Minecraft.getInstance().getIntegratedServer().getPlayerList().getPlayers().get(0).sendMessage(component);
                Minecraft.getInstance().getIntegratedServer().getPlayerList().getPlayers().get(1).sendMessage(component);
            }
        }
*/
    /*
    public static boolean interceptChatMessage(String positionMessage) {

        String message = "/booor : " + positionMessage + " => ";
        ClientPlayNetHandler connection = Minecraft.getInstance().getConnection();
        if (connection != null) {
            CommandDispatcher<ISuggestionProvider> commandDispatcher = connection.getCommandDispatcher();
            CommandSource commandSource = Minecraft.getInstance().player.getCommandSource();
            try {
                commandDispatcher.execute(message.substring(1), commandSource);
            } catch (CommandSyntaxException exception) {
                commandSource.sendErrorMessage(TextComponentUtils.toTextComponent(exception.getRawMessage()));
                if (exception.getInput() != null && exception.getCursor() >= 0) {
                    ITextComponent suggestion = new StringTextComponent("")
                            .applyTextStyle(TextFormatting.GRAY)
                            .applyTextStyle(style -> style.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, message)));
                    int textLength = Math.min(exception.getInput().length(), exception.getCursor());
                    if (textLength > 10) {
                        suggestion.appendText("...");
                    }

                    suggestion.appendText(exception.getInput().substring(Math.max(0, textLength - 10), textLength));
                    if (textLength < exception.getInput().length()) {
                        suggestion.appendSibling(new StringTextComponent(exception.getInput().substring(textLength))
                                .applyTextStyles(TextFormatting.RED, TextFormatting.UNDERLINE));
                    }

                    suggestion.appendSibling(new TranslationTextComponent("command.context.here")
                            .applyTextStyles(TextFormatting.RED, TextFormatting.ITALIC));
                    commandSource.sendErrorMessage(suggestion);
                }
            }
        }
        return true;

    }
*/
}
