package net.kaupenjoe.tutorialmod

import net.fabricmc.api.ModInitializer
import net.kaupenjoe.tutorialmod.block.ModBlocks
import net.kaupenjoe.tutorialmod.item.ModItems
import net.kaupenjoe.tutorialmod.util.ModRegistries
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TutorialMod : ModInitializer {
    companion object {
        const val MOD_ID = "tutorialmod"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        ModItems.registerModItems()
        ModBlocks.registerModBlocks()
        ModRegistries.registerModStuffs()
    }
}