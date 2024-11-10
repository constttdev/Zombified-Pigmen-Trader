package de.constt.zombified_pigmen_trader.client;

import de.constt.zombified_pigmen_trader.entity.PigmenEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PigmenEntityRenderer extends MobEntityRenderer<PigmenEntity, net.minecraft.client.render.entity.model.EntityModel<de.constt.zombified_pigmen_trader.entity.PigmenEntity>> {

    public PigmenEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PigmanEntityModel(context.getPart(Zombified_pigmen_traderClient.MODEL_CUBE_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(PigmenEntity entity) {
        return new Identifier("zombified_pigmen_trader", "textures/entity/piglin9.png");
    }
}
