package net.kaupenjoe.tutorialmod.painting

import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.entity.decoration.painting.PaintingMotive
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModPaintings {
    val MARATHON = registerPainting("marathon", PaintingMotive(16, 16))
    val FAMILY = registerPainting("family", PaintingMotive(16, 32))

    private fun registerPainting(name: String, paintingMotive: PaintingMotive): PaintingMotive {
        return Registry.register(Registry.PAINTING_MOTIVE, Identifier(TutorialMod.MOD_ID, name), paintingMotive)
    }

    fun registerPaintings() {
        TutorialMod.LOGGER.info("Registering Paintings for ${TutorialMod.MOD_ID}")
    }
}