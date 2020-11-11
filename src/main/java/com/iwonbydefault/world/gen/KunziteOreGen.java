package com.iwonbydefault.world.gen;

import com.iwonbydefault.kunziteaccessories.KunziteAccessories;
import com.iwonbydefault.kunziteaccessories.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class KunziteOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres(){
        //field_241882_a is for generating in stone, granite, diorite, and andesite
        //field_241883_b is for generating in netherrack
        //field_241884_c is for generating in netherrack, basalt and blackstone

        //Overworld Ore Register
        overworldOres.add(register("example_overworld_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.field_241882_a, RegistryHandler.KUNZITE_ORE.get().getDefaultState(), 6)) //Vein Size
                .func_242733_d(20).func_242728_a() //Spawn height start
                .func_242731_b(1))); //Chunk spawn frequency

        //Nether Ore Register
        netherOres.add(register("example_nether_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.field_241883_b, RegistryHandler.KUNZITE_ORE.get().getDefaultState(), 0)) //Vein Size
                .func_242733_d(0).func_242728_a() //Spawn height start
                .func_242731_b(0))); //Chunk spawn frequency

        //The End Ore Register
        endOres.add(register("example_end_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                new BlockMatchRuleTest(Blocks.END_STONE), RegistryHandler.KUNZITE_ORE.get().getDefaultState(), 0)) //Vein Size
                .func_242733_d(0).func_242728_a() //Spawn height start
                .func_242731_b(0))); //Chunk spawn frequency
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void gen(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)){
            for(ConfiguredFeature<?, ?> ore : netherOres){
                if (ore != null) generation.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        if(event.getCategory().equals(Biome.Category.THEEND)){
            for(ConfiguredFeature<?, ?> ore : endOres){
                if (ore != null) generation.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
        for(ConfiguredFeature<?, ?> ore : overworldOres){
            if (ore != null) generation.func_242513_a(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.field_243653_e, KunziteAccessories.MOD_ID + ":" + name, configuredFeature);
    }

}