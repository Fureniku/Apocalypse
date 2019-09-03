package com.silvaniastudios.apocalypse.blocks;

import com.silvaniastudios.apocalypse.Apocalypse;
import com.silvaniastudios.apocalypse.blocks.shield.ShieldRelayBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ApocBlocks {
	
	//World blocks
	public static DeadGrass dead_grass = new DeadGrass("dead_grass");
	public static DriedDirt dried_dirt = new DriedDirt("dried_dirt");
	public static DeadLog dead_oak = new DeadLog("dead_oak");
	public static DeadLog dead_birch = new DeadLog("dead_birch");
	public static DeadLog dead_spruce = new DeadLog("dead_spruce");
	public static DeadLog dead_jungle = new DeadLog("dead_jungle");
	public static DeadLog dead_acacia = new DeadLog("dead_acacia");
	public static DeadLog dead_dark_oak = new DeadLog("dead_dark_oak");
	public static DeadCrop dead_wheat = new DeadCrop("dead_wheat");
	public static DeadCrop dead_carrot = new DeadCrop("dead_carrot");
	public static DeadCrop dead_potato = new DeadCrop("dead_potato");
	public static DeadCrop dead_beetroot = new DeadCrop("dead_beetroot");
	public static DeadCrop dead_melon_stem = new DeadCrop("dead_melon_stem");
	public static DeadCrop dead_pumpkin_stem = new DeadCrop("dead_pumpkin_stem");
	
	//public static PersonalShieldGen personal_shield_generator = new PersonalShieldGen("personal_shield_generator");
	//public static ShieldSystemCore shield_system_core = new ShieldSystemCore("shield_system_core");
	public static ShieldRelayBlock shield_relay = new ShieldRelayBlock("shield_relay");
	//public static ShieldBlock shield_block = new ShieldBlock("shield_block");
	
	
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				dead_grass,
				dried_dirt,
				
				shield_relay
			);
	}
	
	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.register(new ItemBlock(dead_grass).setRegistryName(dead_grass.getRegistryName()));
		registry.register(new ItemBlock(dried_dirt).setRegistryName(dried_dirt.getRegistryName()));
		
		registry.register(new ItemBlock(shield_relay).setRegistryName(shield_relay.getRegistryName()));
	}
	
	public static void registerModels() {
		dead_grass.initModel();
		dried_dirt.initModel();
		
		shield_relay.initModel();
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModel(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Apocalypse.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
