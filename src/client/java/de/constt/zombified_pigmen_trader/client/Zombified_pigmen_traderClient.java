package de.constt.zombified_pigmen_trader.client;
import de.constt.zombified_pigmen_trader.Zombified_pigmen_trader;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
@Environment(EnvType.CLIENT)
public class Zombified_pigmen_traderClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("zombified_pigmen_trader", "pigman"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(Zombified_pigmen_trader.PIGMAN, (context) -> {
            return new PigmenEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, PigmanEntityModel::getTexturedModelData);
    }
}
