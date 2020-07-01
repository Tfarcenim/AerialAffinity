package com.tfar.aerialaffinity;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;

import java.util.stream.IntStream;

import static com.tfar.aerialaffinity.AerialAffinity.AERIAL_AFFINITY;

public class Util {
  public static boolean getAerialAffinity(EntityPlayer player) {
    IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);
    return IntStream.range(0, handler.getSlots()).anyMatch(i -> EnchantmentHelper.getEnchantmentLevel(AERIAL_AFFINITY, handler.getStackInSlot(i)) > 0);
  }
}
