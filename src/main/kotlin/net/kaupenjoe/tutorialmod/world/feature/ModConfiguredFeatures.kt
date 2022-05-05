package net.kaupenjoe.tutorialmod.world.feature

import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.block.ModBlocks
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize
import net.minecraft.world.gen.foliage.BlobFoliagePlacer
import net.minecraft.world.gen.stateprovider.BlockStateProvider
import net.minecraft.world.gen.trunk.StraightTrunkPlacer

object ModConfiguredFeatures {
    val JACARANDA_TREE: RegistryEntry<ConfiguredFeature<TreeFeatureConfig, *>> = ConfiguredFeatures.register(
        "jacaranda_tree",
        Feature.TREE,
        TreeFeatureConfig.Builder(
            BlockStateProvider.of(ModBlocks.JACARANDA_LOG),
            StraightTrunkPlacer(5, 6, 3),
            BlockStateProvider.of(ModBlocks.JACARANDA_LEAVES),
            BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
            TwoLayersFeatureSize(1, 0, 2)
        ).build()
    )

    val JACARANDA_CHECKED: RegistryEntry<PlacedFeature> = PlacedFeatures.register(
        "jacaranda_checked",
        JACARANDA_TREE,
        PlacedFeatures.wouldSurvive(ModBlocks.JACARANDA_SAPLING)
    )

    val JACARANDA_SPAWN: RegistryEntry<ConfiguredFeature<RandomFeatureConfig, *>> = ConfiguredFeatures.register(
        "jacaranda_spawn",
        Feature.RANDOM_SELECTOR,
        RandomFeatureConfig(listOf(RandomFeatureEntry(JACARANDA_CHECKED, 0.5f)), JACARANDA_CHECKED)
    )

    val LILAC_FLOWER: RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, *>> = ConfiguredFeatures.register(
        "lilac_flower",
        Feature.FLOWER,
        ConfiguredFeatures.createRandomPatchFeatureConfig(
            64,
            PlacedFeatures.createEntry(
                Feature.SIMPLE_BLOCK,
                SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LILAC_FLOWER))
            )
        )
    )

    val OVERWORLD_MYTHRIL_ORES = listOf(
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
            ModBlocks.MYTHRIL_ORE.defaultState
        ),
        OreFeatureConfig.createTarget(
            OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
            ModBlocks.DEEPSLATE_MYTHRIL_ORE.defaultState
        )
    )

    val MYTHRIL_ORE: RegistryEntry<ConfiguredFeature<OreFeatureConfig, *>> = ConfiguredFeatures.register(
        "mythril_ore",
        Feature.ORE,
        OreFeatureConfig(OVERWORLD_MYTHRIL_ORES, 9)
    )

    fun registerConfiguredFeatures() {
        TutorialMod.LOGGER.info("Registering ModConfiguredFeatures for ${TutorialMod.MOD_ID}")
    }
}