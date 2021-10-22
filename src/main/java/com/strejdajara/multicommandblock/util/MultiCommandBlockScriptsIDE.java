package com.strejdajara.multicommandblock.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.DemoScreen;
import net.minecraft.client.gui.screen.EditBookScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.client.gui.GuiUtils;

import javax.swing.*;

public class MultiCommandBlockScriptsIDE extends Screen {

    public MultiCommandBlockScriptsIDE() {
        super(new TranslationTextComponent("screen.guipunishkick.spawn"));

    }

    private final int WIDTH = this.width;
    private final int HEIGHT = this.height;

    private TextFieldWidget command1;
    private TextFieldWidget command2;


    @Override
    protected void init() {
        int relX = WIDTH / 2;
        int relY = HEIGHT / 2;
        this.command1 = new TextFieldWidget(font, relX + 10, relY + 10, 400, 25, "some window");
        this.command2 = new TextFieldWidget(font, relX + 10, relY + 40, 400, 25, "some window2");

        command1.setVisible(true);
        this.command1.setCanLoseFocus(true);
        this.command1.changeFocus(true);
        this.command1.setMaxStringLength(500);
        command1.setText("put here some text...");

        command2.setVisible(true);
        this.command2.setCanLoseFocus(true);
        this.command2.changeFocus(true);
        this.command2.setMaxStringLength(500);
        command2.setText("put here some text...");

        this.children.add(this.command1);
        this.setFocusedDefault(this.command1);

        this.children.add(this.command2);
    }
/*
    protected void keyTyped(char par1, int par2) {
        super.charTyped(par1, par2);
        this.command1.charTyped(par1, par2);
    }

    public void updateScreen() {
        this.updateScreen();
        this.command1.moveCursorBy(this.command1.getText().length());
    }

    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        this.command1.mouseClicked(x, y, btn);
    }
*/
    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int relX = (this.width - WIDTH) / 2;
        int relY = (this.height - HEIGHT) / 2;
        this.blit(relX, relY, 0, 0, WIDTH, HEIGHT);
        this.command1.render(mouseX, mouseY, partialTicks);
        this.command2.render(mouseX, mouseY, partialTicks);
        super.render(mouseX, mouseY, partialTicks);
    }

    public void onClose(){

    }
/*
    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static void open() {
        Minecraft.getInstance().displayGuiScreen(new MultiCommandBlockScriptsIDE());
    }
*/
}
