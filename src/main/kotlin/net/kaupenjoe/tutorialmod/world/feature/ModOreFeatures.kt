package net.kaupenjoe.tutorialmod.world.feature

import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier
import net.minecraft.world.gen.placementmodifier.PlacementModifier
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier

object ModOreFeatures {
    fun modifiers(countModifier: PlacementModifier, heightModifier: PlacementModifier): List<PlacementModifier> {
        return listOf(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of())
    }

    fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
        return modifiers(CountPlacementModifier.of(count), heightModifier)
    }

    fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
    }
}