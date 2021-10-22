package com.strejdajara.multicommandblock.myJSONparser;

import java.util.List;

public class CommandsForMultiCommandBlock {

    public String idOfBlock;
    public List<String> commands;

    public String getIdOfBlock() {
        return idOfBlock;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setIdOfBlock(String idOfBlock) {
        this.idOfBlock = idOfBlock;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }


}
