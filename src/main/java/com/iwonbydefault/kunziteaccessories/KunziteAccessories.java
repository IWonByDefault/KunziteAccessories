package com.iwonbydefault.kunziteaccessories;

import com.iwonbydefault.kunziteaccessories.util.RegistryHandler;
import com.iwonbydefault.world.gen.KunziteOreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.ArrayList;
import java.util.List;

@Mod("kunziteaccessories")

public class KunziteAccessories {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "kunziteaccessories";

    public KunziteAccessories() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        KunziteOreGen.registerOres();
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("kunzitetab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.KUNZITE_BEETROOT.get());
        }
    };

    private void enqueueIMC(final InterModEnqueueEvent event) {
        SlotTypePreset[] slots = {
                SlotTypePreset.NECKLACE, SlotTypePreset.RING
        };
        List<SlotTypeMessage.Builder> builders = new ArrayList<>();
        for (SlotTypePreset slot : slots) {
            SlotTypeMessage.Builder builder = slot.getMessageBuilder();
            if (slot == SlotTypePreset.RING) {
                builder.size(2);
            }
            builders.add(builder);
        }
        for (SlotTypeMessage.Builder builder : builders) {
            SlotTypeMessage message = builder.build();
            InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
                    ()->message);
        }
    }
}
