package net.istar.sandsword.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.istar.sandsword.SandSword;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

@Environment(value= EnvType.CLIENT)
public class DuneEdgeEntityRenderer
        extends EntityRenderer<DuneEdgeEntity> {
    public static final Identifier TEXTURE = new Identifier(SandSword.MOD_ID,"textures/entity/duneedge.png");
    private final DuneEdgeEntityModel model;

    public DuneEdgeEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new DuneEdgeEntityModel(context.getPart(ModModelLayers.DUNEEDGE));
    }

    @Override
    public void render(DuneEdgeEntity duneEdgeEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, duneEdgeEntity.prevYaw, duneEdgeEntity.getYaw()) - 90.0f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, duneEdgeEntity.prevPitch, duneEdgeEntity.getPitch()) + 90.0f));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(duneEdgeEntity)), false, duneEdgeEntity.isEnchanted());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
        super.render(duneEdgeEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(DuneEdgeEntity duneEdgeEntity) {
        return TEXTURE;
    }
}