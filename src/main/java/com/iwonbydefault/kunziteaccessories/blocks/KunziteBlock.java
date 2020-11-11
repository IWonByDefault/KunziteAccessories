package com.iwonbydefault.kunziteaccessories.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class KunziteBlock extends Block {

    public KunziteBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(8.0f, 10.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }
}
