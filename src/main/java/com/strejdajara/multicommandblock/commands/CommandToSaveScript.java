package com.strejdajara.multicommandblock.commands;

import com.mojang.brigadier.ResultConsumer;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.server.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

public class CommandToSaveScript extends CommandSource {

    private static final Logger LOGGER = LogManager.getLogger();


    public CommandToSaveScript(ICommandSource sourceIn, Vec3d posIn, Vec2f rotationIn, ServerWorld worldIn, int permissionLevelIn, String nameIn, ITextComponent displayNameIn, MinecraftServer serverIn, @Nullable Entity entityIn) {
        super(sourceIn, posIn, rotationIn, worldIn, permissionLevelIn, nameIn, displayNameIn, serverIn, entityIn);
    }

    public void execute(MinecraftServer server, ICommandSource sender, String[] params) throws CommandException {

        LOGGER.info("execute called");


        if (params != null && params.length > 0) {
            for (String param : params) {
                String message = "Echo : " + param;
                StringTextComponent text = new StringTextComponent(message);
                text.getStyle().setColor(TextFormatting.RED);
                sender.sendMessage(text);
            }
        }
    }

    @Override
    public String getName() {
        return "echo";
    }

    public String getUsage(ICommandSource sender) {
        return "command.echo.usage";
    }
}
