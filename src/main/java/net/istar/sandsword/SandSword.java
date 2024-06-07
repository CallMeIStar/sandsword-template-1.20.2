package net.istar.sandsword;

import net.fabricmc.api.ModInitializer;
import net.istar.sandsword.block.ModBlocks;
import net.istar.sandsword.entity.ModEntities;
import net.istar.sandsword.item.ModItems;
import net.istar.sandsword.loottablemodify.ModLootTableModifier;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
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
		ModBlocks.registerModBlocks();

		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.MUD_BRICKS)
				.lightWithItem(ModItems.ARBOREALKEY)
				.destDimID(new Identifier(SandSword.MOD_ID, "arboreal_haven_dimension"))
				.tintColor(0x8f6b50)
				.onlyLightInOverworld()
				.registerPortal();
		CustomPortalBuilder.beginPortal()
				.frameBlock(Blocks.POLISHED_BLACKSTONE_BRICKS)
				.lightWithItem(ModItems.SHADOWLANDKEY)
				.destDimID(new Identifier(SandSword.MOD_ID, "shadow_land_dimension"))
				.tintColor(0x0c0012)
				.onlyLightInOverworld()
				.registerPortal();
	}
}