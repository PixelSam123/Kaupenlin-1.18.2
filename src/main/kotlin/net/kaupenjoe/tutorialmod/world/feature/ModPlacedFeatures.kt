package net.kaupenjoe.tutorialmod.world.feature

import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures

object ModPlacedFeatures {
    val JACARANDA_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "jacaranda_placed",
        ModConfiguredFeatures.JACARANDA_SPAWN,
        VegetationPlacedFeatures.modifiers(
            PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
        )
    )
}