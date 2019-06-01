package com.tfar.aerialaffinity;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;

import static com.tfar.aerialaffinity.AerialAffinity.AERIAL_AFFINITY;

public class Util {
  public static boolean getAerialAffinity(EntityPlayer player) {
    IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);
    for (int i = 0; i < handler.getSlots(); i++) {
      if (EnchantmentHelper.getEnchantmentLevel(AERIAL_AFFINITY,handler.getStackInSlot(i))>0)
        return true;
    }
    return false;
  }
}
