package com.strejdajara.multicommandblock.myJSONparser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strejdajara.multicommandblock.CommandsFile;
import com.strejdajara.multicommandblock.prototipesCODE.Company;
import com.strejdajara.multicommandblock.prototipesCODE.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CommandsStringSaver {
    public CommandsStringSaver() {

    }

    public void SaveMultiCommandsBlocksToFile(String scripts, File file) throws IOException {

        FileWriter writer = new FileWriter(file);

        try {
            writer.write(scripts);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
