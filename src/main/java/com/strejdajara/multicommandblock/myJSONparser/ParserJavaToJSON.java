package com.strejdajara.multicommandblock.myJSONparser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ParserJavaToJSON {
    public ParserJavaToJSON(){

    }
    public String ReturnParsedObjects(MultiCommandBlocksScriptsSetting deparsedObjects) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(deparsedObjects);
    }
}
