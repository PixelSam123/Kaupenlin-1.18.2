package net.kaupenjoe.tutorialmod.effect

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory

class FreezeEffect(category: StatusEffectCategory, color: Int) : StatusEffect(category, color) {
    override fun applyUpdateEffect(entity: LivingEntity, amplifier: Int) {
        if (!entity.world.isClient) {
            entity.teleport(entity.x, entity.y, entity.z)
            entity.setVelocity(0.0, 0.0, 0.0)
        }

        super.applyUpdateEffect(entity, amplifier)
    }

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        return true
    }
}