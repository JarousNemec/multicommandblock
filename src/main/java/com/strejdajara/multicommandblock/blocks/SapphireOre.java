package com.strejdajara.multicommandblock.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block {

    public SapphireOre() {
        super(
                Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 3.0f )
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .sound(SoundType.GLASS)
        );
    }
}
