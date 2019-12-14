package com.silvaniastudios.apocalypse;

import net.minecraftforge.common.config.Config;

@Config(modid = Apocalypse.MODID, name = "Apocalypse")
@Config.LangKey("apocalypse.config.title_apocalypse")
public class ApocConfig {

	@Config.Name("General Settings")
	public static General general = new General();
	
	@Config.Name("World Settings")
	public static World world = new World();

	public static class General {
		@Config.Comment("If the block under paint is broken, should the paint vanish? \n"
				+ "(NOTE: 'False' might cause immersion-breaking things, but prevent frustration!)")
		public boolean breakPaintOnBlockBreak = true;
	}
	
	public static class World { 
		@Config.Comment("Whether or not the custom world type should be enabled. Disable if you don't want the custom world.")
		public boolean enableWorldType = true;
	}
}
