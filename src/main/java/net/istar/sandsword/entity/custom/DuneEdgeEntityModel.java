package net.istar.sandsword.entity.custom;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class DuneEdgeEntityModel extends EntityModel<Entity> {
	private final ModelPart bb_main;
	public DuneEdgeEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(14, 10).cuboid(-0.25F, -9.0F, -2.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
		.uv(6, 20).cuboid(-0.25F, -8.0F, -1.0F, 1.0F, 6.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0.25F, -27.0F, -2.0F, 0.0F, 18.0F, 4.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(-0.25F, -27.0F, -1.0F, 1.0F, 18.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(23, 18).cuboid(8.25F, 0.0F, -11.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(14, 10).cuboid(8.25F, 1.0F, -9.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 8).cuboid(8.25F, 2.0F, -11.3F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 7).cuboid(8.05F, 0.0F, -11.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 23).cuboid(8.05F, 1.0F, -9.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 11).cuboid(8.05F, 2.0F, -11.3F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-8.4F, 4.7781F, 7.9903F, -0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(21, 0).cuboid(0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(20, 21).cuboid(0.3F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.65F, -1.4445F, 1.0607F, -0.7854F, 0.0F, 0.0F));

		ModelPartData a_r1 = bb_main.addChild("a_r1", ModelPartBuilder.create().uv(20, 24).cuboid(-1.25F, 3.0772F, 3.0772F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 15).cuboid(-1.25F, 3.0772F, 3.0772F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 0).cuboid(-0.75F, 2.5772F, 2.5772F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.25F, -10.4228F, -10.4228F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(14, 2).cuboid(0.25F, -11.4228F, -11.4228F, 0.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(10, 18).cuboid(0.25F, 2.2817F, 5.182F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0026F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r3 = bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(14, 11).cuboid(0.25F, 2.2817F, -7.182F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0026F, 0.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r4 = bb_main.addChild("cube_r4", ModelPartBuilder.create().uv(22, 4).cuboid(-0.25F, -4.8564F, -5.7622F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0026F, 0.0F, -0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r5 = bb_main.addChild("cube_r5", ModelPartBuilder.create().uv(0, 22).cuboid(-0.25F, -4.8564F, 3.7622F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0026F, 0.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r6 = bb_main.addChild("cube_r6", ModelPartBuilder.create().uv(23, 14).cuboid(-0.25F, -1.7706F, -0.1561F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.0026F, -4.0F, 0.3927F, 0.0F, 0.0F));

		ModelPartData cube_r7 = bb_main.addChild("cube_r7", ModelPartBuilder.create().uv(16, 23).cuboid(-0.25F, -1.7706F, -0.8439F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.0026F, 4.0F, -0.3927F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}