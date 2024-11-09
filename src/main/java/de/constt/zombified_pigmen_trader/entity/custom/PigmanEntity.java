package de.constt.zombified_pigmen_trader.entity.custom;

import de.constt.zombified_pigmen_trader.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PigmanEntity extends AnimalEntity {
    public PigmanEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1,new AnimalMateGoal(this,1.15D));
        this.goalSelector.add(2,new FollowParentGoal(this,1.15D));
        this.goalSelector.add(3,new WanderAroundFarGoal(this,1D));
        this.goalSelector.add(4,new LookAtEntityGoal(this, PlayerEntity.class,4f));
        this.goalSelector.add(5,new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createPigmenAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,5)
                .add(EntityAttributes.GENERIC_ARMOR,2);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PIGMEN.create(world);
    }
}
