package mod.azure.goldenberry;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class GoldenBerriesMod implements ModInitializer {

    public static final Item GOLDENBERRY = new Item(new Item.Properties()
            .food(new FoodProperties.Builder().alwaysEat().saturationMod(1.2F).nutrition(6).build()));

    @Override
    public void onInitialize() {
        CommonClass.init();
        Registry.register(BuiltInRegistries.ITEM, Constants.rl("golden_berries"), GOLDENBERRY);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(entries -> entries.accept(GOLDENBERRY));
    }
}
