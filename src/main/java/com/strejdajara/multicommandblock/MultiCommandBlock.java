package com.strejdajara.multicommandblock;

import com.strejdajara.multicommandblock.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("multicommandblock")
public class MultiCommandBlock {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    //This is the mod ID var.
    public static final String MOD_ID = "multicommandblock";
    //private static final MyCommandServerHandler mcsh = new MyCommandServerHandler();
    //private static final MyCommandClientHandler mcch = new MyCommandClientHandler();

    public MultiCommandBlock() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
/*
        //register MyCommandHandler
        MyCommandHandler myCommandHandler = new MyCommandHandler();
        FMLJavaModLoadingContext.get().getModEventBus().register(myCommandHandler);
        MinecraftForge.EVENT_BUS.register(myCommandHandler);
*/
        //Add custome items to Game
        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.register(mcch);
        //MinecraftForge.EVENT_BUS.register(mcsh);

        /*ServerPlayerEntity playerEntity = Minecraft.getInstance().getIntegratedServer().getPlayerList().getPlayers().get(0);
        Minecraft.getInstance().getIntegratedServer().getCommandManager().handleCommand(playerEntity.getCommandSource(), "say hello world");*/



    }
/*
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event, ClientChatEvent CliEv) {
        event.getRegistry().registerAll(new MyCommandClientHandler(CliEv));
    }*/

    public static Logger getLogger() {
        return LOGGER;
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
}
