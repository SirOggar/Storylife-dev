package fr.siroggar.storylife.Items;

import fr.siroggar.storylife.StoryLife;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class StoryLifeItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StoryLife.MOD_ID);

    //moneystab items
    public static final RegistryObject<Item> wallet = ITEMS.register("wallet",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> credit_card = ITEMS.register("credit_card",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> one_cent = ITEMS.register("one_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> two_cent = ITEMS.register("two_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> five_cent = ITEMS.register("five_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ten_cent = ITEMS.register("ten_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> twenty_cent = ITEMS.register("twenty_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> fifty_cent = ITEMS.register("fifty_cent",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> one_euro = ITEMS.register("one_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> two_euro = ITEMS.register("two_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> five_euro = ITEMS.register("five_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ten_euro = ITEMS.register("ten_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> twenty_euro = ITEMS.register("twenty_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> fifty_euro = ITEMS.register("fifty_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> one_hundred_euro = ITEMS.register("one_hundred_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> two_hundred_euro = ITEMS.register("two_hundred_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> five_hundred_euro = ITEMS.register("five_hundred_euro",
            () -> new Item(new Item.Properties().stacksTo(64)));


    //papertab items
    public static final RegistryObject<Item> driver_license = ITEMS.register("driver_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> agricultural_license = ITEMS.register("agricultural_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> hunting_license = ITEMS.register("hunting_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> lumberjack_license = ITEMS.register("lumberjack_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> fishing_license = ITEMS.register("fishing_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> miner_license = ITEMS.register("miner_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> gun_license = ITEMS.register("gun_license",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> id_card = ITEMS.register("id_card",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}