package net.istar.sandsword;

import net.fabricmc.api.ModInitializer;
import net.istar.sandsword.entity.ModEntities;
import net.istar.sandsword.item.ModItems;
import net.istar.sandsword.loottablemodify.ModLootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SandSword implements ModInitializer {
	public static final String MOD_ID = "sandsword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		ModLootTableModifier.modifyLootTables();
	}
}