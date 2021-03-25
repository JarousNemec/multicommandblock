package com.strejdajara.multicommandblock.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.io.*;

public class SapphireOre extends Block {
    private static final String USERNAME_PROPERTY_KEY = "username2";
    //CommandExecutor ce;
    private Integer RandomN;

    public SapphireOre() {
        super(
                Block.Properties.create(Material.ROCK)
                        .hardnessAndResistance(3.0f, 3.0f)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(2)
                        .sound(SoundType.GLASS)
        );

    }

    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        LOGGER.info("The saphere has been activated");
        LOGGER.info("player "+player);
        LOGGER.info("possition "+pos);

        return ActionResultType.PASS;
    }
}
