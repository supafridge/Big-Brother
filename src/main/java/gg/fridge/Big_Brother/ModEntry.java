package gg.fridge.Big_Brother;

import net.fabricmc.api.ClientModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModEntry implements ClientModInitializer {
	public static final String MOD_ID = "big_brother";
	public static final Logger LOGGER = LoggerFactory.getLogger("Big Brother");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Hello, world!");
	}
}
