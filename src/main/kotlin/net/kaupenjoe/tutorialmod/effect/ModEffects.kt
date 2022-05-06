package net.kaupenjoe.tutorialmod.effect

import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModEffects {
    val FREEZE = registerStatusEffect("freeze")

    private fun registerStatusEffect(name: String): StatusEffect {
        return Registry.register(
            Registry.STATUS_EFFECT,
            Identifier(TutorialMod.MOD_ID, name),
            FreezeEffect(StatusEffectCategory.HARMFUL, 3124687)
        )
    }

    fun registerEffects() {
        TutorialMod.LOGGER.info("Registering StatusEffects for ${TutorialMod.MOD_ID}")
    }
}