package net.kaupenjoe.tutorialmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.item.Item
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

    private fun registerItem(name: String, item: Item): Item =
        Registry.register(Registry.ITEM, Identifier(TutorialMod.MOD_ID, name), item)

    fun registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for ${TutorialMod.MOD_ID}")
    }
}