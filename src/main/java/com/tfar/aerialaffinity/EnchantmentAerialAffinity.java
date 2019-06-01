package com.tfar.aerialaffinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.tfar.aerialaffinity.AerialAffinity.*;

@Mod.EventBusSubscriber(modid= MOD_ID)
public class EnchantmentAerialAffinity extends Enchantment {
    public EnchantmentAerialAffinity() {

        super(Rarity.RARE, EnumEnchantmentType.ARMOR_CHEST, new EntityEquipmentSlot[]{
                EntityEquipmentSlot.CHEST
        });
        this.setRegistryName("aerial_affinity");
        this.setName("aerial_affinity");
    }

    @Override
    public int getMinEnchantability(int level) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int level) {
        return 100;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() == Items.BOOK ||
                stack.getItem() == Items.ELYTRA ||
                (stack.getItem() instanceof ItemArmor)
                        && ((ItemArmor) stack.getItem()).armorType == EntityEquipmentSlot.CHEST;
    }
    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed e) {
        EntityPlayer p = e.getEntityPlayer();

        if (!p.onGround && EnchantmentHelper.getMaxEnchantmentLevel(AERIAL_AFFINITY, p) > 0) {
            float oldSpeed = e.getOriginalSpeed();
            float newSpeed = e.getNewSpeed();

            if (oldSpeed < newSpeed * 5F)
            e.setNewSpeed(newSpeed * 5F);
        }else if (Loader.isModLoaded("colytra")){
            if(Util.getAerialAffinity(p) && !p.onGround){
                float oldSpeed = e.getOriginalSpeed();
                float newSpeed = e.getNewSpeed();
                if (oldSpeed < newSpeed * 5F)
                    e.setNewSpeed(newSpeed * 5F);
            }
        }
    }
}

