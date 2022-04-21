package net.kaupenjoe.tutorialmod.block.custom

import net.kaupenjoe.tutorialmod.item.ModItems
import net.minecraft.block.CropBlock
import net.minecraft.item.ItemConvertible

class GrapeVineBlock(settings: Settings) : CropBlock(settings) {
    override fun getSeedsItem(): ItemConvertible {
        return ModItems.GRAPE_SEEDS
    }
}