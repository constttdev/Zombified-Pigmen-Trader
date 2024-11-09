package de.constt.zombified_pigmen_trader.entity.client;
import de.constt.zombified_pigmen_trader.entity.custom.PigmanEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;


public class PigmanModel<T extends PigmanEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart bb_main;
	public PigmanModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.body = root.getChild("body");
		this.bb_main = root.getChild("bb_main");
		this.head = bb_main.getChild("body").getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(41, 11).cuboid(-2.0F, -1.5F, -0.5F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -2.5F, 0.5F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 26.5F, -4.5F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F))
		.uv(16, 16).cuboid(-4.0F, 12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(16, 15).cuboid(-4.0F, 12.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(16, 48).mirrored().cuboid(-4.0F, 5.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.25F)).mirrored(false)
		.uv(40, 16).mirrored().cuboid(4.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(40, 16).cuboid(-8.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 16).mirrored().cuboid(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
		.uv(0, 16).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(16, 48).cuboid(0.0F, 5.0F, -2.0F, 4.0F, 7.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(PigmanEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return bb_main;
	}
}