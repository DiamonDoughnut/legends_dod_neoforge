package net.donut.legends_dod.item;

import net.donut.legends_dod.LegendsDoD;
import net.donut.legends_dod.item.custom.SummonItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LegendsDoD.MOD_ID);

    public static final DeferredItem<Item> LEGEND_SHARD = ITEMS.register("legend_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LEGEND_SHARD = ITEMS.register("raw_legend_shard", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEGEND_STAR = ITEMS.register("legend_star", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SUB_LEGEND_BASE = ITEMS.register("sub_legend_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEGEND_BASE = ITEMS.register("legend_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYTHIC_BASE = ITEMS.register("mythic_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ULTRA_BEAST_BASE = ITEMS.register("ultra_beast_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> UNSTABLE_BASE = ITEMS.register("unstable_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PAST_PARADOX_BASE = ITEMS.register("past_paradox_base", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FUTURE_PARADOX_BASE = ITEMS.register("future_paradox_base", () -> new Item(new Item.Properties()));

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

    public static final List<DeferredItem<SummonItem>> SUB_LEGEND_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.SUB_LEGENDS) {
            SUB_LEGEND_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            SUB_LEGEND_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }
    public static final List<DeferredItem<SummonItem>> LEGEND_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.LEGENDS) {
            LEGEND_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            LEGEND_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }
    public static final List<DeferredItem<SummonItem>> MYTHIC_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.MYTHICS) {
            MYTHIC_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            MYTHIC_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }
    public static final List<DeferredItem<SummonItem>> ULTRA_BEAST_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.ULTRA_BEASTS) {
            ULTRA_BEAST_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            ULTRA_BEAST_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }
    public static final List<DeferredItem<SummonItem>> PAST_PARADOX_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.PAST_PARADOXES) {
            PAST_PARADOX_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            PAST_PARADOX_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }
    public static final List<DeferredItem<SummonItem>> FUTURE_PARADOX_SUMMONS = new ArrayList<>();

    static{
        for (String legend : SummonItem.FUTURE_PARADOXES) {
            FUTURE_PARADOX_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
            FUTURE_PARADOX_SUMMONS.add(ITEMS.register(legend.toLowerCase() + "_shiny_summon", () ->
                    new SummonItem(new Item.Properties().durability(1).stacksTo(1).setNoRepair())));
        }
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    };
}
