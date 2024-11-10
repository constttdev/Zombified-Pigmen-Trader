package de.constt.zombified_pigmen_trader;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.ThreadLocalRandom;

public class Zombified_pigmen_trader implements ModInitializer {

    public static final String MOD_ID = "zombified_pigmen_trader";

    @Override
    public void onInitialize() {
        UseEntityCallback.EVENT.register(new UseEntityCallback() {
            @Override
            public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
                if(entity instanceof ZombifiedPiglinEntity zombifiedPiglin) {
                    if(!player.isSpectator()) {
                        if(zombifiedPiglin.hasStatusEffect(StatusEffects.WEAKNESS)) {
                            if (player.getStackInHand(hand).getItem().equals(Items.GOLDEN_APPLE)) {
                                int randomNumber = ThreadLocalRandom.current().nextInt(3600, 6001);
                                player.sendMessage(Text.of(String.valueOf(randomNumber)), true);
                                if(!player.isCreative()) {
                                    player.getStackInHand(hand).decrement(0);
                                }
                                /*
                                after the mob turns into the custom mob
                                zombifiedPiglin.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200));
                                */
                                zombifiedPiglin.removeStatusEffect(StatusEffects.WEAKNESS);
                                zombifiedPiglin.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, randomNumber, Math.min(entity.getWorld().getDifficulty().getId() - 1, 0)));


                                world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, SoundCategory.MASTER, 1.0F, 1.0F, 5);
                                return ActionResult.SUCCESS;
                            }
                        }
                    }
                }
                return ActionResult.PASS;
            }
        });
    }
}
