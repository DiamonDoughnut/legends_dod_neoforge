package net.donut.legends_dod.item;

import net.donut.legends_dod.LegendsDoD;
import net.donut.legends_dod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegendsDoD.MOD_ID);

    public static final Supplier<CreativeModeTab> LEGEND_ITEMS_TAB = CREATIVE_MODE_TAB.register("legend_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LEGEND_STAR.get()))
                    .title(Component.translatable("creativetab.legends_dod.legend_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEGEND_STAR);
                        output.accept(ModItems.LEGEND_SHARD);
                        output.accept(ModItems.RAW_LEGEND_SHARD);
                        output.accept(ModBlocks.LEGEND_ORE);
                        output.accept(ModBlocks.LEGEND_SHARD_BLOCK);
                        output.accept(ModItems.SUB_LEGEND_BASE);
                        output.accept(ModItems.LEGEND_BASE);
                        output.accept(ModItems.MYTHIC_BASE);
                        output.accept(ModItems.ULTRA_BEAST_BASE);
                        output.accept(ModItems.UNSTABLE_BASE);
                        output.accept(ModItems.PAST_PARADOX_BASE);
                        output.accept(ModItems.FUTURE_PARADOX_BASE);
                    }).build());

    public static final Supplier<CreativeModeTab> SUMMON_ITEMS_TAB = CREATIVE_MODE_TAB.register("legend_summons_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LegendsDoD.MOD_ID, "legend_items_tab"))
                    .icon(() -> new ItemStack(ModItems.MYTHIC_SUMMONS.getFirst().get()))
                    .title(Component.translatable("creativetab.legends_dod.summon_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        ModItems.SUB_LEGEND_SUMMONS.forEach(output::accept);
                        ModItems.LEGEND_SUMMONS.forEach(output::accept);
                        ModItems.MYTHIC_SUMMONS.forEach(output::accept);
                        ModItems.ULTRA_BEAST_SUMMONS.forEach(output::accept);
                        ModItems.PAST_PARADOX_SUMMONS.forEach(output::accept);
                        ModItems.FUTURE_PARADOX_SUMMONS.forEach(output::accept);
                    }).build());

    public static final Supplier<CreativeModeTab> ESSENCE_ITEMS_TAB = CREATIVE_MODE_TAB.register("essence_items_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LegendsDoD.MOD_ID, "legend_summons_tab"))
                    .icon(() -> new ItemStack(ModItems.NORMAL_ESSENCE.get()))
                    .title(Component.translatable("creativetab.legends_dod.essence_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROCK_ESSENCE);
                        output.accept(ModItems.WATER_ESSENCE);
                        output.accept(ModItems.ELECTRIC_ESSENCE);
                        output.accept(ModItems.GRASS_ESSENCE);
                        output.accept(ModItems.POISON_ESSENCE);
                        output.accept(ModItems.PSYCHIC_ESSENCE);
                        output.accept(ModItems.FIRE_ESSENCE);
                        output.accept(ModItems.GROUND_ESSENCE);
                        output.accept(ModItems.FLYING_ESSENCE);
                        output.accept(ModItems.BUG_ESSENCE);
                        output.accept(ModItems.NORMAL_ESSENCE);
                        output.accept(ModItems.GHOST_ESSENCE);
                        output.accept(ModItems.STEEL_ESSENCE);
                        output.accept(ModItems.FIGHTING_ESSENCE);
                        output.accept(ModItems.ICE_ESSENCE);
                        output.accept(ModItems.DRAGON_ESSENCE);
                        output.accept(ModItems.DARK_ESSENCE);
                        output.accept(ModItems.FAIRY_ESSENCE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
