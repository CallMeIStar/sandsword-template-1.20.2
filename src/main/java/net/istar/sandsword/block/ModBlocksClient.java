package net.istar.sandsword.block;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class ModBlocksClient implements ClientModInitializer {
    @Override
    public static void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
            if (view != null && pos != null) {
                return BiomeColors.getGrassColor(view, pos);
            }
            return -1;
        }, ModBlocks.BLACKSTONEGRASS);

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return 0x522580;
        }, ModBlocks.BLACKSTONEGRASS.asItem());

        BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlocks.BLACKSTONEGRASS, RenderLayer.getCutoutMipped());
    }
}
