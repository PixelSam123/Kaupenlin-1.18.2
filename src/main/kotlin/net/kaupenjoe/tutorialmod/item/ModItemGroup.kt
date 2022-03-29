package net.kaupenjoe.tutorialmod.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

object ModItemGroup {
    val MYTHRIL: ItemGroup = FabricItemGroupBuilder.build(Identifier(TutorialMod.MOD_ID, "mythril")) {
        ItemStack(ModItems.MYTHRIL_INGOT)
    }
}