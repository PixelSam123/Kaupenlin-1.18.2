package net.kaupenjoe.tutorialmod.util

import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.tag.TagKey
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModTags {
    object Blocks {
        val DOWSING_ROD_DETECTABLE_BLOCKS = createTag("dowsing_rod_detectable_blocks")

        private fun createTag(name: String): TagKey<Block> =
            TagKey.of(Registry.BLOCK_KEY, Identifier(TutorialMod.MOD_ID, name))

        private fun createCommonTag(name: String): TagKey<Block> =
            TagKey.of(Registry.BLOCK_KEY, Identifier("c", name))
    }

    object Items {
        val MYTHRIL_INGOTS = createCommonTag("mythril_ingots")
        val MYTHRIL_NUGGETS = createCommonTag("mythril_nuggets")

        private fun createTag(name: String): TagKey<Item> =
            TagKey.of(Registry.ITEM_KEY, Identifier(TutorialMod.MOD_ID, name))

        private fun createCommonTag(name: String): TagKey<Item> =
            TagKey.of(Registry.ITEM_KEY, Identifier("c", name))
    }
}