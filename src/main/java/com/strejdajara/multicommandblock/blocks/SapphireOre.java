package com.strejdajara.multicommandblock.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.io.*;

public class SapphireOre extends Block {
    private static final String USERNAME_PROPERTY_KEY = "username2";
    //CommandExecutor ce;
    private Integer RandomN;

    public SapphireOre() {
        super(
                Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance(3.0f, 3.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(2)
                        .sound(SoundType.GLASS)
        );
        //ce = new CommandExecutor();

    }

    boolean isBlockPoweredYet = false;

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        LOGGER.info("SAPPHIRE_ORE_HERE4");

        String positionMessage  = pos.getX() + "-" + pos.getY() + "-" + pos.getZ();

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
/*
    public static boolean interceptChatMessage(String positionMessage) {

        String message = "/booor : "+positionMessage + " => ";
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




private File returnConfigFilePath(){
    String name = Minecraft.getInstance().getIntegratedServer().getFolderName();
    String pathToFolder = (".\\saves\\"+name+"\\multiCommandBlockCommands");
    String pathToConfFile = (pathToFolder+"\\configScripts.dat");

    File file = new File(pathToFolder);
    //Creating the directory
    boolean bool = file.mkdirs();
    if(bool){
        System.out.println("Directory created successfully");
    }else{
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
    }
}
