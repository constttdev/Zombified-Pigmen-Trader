package de.constt.zombified_pigmen_trader.client;

import de.constt.zombified_pigmen_trader.entity.ModEntities;
import de.constt.zombified_pigmen_trader.entity.client.ModModelLayers;
import de.constt.zombified_pigmen_trader.entity.client.PigmanModel;
import de.constt.zombified_pigmen_trader.entity.client.PigmanRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class Zombified_pigmen_traderClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PIGMEN, PigmanRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PIGMEN, PigmanModel::getTexturedModelData);
    }
}
