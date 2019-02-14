package com.tfar.aerialaffinity.init;

import com.tfar.aerialaffinity.ench.Enchantment.EnchantmentAerialAffinity;
import com.tfar.aerialaffinity.util.ReferenceVariables;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= ReferenceVariables.MOD_ID)
public class ModEnchantment {

    public static final Enchantment AERIAL_AFFINITY = new EnchantmentAerialAffinity();

    @SubscribeEvent
    public static void registerEnchantments(Register<Enchantment> event) {
        event.getRegistry().registerAll(AERIAL_AFFINITY);
    }

}
