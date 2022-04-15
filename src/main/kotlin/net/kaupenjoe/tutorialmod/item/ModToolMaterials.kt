package net.kaupenjoe.tutorialmod.item

import net.fabricmc.yarn.constants.MiningLevels
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Lazy

enum class ModToolMaterials(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    repairIngredient: () -> Ingredient
) : ToolMaterial {
    MYTHRIL(MiningLevels.IRON, 560, 10.0f, 2.5f, 24, { Ingredient.ofItems(ModItems.MYTHRIL_INGOT) });

    private val repairIngredient = Lazy(repairIngredient)

    override fun getDurability(): Int = itemDurability
    override fun getMiningSpeedMultiplier(): Float = miningSpeed
    override fun getAttackDamage(): Float = attackDamage
    override fun getMiningLevel(): Int = miningLevel
    override fun getEnchantability(): Int = enchantability
    override fun getRepairIngredient(): Ingredient = repairIngredient.get()
}