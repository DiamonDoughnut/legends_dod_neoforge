package net.donut.legends_dod.item.custom;

import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import net.donut.legends_dod.item.ModItems;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class SummonItem extends Item {
    public SummonItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.getItem().getDescriptionId().contains("shiny");
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use (@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        ItemLike blockItemHit = level.getBlockState(blockhitresult.getBlockPos()).getBlock();
        if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else if (!(level instanceof ServerLevel)) {
            return InteractionResultHolder.success(itemstack);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            if (level.mayInteract(player, blockpos) && player.mayUseItemAt(blockpos, blockhitresult.getDirection(), itemstack)) {
                if (!Level.isInSpawnableBounds(blockpos)){
                    player.sendSystemMessage(Component.literal("Invalid Position").withColor(0xFFFF0000));
                    return InteractionResultHolder.fail(itemstack);
                }
                PokemonProperties entity = this.getType(itemstack, player);
                if (entity.getSpecies() == null) {
                    player.sendSystemMessage(Component.literal("Species Not Found").withColor(0xFFFF0000));
                    return InteractionResultHolder.fail(itemstack);
                }
                PokemonEntity pokemonEntity = entity.createEntity(level);
                pokemonEntity.setPokemon(entity.create());
                pokemonEntity.moveTo(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ(), player.getYHeadRot(), -player.getXRot());
                pokemonEntity.getEntityData().set(PokemonEntity.getSPAWN_DIRECTION(), pokemonEntity.getRandom().nextFloat() * 360F);
                PokemonProperties formProperty = new PokemonProperties();
                formProperty.setAspects(Set.of(itemstack.getItem().getDescriptionId().substring(17).toLowerCase().split("_")[1]));
//                formProperty.setNickname(pokemonEntity.getPokemon().getSpecies().getTranslatedName());
                formProperty.apply(pokemonEntity);
                pokemonEntity.setInvulnerable(true);
                level.addFreshEntity(pokemonEntity);
                if (!player.isCreative()) {
                    pokemonEntity.forceBattle(player.getServer().getPlayerList().getPlayer(player.getUUID()));
                }
                player.sendSystemMessage(Component.literal(formProperty.getAspects().stream().reduce((String a, String b) -> a + b).toString()));
                //pokemonEntity.forceBattle(new ServerPlayer(level.getServer(), level.getServer().getLevel(level.dimension()), player.getGameProfile(), ClientInformation.createDefault()));
                if(itemstack.getItem().getDescriptionId().contains("shiny_summon")) {
                    itemstack.shrink(1);
                } else {
                    player.setItemInHand(hand, ModItems.LEGEND_STAR.toStack());
                }
                player.awardStat(Stats.ITEM_USED.get(this));
                CobblemonEvents.ENTITY_SPAWN.emit();

                return InteractionResultHolder.consume(itemstack);
            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }

    public PokemonProperties getType(ItemStack itemStack, Player player) {
        String ITEM_NAME = itemStack.getItem().getDescriptionId().substring(17, itemStack.getItem().getDescriptionId().length() - 7);
        String SPECIES = ITEM_NAME.toLowerCase().split("_")[0];
        Boolean SHINY = ITEM_NAME.toLowerCase().contains("shiny");
        String FORM = ITEM_NAME.toLowerCase().split("_").length > 1 ? ITEM_NAME.toLowerCase().split("_")[1] : "";
        Integer LEVEL = 50;


        if (SHINY) {
            LEVEL = 70;
        }
        PokemonProperties properties = PokemonProperties.Companion.parse(ITEM_NAME + "_level=" + LEVEL, "_");
//        properties.setShiny(SHINY);
//        properties.setAspects(Set.of(FORM.toLowerCase()));
//        properties.setSpecies(SPECIES);
//        properties.setLevel(LEVEL);
//        properties.setNickname(Component.literal(SPECIES.toUpperCase().charAt(0) + SPECIES.substring(1)));
        sendServerMessage(player, SPECIES, FORM, SHINY);
        return properties;
    }

    public static void sendServerMessage(Player player, String name, String form, Boolean shiny) {
        if (player != null) {
            List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
            String message = player.getName().getString() + " has summoned a";
            if(form.isEmpty() && !shiny) {
                if (vowels.stream().anyMatch(character -> character == name.charAt(0))) {
                    message += "n";
                }
            }
            if (shiny) {
                message += " Shiny";
            }
            if (!form.isEmpty() && !form.equals("shiny")) {
                message += " " + form.toUpperCase().charAt(0) + form.substring(1);
            }
            message += " " + name.toUpperCase().charAt(0) + name.substring(1);
            PlayerChatMessage chatMessage = PlayerChatMessage.unsigned(player.getUUID(), message);
            Level level = player.level();
            if (!(level instanceof ClientLevel)) {
                player.createCommandSourceStack().sendChatMessage(
                        new OutgoingChatMessage.Player(chatMessage),
                        false,
                        ChatType.bind(ChatType.CHAT, player)
                );
            }
        }
    }

    public static final List<String> SUB_LEGENDS = List.of(
            "articuno",
            "articuno_galarian",
            "azelf",
            "chienpao",
            "chiyu",
            "cobalion",
            "cresselia",
            "enamorus",
            "entei",
            "fezandipiti",
            "glastrier",
            "heatran",
            "kubfu",
            "landorus",
            "latias",
            "latios",
            "mesprit",
            "moltres",
            "moltres_galarian",
            "munkidori",
            "okidogi",
            "ogerpon",
            "raikou",
            "regice",
            "regidrago",
            "regieleki",
            "regigigas",
            "regirock",
            "registeel",
            "silvally",
            "spectrier",
            "suicune",
            "tapubulu",
            "tapufini",
            "tapukoko",
            "tapulele",
            "terrakion",
            "thundurus",
            "tinglu",
            "tornadus",
            "typenull",
            "urshifu",
            "uxie",
            "virizion",
            "wochien",
            "zapdos",
            "zapdos_galarian"
    );
    public static final List<String> LEGENDS = List.of(
            "calyrex",
            "cosmoem",
            "cosmog",
            "dialga",
            "eternatus",
            "giratina",
            "groudon",
            "hooh",
            "koraidon",
            "kyogre",
            "kyurem",
            "lugia",
            "lunala",
            "mewtwo",
            "necrozma",
            "palkia",
            "rayquaza",
            "solgaleo",
            "terapagos",
            "xerneas",
            "yveltal",
            "zacian",
            "zamazenta",
            "zekrom",
            "zygarde"
    );
    public static final List<String> MYTHICS = List.of(
            "arceus",
            "celebi",
            "darkrai",
            "deoxys",
            "diancie",
            "genesect",
            "hoopa",
            "jirachi",
            "keldeo",
            "magearna",
            "manaphy",
            "marshadow",
            "melmetal",
            "meloetta",
            "meltan",
            "mew",
            "pecharunt",
            "phione",
            "shaymin",
            "victini",
            "volcanion",
            "zarude",
            "zeraora"
    );
    public static final List<String> ULTRA_BEASTS = List.of(
            "blacephalon",
            "buzzwole",
            "celesteela",
            "guzzlord",
            "kartana",
            "naganadel",
            "nihilego",
            "pheromosa",
            "poipole",
            "stakataka",
            "xurkitree"
    );
    public static final List<String> PAST_PARADOXES = List.of(
            "brutebonnet",
            "fluttermane",
            "gougingfire",
            "greattusk",
            "ragingbolt",
            "roaringmoon",
            "sandyshocks",
            "screamtail",
            "slitherwing",
            "walkingwake"
    );public static final List<String> FUTURE_PARADOXES = List.of(
            "ironboulder",
            "ironbundle",
            "ironcrown",
            "ironhands",
            "ironjugulis",
            "ironleaves",
            "ironmoth",
            "ironthorns",
            "irontreads",
            "ironvaliant"
    );
}
