package de.constt.zombified_pigmen_trader.entity.client;

import de.constt.zombified_pigmen_trader.Zombified_pigmen_trader;
import de.constt.zombified_pigmen_trader.entity.custom.PigmanEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PigmanRenderer extends MobEntityRenderer<PigmanEntity,PigmanModel<PigmanEntity>> {
    private static final Identifier TEXTURE = new Identifier(Zombified_pigmen_trader.MOD_ID,"textures/entity/pigman.png");

    public PigmanRenderer(EntityRendererFactory.Context context) {
        super(context, new PigmanModel<>(context.getPart(ModModelLayers.PIGMEN)),0.6f);
    }

    @Override
    public Identifier getTexture(PigmanEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PigmanEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f,0.5f,0.5f);
        } else {
            matrixStack.scale(1f,1f,1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
