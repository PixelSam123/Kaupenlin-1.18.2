package net.kaupenjoe.tutorialmod.item.custom

import net.kaupenjoe.tutorialmod.item.ModArmorMaterials
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World

private val MATERIAL_TO_EFFECT_MAP = mapOf(
    ModArmorMaterials.MYTHRIL to StatusEffectInstance(StatusEffects.LUCK, 400, 1)
)

class ModArmorItem(material: ArmorMaterial, slot: EquipmentSlot, settings: Settings) :
    ArmorItem(material, slot, settings) {
    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (!world.isClient && entity is PlayerEntity && hasFullSuitOfArmorOn(entity)) {
            evaluateArmorEffects(entity)
        }

        super.inventoryTick(stack, world, entity, slot, selected)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        for ((mapArmorMaterial, mapStatusEffect) in MATERIAL_TO_EFFECT_MAP.entries) {
            addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect)
        }
    }

    private fun addStatusEffectForMaterial(
        player: PlayerEntity,
        mapArmorMaterial: ArmorMaterial,
        mapStatusEffect: StatusEffectInstance
    ) {
        val hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.effectType)

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(
                StatusEffectInstance(
                    mapStatusEffect.effectType, mapStatusEffect.duration, mapStatusEffect.amplifier
                )
            )
        }

//        if (Random.nextFloat() > 0.6f) { // 40% chance of damaging the armor! Possibly!
//            player.inventory.damageArmor(DamageSource.MAGIC, 1f, intArrayOf(0, 1, 2, 3))
//        }
    }

    private fun hasFullSuitOfArmorOn(player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0)
        val leggings = player.inventory.getArmorStack(1)
        val breastplate = player.inventory.getArmorStack(2)
        val helmet = player.inventory.getArmorStack(3)

        return !helmet.isEmpty && !breastplate.isEmpty && !leggings.isEmpty && !boots.isEmpty
    }

    private fun hasCorrectArmorOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0).item as ArmorItem
        val leggings = player.inventory.getArmorStack(1).item as ArmorItem
        val breastplate = player.inventory.getArmorStack(2).item as ArmorItem
        val helmet = player.inventory.getArmorStack(3).item as ArmorItem

        return helmet.material == material
                && breastplate.material == material
                && leggings.material == material
                && boots.material == material
    }
}