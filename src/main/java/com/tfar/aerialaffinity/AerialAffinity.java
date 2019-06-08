package com.tfar.aerialaffinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.tfar.aerialaffinity.AerialAffinity.MOD_ID;

@Mod.EventBusSubscriber(modid= MOD_ID)
@Mod(value = MOD_ID)
public class AerialAffinity {
    public static final String MOD_ID = "aerialaffinity";
    public static final Enchantment AERIAL_AFFINITY = new EnchantmentAerialAffinity();

    public AerialAffinity(){
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class,this::registerEnchantments);
    }

    @SubscribeEvent
    public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(AERIAL_AFFINITY);
    }
}
