package net.donut.legends_dod.item;

import net.donut.legends_dod.LegendsDoD;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LegendsDoD.MOD_ID);

    public static final DeferredItem<Item> LEGEND_SHARD = ITEMS.register("legend_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LEGEND_SHARD = ITEMS.register("raw_legend_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEGEND_STAR = ITEMS.register("legend_star", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NORMAL_ESSENCE = ITEMS.register("normal_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FIRE_ESSENCE = ITEMS.register("fire_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WATER_ESSENCE = ITEMS.register("water_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRASS_ESSENCE = ITEMS.register("grass_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROCK_ESSENCE = ITEMS.register("rock_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ELECTRIC_ESSENCE = ITEMS.register("electric_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POISON_ESSENCE = ITEMS.register("poison_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PSYCHIC_ESSENCE = ITEMS.register("psychic_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GROUND_ESSENCE = ITEMS.register("ground_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLYING_ESSENCE = ITEMS.register("flying_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BUG_ESSENCE = ITEMS.register("bug_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GHOST_ESSENCE = ITEMS.register("ghost_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_ESSENCE = ITEMS.register("steel_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FIGHTING_ESSENCE = ITEMS.register("fighting_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ICE_ESSENCE = ITEMS.register("ice_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRAGON_ESSENCE = ITEMS.register("dragon_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_ESSENCE = ITEMS.register("dark_essence", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FAIRY_ESSENCE = ITEMS.register("fairy_essence", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };
}
