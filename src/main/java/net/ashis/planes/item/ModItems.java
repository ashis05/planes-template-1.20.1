package net.ashis.planes.item;

import net.ashis.planes.Planes;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //RUBY'S
    public static final Item RUBY =registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY =registerItem("raw_ruby", new Item(new FabricItemSettings()));
    //SAPPHIRE'S
    public static final Item SAPPHIRE =registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item RAW_SAPPHIRE =registerItem("raw_sapphire", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Planes.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Planes.LOGGER.info("Registering Mod Items for "+ Planes.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
