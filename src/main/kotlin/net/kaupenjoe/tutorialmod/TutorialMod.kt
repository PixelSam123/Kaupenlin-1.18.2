package net.kaupenjoe.tutorialmod

import net.fabricmc.api.ModInitializer
import net.kaupenjoe.tutorialmod.block.ModBlocks
import net.kaupenjoe.tutorialmod.effect.ModEffects
import net.kaupenjoe.tutorialmod.item.ModItems
import net.kaupenjoe.tutorialmod.painting.ModPaintings
import net.kaupenjoe.tutorialmod.util.ModLootTableModifiers
import net.kaupenjoe.tutorialmod.util.ModRegistries
import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures
import net.kaupenjoe.tutorialmod.world.gen.ModWorldGen
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TutorialMod : ModInitializer {
    companion object {
        const val MOD_ID = "tutorialmod"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }

    override fun onInitialize() {
        ModConfiguredFeatures.registerConfiguredFeatures()
        ModItems.registerModItems()
        ModBlocks.registerModBlocks()
        ModPaintings.registerPaintings()
        ModRegistries.registerModStuffs()
        ModWorldGen.generateModWorldGen()
        ModLootTableModifiers.modifyLootTables()
        ModEffects.registerEffects()
    }
}