package net.kaupenjoe.tutorialmod.item

import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Lazy

enum class ModArmorMaterials(
    private val materialName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: Array<Int>,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    repairIngredientSupplier: () -> Ingredient
) : ArmorMaterial {
    MYTHRIL("mythril", 16, arrayOf(2, 5, 7, 2), 28,
        SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, 0.0f, { Ingredient.ofItems(ModItems.MYTHRIL_INGOT) });

    private val repairIngredientSupplier = Lazy(repairIngredientSupplier)

    override fun getDurability(slot: EquipmentSlot): Int = BASE_DURABILITY[slot.entitySlotId] * durabilityMultiplier
    override fun getProtectionAmount(slot: EquipmentSlot): Int = protectionAmounts[slot.entitySlotId]
    override fun getEnchantability(): Int = enchantability
    override fun getEquipSound(): SoundEvent = equipSound
    override fun getRepairIngredient(): Ingredient = repairIngredientSupplier.get()
    override fun getName(): String = materialName
    override fun getToughness(): Float = toughness
    override fun getKnockbackResistance(): Float = knockbackResistance

    companion object {
        private val BASE_DURABILITY = arrayOf(13, 15, 16, 11)
    }
}