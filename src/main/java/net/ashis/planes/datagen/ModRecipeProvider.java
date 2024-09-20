package net.ashis.planes.datagen;

import net.ashis.planes.block.ModBlocks;
import net.ashis.planes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.ItemCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RAW_RUBY_SMELTABLES=List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
    private static final List<ItemConvertible> RAW_SAPPHIRE_SMELTABLES=List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
    private static final List<ItemConvertible> RUBY_SMELTABLE=List.of(ModItems.RAW_RUBY);
    private static final List<ItemConvertible> SAPPHIRE_SMELTABLE=List.of(ModItems.RAW_SAPPHIRE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, RAW_RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_RUBY, 0.7f, 300, "ruby");
        offerSmelting(exporter, RAW_SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RAW_SAPPHIRE, 0.7f, 300, "ruby");

        offerSmelting(exporter, RUBY_SMELTABLE, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 250, "ruby");
        offerSmelting(exporter, SAPPHIRE_SMELTABLE, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.7f, 250, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR, 1).pattern(" R ").pattern("SDS").pattern(" R ").input('S', ModItems.SAPPHIRE).input('R', ModItems.RUBY).input('D', Items.DIAMOND).criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK, 1).pattern("SRS").pattern("RSR").pattern("SRS").input('S', ModItems.SAPPHIRE).input('R', ModItems.RUBY).criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE)).criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY)).offerTo(exporter, getRecipeName(ModBlocks.SOUND_BLOCK));
    }
}
