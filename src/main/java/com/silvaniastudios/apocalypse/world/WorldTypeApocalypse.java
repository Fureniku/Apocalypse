package com.silvaniastudios.apocalypse.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;

public class WorldTypeApocalypse extends WorldType {

	public WorldTypeApocalypse() {
		super("apocalypse");
	}
	
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
		return new GenLayerCustom(worldSeed, parentLayer, this, chunkSettings);
	}

}
