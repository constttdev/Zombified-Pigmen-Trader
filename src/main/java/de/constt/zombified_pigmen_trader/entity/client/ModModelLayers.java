package de.constt.zombified_pigmen_trader.entity.client;

import de.constt.zombified_pigmen_trader.Zombified_pigmen_trader;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PIGMEN =
            new EntityModelLayer(new Identifier(Zombified_pigmen_trader.MOD_ID,"pigmen"),"main");
}
