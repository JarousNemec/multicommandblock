package com.strejdajara.multicommandblock.prototipesCODE;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import org.lwjgl.system.windows.MSG;

public class networking {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("mymodid", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    int id = 0;
    String mess = "ahoj";
    public networking(){

        INSTANCE.registerMessage(id,mess,);
        id++;
    }

}
