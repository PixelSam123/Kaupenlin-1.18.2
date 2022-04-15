package net.kaupenjoe.tutorialmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.item.custom.DowsingRodItem
import net.kaupenjoe.tutorialmod.item.custom.ModAxeItem
import net.kaupenjoe.tutorialmod.item.custom.ModHoeItem
import net.kaupenjoe.tutorialmod.item.custom.ModPickaxeItem
import net.minecraft.item.Item
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItems {
    val MYTHRIL_INGOT = registerItem(
        "mythril_ingot",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val MYTHRIL_NUGGET = registerItem(
        "mythril_nugget",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val RAW_MYTHRIL = registerItem(
        "raw_mythril",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val DOWSING_ROD = registerItem(
        "dowsing_rod",
        DowsingRodItem(FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(16))
    )

    val LILAC_FLOWER_BULB = registerItem(
        "lilac_flower_bulb",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val GRAPE = registerItem(
        "grape",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE))
    )

    val MYTHRIL_SWORD = registerItem(
        "mythril_sword",
        SwordItem(
            ModToolMaterials.MYTHRIL, 1, 2f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_AXE = registerItem(
        "mythril_axe",
        ModAxeItem(
            ModToolMaterials.MYTHRIL, 3f, 1f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_HOE = registerItem(
        "mythril_hoe",
        ModHoeItem(
            ModToolMaterials.MYTHRIL, 0, 0f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_SHOVEL = registerItem(
        "mythril_shovel",
        ShovelItem(
            ModToolMaterials.MYTHRIL, 0f, 1f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_PICKAXE = registerItem(
        "mythril_pickaxe",
        ModPickaxeItem(
            ModToolMaterials.MYTHRIL, 1, 0f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )

    private fun registerItem(name: String, item: Item): Item =
        Registry.register(Registry.ITEM, Identifier(TutorialMod.MOD_ID, name), item)

    fun registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for ${TutorialMod.MOD_ID}")
    }
}