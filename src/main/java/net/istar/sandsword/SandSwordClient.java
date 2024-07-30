package net.istar.sandsword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.istar.sandsword.block.ModBlocks;
import net.istar.sandsword.entity.ModEntities;
import net.istar.sandsword.entity.custom.DuneEdgeEntityModel;
import net.istar.sandsword.entity.custom.DuneEdgeEntityRenderer;
import net.istar.sandsword.entity.custom.ModModelLayers;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.DUNEEDGE, DuneEdgeEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DUNEEDGE, DuneEdgeEntityModel::getTexturedModelData);
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
