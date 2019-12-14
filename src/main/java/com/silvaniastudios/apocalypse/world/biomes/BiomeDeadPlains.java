package com.silvaniastudios.apocalypse.world.biomes;

import com.silvaniastudios.apocalypse.ApocBlocks;
import com.silvaniastudios.apocalypse.world.ApocalypseBiomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeDeadPlains extends Biome {

	public BiomeDeadPlains(String name, String biomeBase) {
		super(new BiomeProperties(name).setBaseBiome(biomeBase).setRainDisabled().setWaterColor(ApocalypseBiomes.WATER_COLOUR));
		// TODO Auto-generated constructor stub
		
		topBlock = ApocBlocks.dead_grass.getDefaultState();
		fillerBlock = ApocBlocks.dried_dirt.getDefaultState();
		
		this.decorator.flowerGen = null;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float temp) {
		return ApocalypseBiomes.SKY_COLOUR;
	}
}
