package net.kaupenjoe.tutorialmod.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.block.custom.SpeedyBlock
import net.kaupenjoe.tutorialmod.item.ModItemGroup
import net.minecraft.block.Block
import net.minecraft.block.DoorBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.Material
import net.minecraft.block.PressurePlateBlock
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.StoneButtonBlock
import net.minecraft.block.TrapdoorBlock
import net.minecraft.block.WallBlock
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

object ModBlocks {
    val MYTHRIL_BLOCK = registerBlock(
        "mythril_block",
        Block(FabricBlockSettings.of(Material.METAL).strength(6f).requiresTool()),
        ModItemGroup.MYTHRIL,
        "tooltip.tutorialmod.mythril_block"
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

    val MYTHRIL_BUTTON = registerBlock(
        "mythril_button",
        StoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool().noCollision()),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_PRESSURE_PLATE = registerBlock(
        "mythril_pressure_plate",
        PressurePlateBlock(
            PressurePlateBlock.ActivationRule.EVERYTHING,
            FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()
        ),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_FENCE = registerBlock(
        "mythril_fence",
        FenceBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_FENCE_GATE = registerBlock(
        "mythril_fence_gate",
        FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_WALL = registerBlock(
        "mythril_wall",
        WallBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_SLAB = registerBlock(
        "mythril_slab",
        SlabBlock(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroup.MYTHRIL
    )

    val MYTHRIL_STAIRS = registerBlock(
        "mythril_stairs",
        StairsBlock(MYTHRIL_BLOCK.defaultState, FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()),
        ModItemGroup.MYTHRIL
    )

    val KAUPEN_DOOR = registerBlock(
        "kaupen_door",
        DoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()),
        ModItemGroup.MYTHRIL
    )

    val KAUPEN_TRAPDOOR = registerBlock(
        "kaupen_trapdoor",
        TrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).requiresTool().nonOpaque()),
        ModItemGroup.MYTHRIL
    )

    private fun registerBlock(name: String, block: Block, group: ItemGroup, tooltipKey: String = ""): Block {
        registerBlockItem(name, block, group, tooltipKey)
        return Registry.register(Registry.BLOCK, Identifier(TutorialMod.MOD_ID, name), block)
    }

    private fun registerBlockItem(name: String, block: Block, group: ItemGroup, tooltipKey: String = ""): Item {
        val itemSettings = FabricItemSettings().group(group)

        return Registry.register(
            Registry.ITEM,
            Identifier(TutorialMod.MOD_ID, name),
            if (tooltipKey == "") {
                BlockItem(block, itemSettings)
            } else {
                object : BlockItem(block, itemSettings) {
                    override fun appendTooltip(
                        stack: ItemStack,
                        world: World?,
                        tooltip: MutableList<Text>,
                        context: TooltipContext
                    ) {
                        tooltip.add(TranslatableText(tooltipKey))
                    }
                }
            }
        )
    }

    fun registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for ${TutorialMod.MOD_ID}")
    }
}