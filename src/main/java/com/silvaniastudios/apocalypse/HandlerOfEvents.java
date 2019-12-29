package com.silvaniastudios.apocalypse;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlerOfEvents {

	@SubscribeEvent
	public void render(RenderGameOverlayEvent.Post event) {
		Minecraft minecraft = Minecraft.getMinecraft();
		FontRenderer fontRenderer = minecraft.fontRenderer;
		fontRenderer.drawStringWithShadow("This is testing text", 10, 20, 0x000000);
	}
}
