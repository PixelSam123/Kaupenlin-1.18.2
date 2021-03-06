package net.kaupenjoe.tutorialmod.world.feature

import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.feature.PlacedFeatures
import net.minecraft.world.gen.feature.VegetationPlacedFeatures
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier

object ModPlacedFeatures {
    val JACARANDA_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "jacaranda_placed",
        ModConfiguredFeatures.JACARANDA_SPAWN,
        VegetationPlacedFeatures.modifiers(
            PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)
        )
    )

    val LILAC_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "lilac_placed",
        ModConfiguredFeatures.LILAC_FLOWER,
        RarityFilterPlacementModifier.of(4),
        SquarePlacementModifier.of(),
        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
        BiomePlacementModifier.of()
    )

    val MYTHRIL_ORE_PLACED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "mythril_ore_placed",
        ModConfiguredFeatures.MYTHRIL_ORE,
        ModOreFeatures.modifiersWithCount(
            7,
            HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80))
        )
    )
}