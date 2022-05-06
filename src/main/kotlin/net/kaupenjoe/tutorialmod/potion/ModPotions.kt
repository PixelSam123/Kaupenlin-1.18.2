package net.kaupenjoe.tutorialmod.potion

import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.effect.ModEffects
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.potion.Potion
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModPotions {
    val FREEZE_POTION = registerPotion("freeze_potion")

    private fun registerPotion(name: String): Potion {
        return Registry.register(
            Registry.POTION,
            Identifier(TutorialMod.MOD_ID, name),
            Potion(StatusEffectInstance(ModEffects.FREEZE, 200, 0))
        )
    }

    fun registerPotions() {
        TutorialMod.LOGGER.info("Registering Potions for ${TutorialMod.MOD_ID}")
    }
}