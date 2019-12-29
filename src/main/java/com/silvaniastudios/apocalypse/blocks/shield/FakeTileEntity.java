package com.silvaniastudios.apocalypse.blocks.shield;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class FakeTileEntity extends TileEntity {
	
	public int connected_x;
	public int connected_y;
	public int connected_z;
	
	public FakeTileEntity() {}
	
	public void setCoordinates(BlockPos pos) { 
		connected_x = pos.getX();
		connected_y = pos.getY();
		connected_z = pos.getZ();
		this.markDirty();
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("x", connected_x);
		nbt.setInteger("y", connected_y);
		nbt.setInteger("z", connected_z);
		return nbt;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		connected_x = nbt.getInteger("x");
		connected_y = nbt.getInteger("y");
		connected_z = nbt.getInteger("z");
	}

}
