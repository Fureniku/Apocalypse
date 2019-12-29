package com.silvaniastudios.apocalypse.blocks;

import com.google.common.collect.ImmutableList;
import com.silvaniastudios.apocalypse.Apocalypse;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeadLog extends BlockLog {
	
	protected String name;
	
	public DeadLog(String name) {
		this.name = name;
		setUnlocalizedName(Apocalypse.MODID + "." + name);
		setRegistryName(name);
		setCreativeTab(Apocalypse.tabApocBlocks);
		setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}
	
	public void registerItemModel(Item itemBlock) {
		Apocalypse.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		StateMapperBase b = new DefaultStateMapper();
		BlockStateContainer bsc = this.getBlockState();
		ImmutableList<IBlockState> values = bsc.getValidStates();
		
		for(IBlockState state : values) {
			ModelResourceLocation mrl = new ModelResourceLocation(state.getBlock().getRegistryName(), b.getPropertyString(state.getProperties()));
			
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(state.getBlock()), this.getMetaFromState(state), mrl);
		}
	}
	
	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return false;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta == 1) { return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.X); }
		if (meta == 2) { return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z); }
		if (meta == 3) { return this.getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE); }
		
		return this.getDefaultState();
    }
	
	@Override
    public int getMetaFromState(IBlockState state) {
		int meta = 0;
		switch (state.getValue(LOG_AXIS)) {
		case X:
			meta = 1;
			break;
	    case Y:
			meta = 0;
			break;
		case Z:
			meta = 2;
			break;
		case NONE:
			meta = 3;
			break;
}
        return meta;
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
	}

}
