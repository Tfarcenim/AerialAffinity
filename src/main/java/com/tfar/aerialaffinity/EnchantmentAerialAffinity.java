package com.tfar.aerialaffinity;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

import static com.tfar.aerialaffinity.AerialAffinity.AERIAL_AFFINITY;
import static com.tfar.aerialaffinity.AerialAffinity.MOD_ID;

@Mod.EventBusSubscriber(modid= MOD_ID)
public class EnchantmentAerialAffinity extends Enchantment {
    public EnchantmentAerialAffinity() {

        super(Rarity.RARE, EnchantmentType.ARMOR_CHEST, new EquipmentSlotType[]{
                EquipmentSlotType.CHEST
        });
        this.setRegistryName("aerialaffinity");
    }

    @Override
    public int getMinEnchantability(int level) {
        return 15;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean canApply(@Nonnull ItemStack stack) {
        return stack.getItem() == Items.BOOK ||
                stack.getItem() == Items.ELYTRA ||
                (stack.getItem() instanceof ArmorItem)
                        && ((ArmorItem) stack.getItem()).getEquipmentSlot() == EquipmentSlotType.CHEST;
    }
    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed e) {
        PlayerEntity p = e.getEntityPlayer();

        if (!p.onGround && EnchantmentHelper.getMaxEnchantmentLevel(AERIAL_AFFINITY, p) > 0) {
            float oldSpeed = e.getOriginalSpeed();
            //float newSpeed = e.getNewSpeed();
            //if (oldSpeed < newSpeed*5F)
            e.setNewSpeed(oldSpeed * 5F);
        }
    }
}

