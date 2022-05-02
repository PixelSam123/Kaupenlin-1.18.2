package net.kaupenjoe.tutorialmod.util

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.command.ReturnHomeCommand
import net.kaupenjoe.tutorialmod.command.SetHomeCommand
import net.kaupenjoe.tutorialmod.event.ModPlayerEventCopyFrom
import net.kaupenjoe.tutorialmod.item.ModItems

object ModRegistries {
    fun registerModStuffs() {
        registerFuels()
        registerCommands()
        registerEvents()
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

    private fun registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(ModPlayerEventCopyFrom())
    }
}