package net.kaupenjoe.tutorialmod.util

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.kaupenjoe.tutorialmod.item.ModItems
import net.minecraft.loot.condition.RandomChanceLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.function.SetCountLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.loot.provider.number.UniformLootNumberProvider
import net.minecraft.util.Identifier

object ModLootTableModifiers {
    private val GRASS_BLOCK_ID = Identifier("minecraft", "blocks/grass")
    private val IGLOO_STRUCTURE_CHEST_ID = Identifier("minecraft", "chests/igloo_chest")
    private val CREEPER_ID = Identifier("minecraft", "entities/creeper")

    fun modifyLootTables() {
        LootTableLoadingCallback.EVENT.register { _, _, id, supplier, _ ->
            // check for leaves loot table
            if (GRASS_BLOCK_ID == id) {
                // Adds Grape Seeds to the grass loot table.
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(0.35f)) // Drops 35% of the time
                    .with(ItemEntry.builder(ModItems.GRAPE_SEEDS))
                    .withFunction(
                        SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()
                    )

                supplier.withPool(poolBuilder.build())
            }

            if (IGLOO_STRUCTURE_CHEST_ID == id) {
                // Adds a Dowsing Rod into the Igloo Chest with 100% chance.
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                    .with(ItemEntry.builder(ModItems.DOWSING_ROD))
                    .withFunction(
                        SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()
                    )

                supplier.withPool(poolBuilder.build())
            }

            if (CREEPER_ID == id) {
                // Adds a Lilac Flower Bulb to Creepers.
                val poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootNumberProvider.create(1f))
                    .conditionally(RandomChanceLootCondition.builder(1f))
                    .with(ItemEntry.builder(ModItems.LILAC_FLOWER_BULB))
                    .withFunction(
                        SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()
                    )

                supplier.withPool(poolBuilder.build())
            }
        }
    }
}