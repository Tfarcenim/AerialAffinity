package com.tfar.aerialaffinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ReferenceVariables.MOD_ID, name = ReferenceVariables.NAME, version = ReferenceVariables.VERSION)
@Mod.EventBusSubscriber(modid= ReferenceVariables.MOD_ID)
public class Main
{
    public static final Enchantment AERIAL_AFFINITY = new EnchantmentAerialAffinity();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(AERIAL_AFFINITY);
    }



}
