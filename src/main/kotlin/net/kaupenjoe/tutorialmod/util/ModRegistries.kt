package net.kaupenjoe.tutorialmod.util

import net.fabricmc.fabric.api.registry.FuelRegistry
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.item.ModItems

object ModRegistries {
    fun registerModStuffs() {
        registerFuels()
    }

    private fun registerFuels() {
        TutorialMod.LOGGER.info("Registering Fuels for ${TutorialMod.MOD_ID}")
        val registry = FuelRegistry.INSTANCE

        registry.add(ModItems.LILAC_FLOWER_BULB, 200)
    }
}