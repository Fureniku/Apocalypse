package com.silvaniastudios.apocalypse.world;

import com.silvaniastudios.apocalypse.world.biomes.BiomeDeadForest;
import com.silvaniastudios.apocalypse.world.biomes.BiomeDeadPlains;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ApocalypseBiomes {
	
	public static final int WATER_COLOUR = 12077;
	public static final int SKY_COLOUR = 13219697;
	
	public static final Biome DEAD_PLAINS = new BiomeDeadPlains("Dead Plains", Biomes.PLAINS.getBiomeName());
	public static final Biome DEAD_BIRCH_FOREST = new BiomeDeadForest(BiomeForest.Type.BIRCH, "Dead Birch Forest", Biomes.BIRCH_FOREST.getBiomeName());
	
	public static void registerBiomes() {
		initBiome(DEAD_PLAINS, "Dead Plains", BiomeType.WARM, Type.PLAINS);
		initBiome(DEAD_BIRCH_FOREST, "Dead Birch Forest", BiomeType.WARM, Type.FOREST);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}

}
