package com.silvaniastudios.apocalypse.blocks.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidPollutedWater extends Fluid {

	public FluidPollutedWater(String fluidName, ResourceLocation still, ResourceLocation flowing) {
		super(fluidName, still, flowing);
	}
	
	@Override
	public int getColor() {
		return 0;
	}

}
