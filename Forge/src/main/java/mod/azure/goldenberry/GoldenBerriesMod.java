package mod.azure.goldenberry;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Constants.MOD_ID)
public class GoldenBerriesMod {

    public static final DeferredRegister<Item> ITEMS_DEFERRED_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final RegistryObject<Item> GOLDENBERRY = ITEMS_DEFERRED_REGISTER.register("golden_berries",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder().alwaysEat().saturationMod(1.2F).nutrition(6).build())));

    public GoldenBerriesMod() {
        CommonClass.init();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS_DEFERRED_REGISTER.register(bus);
        bus.addListener(this::addCreativeTabs);
    }

    public void addCreativeTabs(final CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
            event.accept(GOLDENBERRY.get());
    }

}