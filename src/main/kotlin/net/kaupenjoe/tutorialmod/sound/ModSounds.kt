package net.kaupenjoe.tutorialmod.sound

import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModSounds {
    val DOWSING_ROD_FOUND_ORE = registerSoundEvent("dowsing_rod_found_ore")

    val MYTHRIL_LAMP_BREAK = registerSoundEvent("mythril_lamp_break")
    val MYTHRIL_LAMP_STEP = registerSoundEvent("mythril_lamp_step")
    val MYTHRIL_LAMP_PLACE = registerSoundEvent("mythril_lamp_place")
    val MYTHRIL_LAMP_HIT = registerSoundEvent("mythril_lamp_hit")
    val MYTHRIL_LAMP_FALL = registerSoundEvent("mythril_lamp_fall")

    val MYTHRIL_SOUNDS = BlockSoundGroup(
        1f,
        1f,
        MYTHRIL_LAMP_BREAK,
        MYTHRIL_LAMP_STEP,
        MYTHRIL_LAMP_PLACE,
        MYTHRIL_LAMP_HIT,
        MYTHRIL_LAMP_FALL
    )

    private fun registerSoundEvent(name: String): SoundEvent {
        val id = Identifier(TutorialMod.MOD_ID, name)
        return Registry.register(Registry.SOUND_EVENT, id, SoundEvent(id))
    }
}