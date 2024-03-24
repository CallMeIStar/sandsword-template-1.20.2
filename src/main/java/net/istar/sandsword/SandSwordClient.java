package net.istar.sandsword;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.istar.sandsword.entity.ModEntities;
import net.istar.sandsword.entity.custom.DuneEdgeEntityModel;
import net.istar.sandsword.entity.custom.DuneEdgeEntityRenderer;
import net.istar.sandsword.entity.custom.ModModelLayers;

public class SandSwordClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient(){
        EntityRendererRegistry.register(ModEntities.DUNEEDGE, DuneEdgeEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DUNEEDGE, DuneEdgeEntityModel::getTexturedModelData);
    }
}
