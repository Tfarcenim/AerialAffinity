package com.tfar.aerialaffinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.tfar.aerialaffinity.AerialAffinity.*;

@Mod(modid = MOD_ID, name = NAME, version = VERSION)
@Mod.EventBusSubscriber(modid = MOD_ID)
public class AerialAffinity
{
    public static final String MOD_ID = "aerialaffinity";
    public static final String NAME = "Aerial Affinity";
    public static final String VERSION = "@VERSION@";
    public static final Enchantment AERIAL_AFFINITY = new EnchantmentAerialAffinity();

    @SubscribeEvent
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(AERIAL_AFFINITY);
    }



}
