package net.kaupenjoe.tutorialmod.world.gen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.kaupenjoe.tutorialmod.world.feature.ModPlacedFeatures
import net.minecraft.world.biome.Biome
import net.minecraft.world.gen.GenerationStep

object ModFlowerGeneration {
    fun generateFlowers() {
        BiomeModifications.addFeature(
            BiomeSelectors.categories(Biome.Category.PLAINS),
            GenerationStep.Feature.VEGETAL_DECORATION,
            ModPlacedFeatures.LILAC_PLACED.key.get()
        )
    }
}