package com.silvaniastudios.apocalypse.blocks.shield;

import com.silvaniastudios.apocalypse.ApocBlocks;
import com.silvaniastudios.apocalypse.Apocalypse;
import com.silvaniastudios.apocalypse.blocks.BlockBase;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShieldRelayBlock extends BlockBase {
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public ShieldRelayBlock(String name) {
		super(Material.IRON, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setCreativeTab(Apocalypse.tabApocMachines);
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		if (checkPlacementValidity(world, pos, placer.getHorizontalFacing(), false)) {
			//stuff
		}
		
		if (placer.getHorizontalFacing() == EnumFacing.NORTH) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		}
		if (placer.getHorizontalFacing() == EnumFacing.EAST) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
		if (placer.getHorizontalFacing() == EnumFacing.SOUTH) {
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		}
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		boolean place = false;
		if (!place) {
			place = checkPlacementValidity(worldIn, pos, EnumFacing.NORTH, true);
		}
		
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && place;
    }
	
	public boolean checkPlacementValidity(World world, BlockPos pos, EnumFacing dir, boolean simulate) {
		EnumFacing right = EnumFacing.NORTH;
		
		if (dir == EnumFacing.NORTH) { right = EnumFacing.EAST;  } 
		if (dir == EnumFacing.EAST)  { right = EnumFacing.SOUTH; } 
		if (dir == EnumFacing.SOUTH) { right = EnumFacing.WEST;  } 
		
		//Near-left to far-right for placement.
		BlockPos nl = pos;
		BlockPos fl = pos.offset(dir);
		BlockPos nr = pos.offset(right);
		BlockPos fr = pos.offset(dir).offset(right);
		
		boolean nearLeft  = world.getBlockState(nl).getBlock().isReplaceable(world, nl);
		boolean farLeft   = world.getBlockState(fl).getBlock().isReplaceable(world, fl);
		boolean nearRight = world.getBlockState(nr).getBlock().isReplaceable(world, nr);
		boolean farRight  = world.getBlockState(fr).getBlock().isReplaceable(world, fr);
		
		if (nearLeft && farLeft && nearRight && farRight) {
			if (!simulate) {
				FakeBlock fb = ApocBlocks.fake_block;
				if (dir == EnumFacing.NORTH) {
					world.setBlockState(fl, fb.getDefaultState());
					world.setBlockState(fr, fb.getDefaultState());
					world.setBlockState(nr, fb.getDefaultState());
				}
				
				if (dir == EnumFacing.EAST) {
					world.setBlockState(fl, fb.getDefaultState());
					world.setBlockState(fr, fb.getDefaultState());
					world.setBlockState(nr, fb.getDefaultState());
				}
				
				if (dir == EnumFacing.SOUTH) {
					world.setBlockState(fl, fb.getDefaultState());
					world.setBlockState(fr, fb.getDefaultState());
					world.setBlockState(nr, fb.getDefaultState());
				}
				
				if (dir == EnumFacing.WEST) {
					world.setBlockState(fl, fb.getDefaultState());
					world.setBlockState(fr, fb.getDefaultState());
					world.setBlockState(nr, fb.getDefaultState());
				}
				
				FakeTileEntity fl_te = (FakeTileEntity) world.getTileEntity(fl);
				FakeTileEntity fr_te = (FakeTileEntity) world.getTileEntity(fr);
				FakeTileEntity nr_te = (FakeTileEntity) world.getTileEntity(nr);
				
				if (fl_te != null) { fl_te.setCoordinates(pos); }
				if (fr_te != null) { fr_te.setCoordinates(pos); }
				if (nr_te != null) { nr_te.setCoordinates(pos); }
			}
			return true;
		}
		System.out.println("Invalid placement (one or more blocks can't be placed)");
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		 return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockHorizontal.FACING).getHorizontalIndex();
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
