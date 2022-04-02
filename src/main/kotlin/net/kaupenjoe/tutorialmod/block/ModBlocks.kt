package net.kaupenjoe.tutorialmod.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.block.custom.SpeedyBlock
import net.kaupenjoe.tutorialmod.item.ModItemGroup
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModBlocks {
    val MYTHRIL_BLOCK = registerBlock(
        "mythril_block",
        Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()), ModItemGroup.MYTHRIL
    )

    val MYTHRIL_ORE = registerBlock(
        "mythril_ore",
        Block(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL
    )

    val DEEPSLATE_MYTHRIL_ORE = registerBlock(
        "deepslate_mythril_ore",
        Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL
    )

    val NETHERRACK_MYTHRIL_ORE = registerBlock(
        "netherrack_mythril_ore",
        Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL
    )

    val RAW_MYTHRIL_BLOCK = registerBlock(
        "raw_mythril_block",
        Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL
    )

    val SPEEDY_BLOCK = registerBlock(
        "speedy_block",
        SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.MYTHRIL
    )

    private fun registerBlock(name: String, block: Block, group: ItemGroup): Block {
        registerBlockItem(name, block, group)
        return Registry.register(Registry.BLOCK, Identifier(TutorialMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block, group: ItemGroup): Item = Registry.register(
        Registry.ITEM,
        Identifier(TutorialMod.MOD_ID, name),
        BlockItem(block, FabricItemSettings().group(group))
    )

    fun registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for ${TutorialMod.MOD_ID}")
    }
}