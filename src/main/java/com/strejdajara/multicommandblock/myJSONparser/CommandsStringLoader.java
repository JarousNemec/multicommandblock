package com.strejdajara.multicommandblock.myJSONparser;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class CommandsStringLoader {

    CommandsStringLoader() {

    }

    public String returnMultiCommandsBlocksScripts(File file) throws IOException {
        String commands = "";

        commands = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        return commands;
    }
}
