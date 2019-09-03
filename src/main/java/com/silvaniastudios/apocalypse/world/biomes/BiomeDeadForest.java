package com.silvaniastudios.apocalypse.world.biomes;

import com.silvaniastudios.apocalypse.blocks.ApocBlocks;
import com.silvaniastudios.apocalypse.world.ApocalypseBiomes;

import net.minecraft.world.biome.BiomeForest;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeDeadForest extends BiomeForest {

	public BiomeDeadForest(Type typeIn, String name, String biomeBase) {
		super(typeIn, new BiomeProperties(name).setBaseBiome(biomeBase).setRainDisabled().setWaterColor(ApocalypseBiomes.WATER_COLOUR));
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
