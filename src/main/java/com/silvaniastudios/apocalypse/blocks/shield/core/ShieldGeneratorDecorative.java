package com.silvaniastudios.apocalypse.blocks.shield.core;

import com.silvaniastudios.apocalypse.blocks.shield.ShieldPartBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;

public class ShieldGeneratorDecorative extends ShieldPartBase {

	public ShieldGeneratorDecorative(String name) {
		super(name);
	}

	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}
