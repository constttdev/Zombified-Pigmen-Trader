package de.constt.zombified_pigmen_trader.client;

import de.constt.zombified_pigmen_trader.entity.PigmenEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PigmanEntityModel extends EntityModel<PigmenEntity> {
	private final ModelPart bone;
	private final ModelPart body;
	private final ModelPart bb_main;
	public PigmanEntityModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.body = root.getChild("body");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(-41, -11).cuboid(2.0F, 1.5F, 0.5F, -4.0F, -3.0F, -1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(0F, 0F, 0F, -8.0F, -8.0F, -8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -26.5F, 4.5F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(-16, -32).cuboid(4.0F, -12.0F, 2.0F, -8.0F, -12.0F, -4.0F, new Dilation(-0.25F))
		.uv(16, 16).cuboid(0F, 0F, 0F, -8.0F, -12.0F, -4.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(-16, -15).cuboid(4.0F, -12.0F, 2.0F, -8.0F, -12.0F, -4.0F, new Dilation(0.0F))
		.uv(16, 48).mirrored().cuboid(0F, 0F, 0F, -4.0F, -7.0F, -4.0F, new Dilation(-0.25F)).mirrored(false)
		.uv(40, 16).mirrored().cuboid(0F, 0F, 0F, -4.0F, -12.0F, -4.0F, new Dilation(-0.0F)).mirrored(false)
		.uv(40, 16).cuboid(0F, 0F, 0F, -4.0F, -12.0F, -4.0F, new Dilation(0.0F))
		.uv(0, 16).mirrored().cuboid(0.0F, 0.0F, 0F, -4.0F,-12.0F, -4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 16).cuboid(0F, 0.0F, 0F, -4.0F, -12.0F, -4.0F, new Dilation(0.0F))
		.uv(16, 48).cuboid(0.0F, 0F, 0F, -4.0F, -7.0F, -4.0F, new Dilation(-0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(PigmenEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}