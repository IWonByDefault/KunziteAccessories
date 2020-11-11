package com.iwonbydefault.kunziteaccessories.items;

import com.iwonbydefault.kunziteaccessories.KunziteAccessories;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class KunziteBeetroot extends Item {

    public KunziteBeetroot() {
        super(new Item.Properties()
                .group(KunziteAccessories.TAB)
                .food(new Food.Builder()
                        .hunger(10)
                        .saturation(1.6F)
                        .effect(new EffectInstance(Effects.STRENGTH, 225, 2), 1)
                        .effect(new EffectInstance(Effects.REGENERATION, 225, 2), 1)
                        .setAlwaysEdible()
                        .build())
        );
    }
}