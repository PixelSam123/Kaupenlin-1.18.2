package net.kaupenjoe.tutorialmod.util

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
import net.fabricmc.fabric.api.`object`.builder.v1.trade.TradeOfferHelper
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.block.ModBlocks
import net.kaupenjoe.tutorialmod.command.ReturnHomeCommand
import net.kaupenjoe.tutorialmod.command.SetHomeCommand
import net.kaupenjoe.tutorialmod.event.ModPlayerEventCopyFrom
import net.kaupenjoe.tutorialmod.item.ModItems
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.village.TradeOffer
import net.minecraft.village.VillagerProfession

object ModRegistries {
    fun registerModStuffs() {
        registerFuels()
        registerCommands()
        registerEvents()
        registerStrippables()
        registerFlammableBlock()
        registerCustomTrades()
    }

    private fun registerFuels() {
        TutorialMod.LOGGER.info("Registering Fuels for ${TutorialMod.MOD_ID}")
        val registry = FuelRegistry.INSTANCE

        registry.add(ModItems.LILAC_FLOWER_BULB, 200)
    }

    private fun registerCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register)
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register)
    }

    private fun registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.JACARANDA_LOG, ModBlocks.STRIPPED_JACARANDA_LOG)
        StrippableBlockRegistry.register(ModBlocks.JACARANDA_WOOD, ModBlocks.STRIPPED_JACARANDA_WOOD)
    }

    private fun registerFlammableBlock() {
        val instance = FlammableBlockRegistry.getDefaultInstance()

        instance.add(ModBlocks.JACARANDA_LOG, 5, 5)
        instance.add(ModBlocks.STRIPPED_JACARANDA_LOG, 5, 5)
        instance.add(ModBlocks.JACARANDA_WOOD, 5, 5)
        instance.add(ModBlocks.STRIPPED_JACARANDA_WOOD, 5, 5)
        instance.add(ModBlocks.JACARANDA_PLANKS, 5, 20)
        instance.add(ModBlocks.JACARANDA_LEAVES, 30, 60)
    }

    private fun registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(ModPlayerEventCopyFrom())
    }

    private fun registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1) { factories ->
            factories.add { _, _ ->
                TradeOffer(
                    ItemStack(Items.EMERALD, 2),
                    ItemStack(ModItems.GRAPE, 12),
                    6,
                    2,
                    0.02f
                )
            }
        }

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3) { factories ->
            factories.add { _, _ ->
                TradeOffer(
                    ItemStack(Items.EMERALD, 6),
                    ItemStack(ModItems.MYTHRIL_PICKAXE, 1),
                    12,
                    7,
                    0.08f
                )
            }
        }
    }
}