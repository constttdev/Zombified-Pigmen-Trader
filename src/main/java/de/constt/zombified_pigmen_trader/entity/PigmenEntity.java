package de.constt.zombified_pigmen_trader.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.MerchantScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PigmenEntity extends MerchantEntity {
    private TradeOfferList offers;

    public PigmenEntity(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {

    }

    @Override
    protected void fillRecipes() {

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
                .add(EntityAttributes.GENERIC_MAX_HEALTH,5);
    }

    protected void initOffers() {
        TradeOfferList tradeOffers = new TradeOfferList();
        tradeOffers.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(Items.IRON_INGOT, 16),
                5,
                1,
                0.05F
        ));
        tradeOffers.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(Items.DIAMOND, 1),
                3,
                2,
                0.05F
        ));
        this.offers = tradeOffers;
    }


    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        super.setCustomer(player);
        initOffers();
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                (syncId, playerInventory, playerEntity) ->
                        new MerchantScreenHandler(syncId, playerInventory,this),
                Text.literal("Pigman")
                ));
        return super.interactMob(player, hand);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
