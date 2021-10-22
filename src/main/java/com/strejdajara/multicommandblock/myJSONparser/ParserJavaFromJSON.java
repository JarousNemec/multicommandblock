package com.strejdajara.multicommandblock.myJSONparser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strejdajara.multicommandblock.prototipesCODE.Staff;

import java.io.IOException;

public class ParserJavaFromJSON {
    public ParserJavaFromJSON() {

    }

    public MultiCommandBlocksScriptsSetting ReturnDeparsedObjects(String parsedcObjects) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(parsedcObjects, MultiCommandBlocksScriptsSetting.class);
    }
}
