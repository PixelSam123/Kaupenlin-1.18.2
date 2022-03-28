package net.kaupenjoe.tutorialmod

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TutorialMod : ModInitializer {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger("modid")
    }

    override fun onInitialize() {
        LOGGER.info("Hello Fabric world!")
    }
}