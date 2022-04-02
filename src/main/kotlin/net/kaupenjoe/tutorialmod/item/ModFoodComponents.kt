package net.kaupenjoe.tutorialmod.item

import net.minecraft.item.FoodComponent

object ModFoodComponents {
    val GRAPE: FoodComponent = FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build()
}