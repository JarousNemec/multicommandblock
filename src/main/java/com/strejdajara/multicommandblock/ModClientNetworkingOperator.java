package com.strejdajara.multicommandblock;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ModClientNetworkingOperator {
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void CommandClientHandler(ClientChatEvent cliEv) {
        LOGGER.info("Something became on client: " + cliEv.getMessage());
        //sendMessage("tak sme na serveru konecne");
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
}
