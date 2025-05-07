// src/main/java/com/mlgmilk/yawye/mixin/ItemFinishUsingMixin.java
package com.mlgmilk.yawye.mixin;

import com.mlgmilk.yawye.yawye; // to access IsRawFood and LOGGER
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class) // Target the Item class
public abstract class ItemFinishUsingMixin {

    // Inject at the END of the finishUsing method.
    @Inject(method = "finishUsing(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;)Lnet/minecraft/item/ItemStack;",
            at = @At("RETURN"))
    private void yawye_onFinishUsingFood(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        // Only run on server and if the user is a player
        if (!world.isClient() && user instanceof PlayerEntity player) {
            // Get the actual item that was used
            Item item = stack.getItem();

            if (stack.contains(DataComponentTypes.FOOD)) { // Check if it's food
                yawye.LOGGER.info("Player {} finished eating {} via Mixin", player.getName().getString(), item.getName().getString());

                if (yawye.IsRawFood(item)) {
                    int rnd = world.getRandom().nextInt(100);
                    if (rnd > 60) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0));
                        yawye.LOGGER.info("Applied NAUSEA to {} for eating raw food", player.getName().getString());
                    }
                    if (rnd > 75) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 150, 0));
                        yawye.LOGGER.info("Applied POISON to {} for eating raw food", player.getName().getString());
                    }

                } else if (item == Items.APPLE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 0));
                    yawye.LOGGER.info("Applied REGENERATION to {} for eating an APPLE", player.getName().getString());
                } else if (item == Items.BAKED_POTATO) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 1)); // Adjusted: 30s Haste II
                    yawye.LOGGER.info("Applied HASTE II to {} for eating a BAKED_POTATO", player.getName().getString());
                } else if (item == Items.BEETROOT) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200, 0));
                    yawye.LOGGER.info("Applied HASTE I to {} for eating a BEETROOT", player.getName().getString());
                } else if (item == Items.BEETROOT_SOUP || item == Items.RABBIT_STEW || item == Items.MUSHROOM_STEW) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1));
                    yawye.LOGGER.info("Applied SATURATION to {} for eating a STEW", player.getName().getString());
                } else if (item == Items.GOLDEN_CARROT || item == Items.GOLDEN_APPLE || item == Items.ENCHANTED_GOLDEN_APPLE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1200, 0));
                    yawye.LOGGER.info("Applied LUCK to {} for eating a GOLDEN item", player.getName().getString());
                } else if (item == Items.CARROT) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 0)); // Just a slight buff to carrots
                    yawye.LOGGER.info("Applied minor SATURATION to {} for eating a CARROT", player.getName().getString());
                } else if (item == Items.MELON_SLICE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 300, 0)); // Adjusted: 15s Water Breathing
                    yawye.LOGGER.info("Applied WATER_BREATHING to {} for eating a MELON_SLICE", player.getName().getString());
                } else if (item == Items.COOKIE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 400, 0)); // Adjusted: 20s Speed I
                    yawye.LOGGER.info("Applied SPEED to {} for eating a COOKIE", player.getName().getString());
                } else if (item == Items.COOKED_BEEF) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0)); // Skin like leather, adjusted: 30s
                    yawye.LOGGER.info("Applied RESISTANCE to {} for eating COOKED_BEEF", player.getName().getString());
                } else if (item == Items.COOKED_CHICKEN) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)); // Adjusted: 30s
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 600, 0)); // Adjusted: 30s
                    yawye.LOGGER.info("Applied JUMP_BOOST & SLOW_FALLING to {} for eating COOKED_CHICKEN", player.getName().getString());
                } else if (item == Items.COOKED_COD || item == Items.COOKED_SALMON) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 0)); // Adjusted: 60s
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200, 0)); // Adjusted: 60s
                    yawye.LOGGER.info("Applied DOLPHINS_GRACE & WATER_BREATHING to {} for eating COOKED_FISH", player.getName().getString());
                } else if (item == Items.COOKED_MUTTON) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0)); // Adjusted: 30s
                    yawye.LOGGER.info("Applied RESISTANCE to {} for eating COOKED_MUTTON", player.getName().getString());
                } else if (item == Items.COOKED_PORKCHOP) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 400, 0)); // Adjusted: 20s
                    yawye.LOGGER.info("Applied ABSORPTION to {} for eating COOKED_PORKCHOP", player.getName().getString());
                } else if (item == Items.COOKED_RABBIT) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200, 0)); // Adjusted: 30s
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200, 0)); // Adjusted: 30s
                    yawye.LOGGER.info("Applied SPEED & JUMP_BOOST to {} for eating COOKED_RABBIT", player.getName().getString());
                } else if (item == Items.BREAD) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1, 1));
                    yawye.LOGGER.info("Applied SATURATION to {} for eating BREAD", player.getName().getString());
                } else if (item == Items.ROTTEN_FLESH) {
                    // Using the "guaranteed negative + guaranteed positive" approach for better tradeoff feel
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0)); // 10s Strength I
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0));   // 5s Poison I
                    yawye.LOGGER.info("Applied STRENGTH & POISON to {} for eating ROTTEN_FLESH", player.getName().getString());
                    // Vanilla 80% chance of Hunger effect will still also apply
                } else if (item == Items.HONEY_BOTTLE) { // Removed PUMPKIN_PIE from this line to give it its own effect
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 0)); // 30s Speed I
                    // Vanilla honey also clears poison, which is good.
                    yawye.LOGGER.info("Applied SPEED to {} for consuming HONEY_BOTTLE", player.getName().getString());
                } else if (item == Items.PUMPKIN_PIE) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 0)); // 30s Jump Boost
                    yawye.LOGGER.info("Applied JUMP_BOOST to {} for eating PUMPKIN_PIE", player.getName().getString());
                }
            }
        }

    }
}