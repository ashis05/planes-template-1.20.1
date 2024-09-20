package net.ashis.planes.datagen;

import net.ashis.planes.Planes;
import net.ashis.planes.block.ModBlocks;
import net.ashis.planes.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS).forceAddTag(BlockTags.IRON_ORES);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.RUBY_BLOCK).add(ModBlocks.DEEPSLATE_RUBY_ORE).add(ModBlocks.RUBY_ORE).add(ModBlocks.SOUND_BLOCK).add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.SOUND_BLOCK);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.RUBY_BLOCK).add(ModBlocks.DEEPSLATE_RUBY_ORE).add(ModBlocks.RUBY_ORE).add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_ORE);
    }
}