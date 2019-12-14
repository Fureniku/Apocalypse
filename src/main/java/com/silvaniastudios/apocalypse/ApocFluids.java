package com.silvaniastudios.apocalypse;

import com.silvaniastudios.apocalypse.blocks.fluids.FluidPollutedWater;

import net.minecraft.util.ResourceLocation;

public class ApocFluids {
	
	public static FluidPollutedWater polluted_water_fluid = new FluidPollutedWater(
			"polluted_water",
			new ResourceLocation(Apocalypse.MODID, "polluted_water_still"),
			new ResourceLocation(Apocalypse.MODID, "polluted_water_flowing"));

}
