package com.strejdajara.multicommandblock.blocks;

import com.strejdajara.multicommandblock.util.MultiCommandBlockScriptsIDE;
import javafx.application.Application;
import javafx.stage.Stage;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.swing.*;


public class SapphireOre extends Block {
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


    boolean isBlockPoweredYet = false;

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        LOGGER.info("SAPPHIRE_ORE_HERE");

        if (worldIn.isBlockPowered(pos) && worldIn.getRedstonePowerFromNeighbors(pos) == 15) {
            if (!isBlockPoweredYet) {
                LOGGER.info("getRedstonePowerFromNeighbors(pos)...." + worldIn.getRedstonePowerFromNeighbors(pos));
                LOGGER.info("isBlockPowered(pos)...." + worldIn.isBlockPowered(pos));
                isBlockPoweredYet = true;
            }

        } else if (worldIn.isBlockPowered(pos) && worldIn.getRedstonePowerFromNeighbors(pos) < 15 && worldIn.getRedstonePowerFromNeighbors(pos) > 1) {
            if (!isBlockPoweredYet) {

                LOGGER.info("getRedstonePowerFromNeighbors(pos)...." + worldIn.getRedstonePowerFromNeighbors(pos));
                LOGGER.info("isBlockPowered(pos)...." + worldIn.isBlockPowered(pos));
            }

        } else {
            LOGGER.info("DEACTIVATED");
        }
    }
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        LOGGER.info("The saphere has been activated");
        LOGGER.info("player "+player);
        LOGGER.info("possition "+pos);
        Minecraft.getInstance().displayGuiScreen(new MultiCommandBlockScriptsIDE());

        return ActionResultType.SUCCESS;
    }
}
