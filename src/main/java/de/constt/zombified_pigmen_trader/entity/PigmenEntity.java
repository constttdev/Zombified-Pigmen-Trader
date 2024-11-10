package de.constt.zombified_pigmen_trader.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class PigmenEntity extends PathAwareEntity {
    public PigmenEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this,1.0));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class,6.0f));
        this.goalSelector.add(3, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createPigmanAttribues() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_ARMOR,1f)
                .add(EntityAttributes.GENERIC_MAX_HEALTH,10);
    }
}
