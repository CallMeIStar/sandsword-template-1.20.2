package net.istar.sandsword.block;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.istar.sandsword.SandSword;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLACKSTONEGRASS = registerBlock("blackstonegrass",
            new BlackstoneGrass(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).sounds(BlockSoundGroup.STONE)));

    public static final Block PIATRAUSV = registerBlock("piatrausv",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(SandSword.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(SandSword.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        SandSword.LOGGER.info("Registering ModBlocks for " + SandSword.MOD_ID);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view != null && pos != null) {
                return BiomeColors.getGrassColor(view, pos);
            }
            return -1;
        }, BLACKSTONEGRASS);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return 0x522580;
        }, BLACKSTONEGRASS.asItem());

        BlockRenderLayerMapImpl.INSTANCE.putBlock(BLACKSTONEGRASS, RenderLayer.getCutoutMipped());
    }
}