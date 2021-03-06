package net.kaupenjoe.tutorialmod.world.gen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.kaupenjoe.tutorialmod.world.feature.ModPlacedFeatures
import net.minecraft.world.gen.GenerationStep

object ModOreGeneration {
    fun generateOres() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            ModPlacedFeatures.MYTHRIL_ORE_PLACED.key.get()
        )
    }
}