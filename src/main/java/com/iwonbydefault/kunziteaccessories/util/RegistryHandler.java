package com.iwonbydefault.kunziteaccessories.util;

import com.iwonbydefault.kunziteaccessories.KunziteAccessories;
import com.iwonbydefault.kunziteaccessories.armor.KunziteArmorMaterial;
import com.iwonbydefault.kunziteaccessories.blocks.BlockItemBase;
import com.iwonbydefault.kunziteaccessories.blocks.KunziteBlock;
import com.iwonbydefault.kunziteaccessories.blocks.KunziteOre;
import com.iwonbydefault.kunziteaccessories.items.ItemBase;
import com.iwonbydefault.kunziteaccessories.items.KunziteBeetroot;
import com.iwonbydefault.kunziteaccessories.tools.KunziteTier;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, KunziteAccessories.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, KunziteAccessories.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> KUNZITE = ITEMS.register("kunzite", ItemBase::new);
    public static final RegistryObject<Item> KUNZITE_NUGGET = ITEMS.register("kunzite_nugget", ItemBase::new);
    public static final RegistryObject<KunziteBeetroot> KUNZITE_BEETROOT = ITEMS.register("kunzite_beetroot", KunziteBeetroot::new);
    public static final RegistryObject<Item> INFUSED_KUNZITE = ITEMS.register("infused_kunzite", ItemBase::new);
    public static final RegistryObject<Item> INFUSION_OF_STRENGTH = ITEMS.register("infusion_of_strength", ItemBase::new);
    public static final RegistryObject<Item> INFUSION_OF_ENDURANCE = ITEMS.register("infusion_of_endurance", ItemBase::new);
    public static final RegistryObject<Item> INFUSION_OF_INQUISITIVENESS = ITEMS.register("infusion_of_inquisitiveness", ItemBase::new);

    public static final RegistryObject<Item> KUNZITE_NECKLACE = ITEMS.register("kunzite_necklace", ItemBase::new);

    public static final RegistryObject<Item> NECKLACE_OF_MIGHT = ITEMS.register("necklace_of_might", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_POWER = ITEMS.register("necklace_of_power", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_STRENGTH = ITEMS.register("necklace_of_strength", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_BRUTALITY = ITEMS.register("necklace_of_brutality", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_RUTHLESSNESS = ITEMS.register("necklace_of_ruthlessness", ItemBase::new);

    public static final RegistryObject<Item> NECKLACE_OF_TOUGHNESS = ITEMS.register("necklace_of_toughness", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_VIGOR = ITEMS.register("necklace_of_vigor", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_ENDURANCE = ITEMS.register("necklace_of_endurance", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_COURAGE = ITEMS.register("necklace_of_courage", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_PERSEVERANCE = ITEMS.register("necklace_of_perseverance", ItemBase::new);

    public static final RegistryObject<Item> NECKLACE_OF_CURIOSITY = ITEMS.register("necklace_of_curiosity", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_PERCEPTION = ITEMS.register("necklace_of_perception", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_INQUISITIVENESS = ITEMS.register("necklace_of_inquisitiveness", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_KNOWLEDGE = ITEMS.register("necklace_of_knowledge", ItemBase::new);
    public static final RegistryObject<Item> NECKLACE_OF_WISDOM = ITEMS.register("necklace_of_wisdom", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> KUNZITE_ORE = BLOCKS.register("kunzite_ore", KunziteBlock::new);
    public static final RegistryObject<Block> KUNZITE_BLOCK = BLOCKS.register("kunzite_block", KunziteOre::new);

    // Block Items
    public static final RegistryObject<Item> KUNZITE_BLOCK_ITEM = ITEMS.register("kunzite_block", () -> new BlockItemBase(KUNZITE_BLOCK.get()));
    public static final RegistryObject<Item> KUNZITE_ORE_ITEM = ITEMS.register("kunzite_ore", () -> new BlockItemBase(KUNZITE_ORE.get()));

    // Tools
    public static final RegistryObject<SwordItem> KUNZITE_SWORD = ITEMS.register("kunzite_sword", () ->
        new SwordItem(KunziteTier.KUNZITE, 8, -2.4F, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<PickaxeItem> KUNZITE_PICKAXE = ITEMS.register("kunzite_pickaxe", () ->
            new PickaxeItem(KunziteTier.KUNZITE, 7, -2.8F, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<ShovelItem> KUNZITE_SHOVEL = ITEMS.register("kunzite_shovel", () ->
            new ShovelItem(KunziteTier.KUNZITE, 6, -3.0F, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<AxeItem> KUNZITE_AXE = ITEMS.register("kunzite_axe", () ->
            new AxeItem(KunziteTier.KUNZITE, 10, -3.0F, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<HoeItem> KUNZITE_HOE = ITEMS.register("kunzite_hoe", () ->
            new HoeItem(KunziteTier.KUNZITE, 0, 0F, new Item.Properties().group(KunziteAccessories.TAB)));

    // Armor
    public static final RegistryObject<ArmorItem> KUNZITE_HELMET = ITEMS.register("kunzite_helmet", () ->
            new ArmorItem(KunziteArmorMaterial.KUNZITE, EquipmentSlotType.HEAD, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<ArmorItem> KUNZITE_CHESTPLATE = ITEMS.register("kunzite_chestplate", () ->
            new ArmorItem(KunziteArmorMaterial.KUNZITE, EquipmentSlotType.CHEST, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<ArmorItem> KUNZITE_LEGGINGS = ITEMS.register("kunzite_leggings", () ->
            new ArmorItem(KunziteArmorMaterial.KUNZITE, EquipmentSlotType.LEGS, new Item.Properties().group(KunziteAccessories.TAB)));
    public static final RegistryObject<ArmorItem> KUNZITE_BOOTS = ITEMS.register("kunzite_boots", () ->
            new ArmorItem(KunziteArmorMaterial.KUNZITE, EquipmentSlotType.FEET, new Item.Properties().group(KunziteAccessories.TAB)));
}
