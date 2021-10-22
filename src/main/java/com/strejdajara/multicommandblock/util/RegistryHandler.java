package com.strejdajara.multicommandblock.util;

import com.strejdajara.multicommandblock.MultiCommandBlock;
import com.strejdajara.multicommandblock.blocks.BlockItemModel;
import com.strejdajara.multicommandblock.blocks.SapphireOre;
import com.strejdajara.multicommandblock.items.ItemModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class RegistryHandler {

    //Register
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MultiCommandBlock.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MultiCommandBlock.MOD_ID);

    //Items
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemModel::new);
    public static final RegistryObject<Item> SMARAKD = ITEMS.register("smarakd", ItemModel::new);

    //Blocks
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", SapphireOre::new);

    //BlockItems
    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> new BlockItemModel(SAPPHIRE_ORE.get()));

    //Constructor / init method
    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
