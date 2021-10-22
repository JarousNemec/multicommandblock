package com.strejdajara.multicommandblock;

import net.minecraft.client.Minecraft;

import java.io.File;

public class CommandsFile {
    public CommandsFile(){

    }
    public File returnConfigFilePath() {

       // Minecraft.getInstance().getIntegratedServer().get

        String name = Minecraft.getInstance().getIntegratedServer().getFolderName();
        String pathToFolder = (".\\saves\\" + name + "\\multiCommandBlockCommands");
        String pathToConfFile = (pathToFolder + "\\configScripts.json");

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
}
