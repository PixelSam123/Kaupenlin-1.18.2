package net.kaupenjoe.tutorialmod.util

import net.kaupenjoe.tutorialmod.item.ModItems
import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.item.Item
import net.minecraft.util.Identifier

object ModModelPredicateProvider {
    fun registerModModels() {
        registerBow(ModItems.KAUPENBOW)
    }

    private fun registerBow(bow: Item) {
        ModelPredicateProviderRegistry.register(bow, Identifier("pull")) { stack, _, entity, _ ->
            when {
                entity == null -> 0.0f
                entity.activeItem != stack -> 0.0f
                else -> (stack.maxUseTime - entity.itemUseTimeLeft).toFloat() / 20.0f
            }
        }

        ModelPredicateProviderRegistry.register(bow, Identifier("pulling")) { stack, _, entity, _ ->
            if (entity != null && entity.isUsingItem && entity.activeItem == stack) {
                1.0f
            } else {
                0.0f
            }
        }
    }
}