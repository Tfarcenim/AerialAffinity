package com.tfar.aerialaffinity;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

import static com.tfar.aerialaffinity.AerialAffinity.MODID;

@Mod(value = MODID)
public class AerialAffinity {

  public static final String MODID = "aerialaffinity";

  @ObjectHolder(MODID +":"+ MODID)
  public static final Enchantment aerial_affinity = null;


  public AerialAffinity() {
    FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Enchantment.class, this::registerEnchantments);
  }

  @SubscribeEvent
  public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
    event.getRegistry().register(new EnchantmentAerialAffinity().setRegistryName(MODID));
  }
}
