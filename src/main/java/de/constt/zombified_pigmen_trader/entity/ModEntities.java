package de.constt.zombified_pigmen_trader.entity;

import de.constt.zombified_pigmen_trader.Zombified_pigmen_trader;
import de.constt.zombified_pigmen_trader.entity.custom.PigmanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PigmanEntity> PIGMEN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Zombified_pigmen_trader.MOD_ID,"pigmen"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PigmanEntity::new).dimensions(EntityDimensions.fixed(1f,1f)).build());
}
