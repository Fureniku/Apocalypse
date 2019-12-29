package com.silvaniastudios.apocalypse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.silvaniastudios.apocalypse.items.ApocItems;
import com.silvaniastudios.apocalypse.world.ApocalypseBiomes;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
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
	
	public static CreativeTabs tabApocBlocks = new CreativeTabs("tabApocBlocks") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ApocBlocks.dead_oak, 1, 0);
		}
	};
	
	public static CreativeTabs tabApocMachines = new CreativeTabs("tabApocMachines") {
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ApocBlocks.shield_relay, 1, 0);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		FluidRegistry.registerFluid(ApocFluids.polluted_water_fluid);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		if (ApocConfig.world.enableWorldType) {
			ApocalypseBiomes.registerBiomes();
		}
		MinecraftForge.EVENT_BUS.register(new HandlerOfEvents());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (ApocConfig.world.enableWorldType) {
			//WorldType APOCALYPSE = new WorldTypeApocalypse();
		}
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
