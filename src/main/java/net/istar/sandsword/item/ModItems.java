package net.istar.sandsword.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.istar.sandsword.SandSword;
import net.istar.sandsword.item.customitem.BlazeCornettiItem;
import net.istar.sandsword.item.customitem.DuneEdgeItem;
import net.istar.sandsword.item.customitem.DuneScepterItem;
import net.istar.sandsword.item.customitem.ModFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DUNEESSENCE = registerItem("duneessence", new Item(new FabricItemSettings()));
    public static final Item GOLDENRING = registerItem("goldenring", new Item(new FabricItemSettings()));
    public static final Item GOLDENRINGS = registerItem("goldenrings", new Item(new FabricItemSettings()));
    public static final Item SANDSTEEL = registerItem("sandsteel", new Item(new FabricItemSettings()));
    public static final Item SUNSHARD = registerItem("sunshard", new Item(new FabricItemSettings()));
    public static final Item SANDSTONEROD = registerItem("sandstonerod", new Item(new FabricItemSettings()));
    private static void addItemsToIngredient(FabricItemGroupEntries entries){

        entries.add(DUNEESSENCE);
        entries.add(GOLDENRING);
        entries.add(GOLDENRINGS);
        entries.add(SANDSTEEL);
        entries.add(SUNSHARD);
        entries.add(SANDSTONEROD);

    }
    public static final Item DUNEEDGE = registerItem("duneedge", new DuneEdgeItem(new FabricItemSettings()));
    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(DUNEEDGE);
    }
    public static final Item DUNESCEPTER = registerItem("dunescepter", new DuneScepterItem(new FabricItemSettings()));
    private static void addItemToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(DUNESCEPTER);
    }
    public static final Item BLAZECORNETTI = registerItem("blazecornetti", new BlazeCornettiItem(new FabricItemSettings().food(ModFoodComponents.BLAZECORNETTI)));
    private static void addItemToIngredientTabItemsGroup(FabricItemGroupEntries entries){
        entries.add(BLAZECORNETTI);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(SandSword.MOD_ID, name), item);
    }

    public static void registerModItems(){
        SandSword.LOGGER.info("Registering Mod Items for" + SandSword.MOD_ID);

    }
}