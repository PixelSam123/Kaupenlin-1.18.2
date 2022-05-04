package net.kaupenjoe.tutorialmod.world.feature.tree

import net.kaupenjoe.tutorialmod.world.feature.ModConfiguredFeatures
import net.minecraft.block.sapling.SaplingGenerator
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.world.gen.feature.ConfiguredFeature
import java.util.*

class JacarandaSaplingGenerator : SaplingGenerator() {
    override fun getTreeFeature(random: Random, bees: Boolean): RegistryEntry<out ConfiguredFeature<*, *>> {
        return ModConfiguredFeatures.JACARANDA_TREE
    }
}