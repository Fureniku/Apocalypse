package com.silvaniastudios.apocalypse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.silvaniastudios.apocalypse.blocks.ApocBlocks;
import com.silvaniastudios.apocalypse.items.ApocItems;
import com.silvaniastudios.apocalypse.world.ApocalypseBiomes;
import com.silvaniastudios.apocalypse.world.WorldTypeApocalypse;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Apocalypse.MODID, name = Apocalypse.NAME, version = Apocalypse.VERSION)
public class Apocalypse {
	
	public static final String MODID = "apocalypse";
	public static final String NAME = "Apocalypse";
	public static final String VERSION = "1.0";

	private static Logger logger;
	
	@SidedProxy(clientSide = "com.silvaniastudios.apocalypse.client.ClientProxy", serverSide = "com.silvaniastudios.apocalypse.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ApocalypseBiomes.registerBiomes();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		WorldType APOCALYPSE = new WorldTypeApocalypse();
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ApocItems.register(event.getRegistry());
			ApocBlocks.registerItemBlocks(event.getRegistry());
		}
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ApocItems.registerModels();
			ApocBlocks.registerModels();
		}
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ApocBlocks.register(event.getRegistry());
		}
	}
	
	public static void debug(Level lvl, String str) {
		logger.log(lvl, str);
	}
}
