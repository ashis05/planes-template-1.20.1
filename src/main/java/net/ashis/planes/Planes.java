package net.ashis.planes;

import net.ashis.planes.block.ModBlocks;
import net.ashis.planes.item.ModItemGroups;
import net.ashis.planes.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Planes implements ModInitializer {
	public static final String MOD_ID = "planes";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}