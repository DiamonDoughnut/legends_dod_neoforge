package net.donut.legends_dod;

import com.mojang.logging.LogUtils;
import net.donut.legends_dod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LegendsDoD.MOD_ID)
public class LegendsDoD {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "legends_dod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public LegendsDoD(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (LegendsDoD) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.LEGEND_SHARD);
            event.accept(ModItems.RAW_LEGEND_SHARD);
            event.accept(ModItems.LEGEND_STAR);
            event.accept(ModItems.BUG_ESSENCE);
            event.accept(ModItems.DARK_ESSENCE);
            event.accept(ModItems.DRAGON_ESSENCE);
            event.accept(ModItems.ELECTRIC_ESSENCE);
            event.accept(ModItems.FAIRY_ESSENCE);
            event.accept(ModItems.FIGHTING_ESSENCE);
            event.accept(ModItems.FIRE_ESSENCE);
            event.accept(ModItems.FLYING_ESSENCE);
            event.accept(ModItems.GHOST_ESSENCE);
            event.accept(ModItems.GRASS_ESSENCE);
            event.accept(ModItems.GROUND_ESSENCE);
            event.accept(ModItems.ICE_ESSENCE);
            event.accept(ModItems.NORMAL_ESSENCE);
            event.accept(ModItems.POISON_ESSENCE);
            event.accept(ModItems.PSYCHIC_ESSENCE);
            event.accept(ModItems.ROCK_ESSENCE);
            event.accept(ModItems.STEEL_ESSENCE);
            event.accept(ModItems.WATER_ESSENCE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
        }
    }
}
