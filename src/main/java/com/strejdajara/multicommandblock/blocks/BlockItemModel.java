package com.strejdajara.multicommandblock.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BlockItemModel extends BlockItem {

    public BlockItemModel(Block block) {
        super(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }
}
