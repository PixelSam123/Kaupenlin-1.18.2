package net.kaupenjoe.tutorialmod.item.custom

import net.kaupenjoe.tutorialmod.item.ModItems
import net.kaupenjoe.tutorialmod.sound.ModSounds
import net.kaupenjoe.tutorialmod.util.ModTags
import net.kaupenjoe.tutorialmod.util.getFirstInventoryIndex
import net.kaupenjoe.tutorialmod.util.hasStackInInventory
import net.minecraft.block.Block
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.nbt.NbtCompound
import net.minecraft.sound.SoundCategory
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

class DowsingRodItem(settings: Settings) : Item(settings) {
    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        if (context.world.isClient) {
            val positionClicked = context.blockPos
            val player = context.player

            if (player != null) {
                var foundBlock = false

                for (i in 0..positionClicked.y + 64) {
                    val blockBelow = context.world.getBlockState(positionClicked.down(i)).block

                    if (isValuableBlock(blockBelow)) {
                        outputValuableCoordinates(positionClicked.down(i), player, blockBelow)
                        foundBlock = true

                        if (player.hasStackInInventory(ModItems.DATA_TABLET)) {
                            addNbtToDataTablet(player, positionClicked.down(i), blockBelow)
                        }

                        context.world.playSound(
                            player,
                            positionClicked,
                            ModSounds.DOWSING_ROD_FOUND_ORE,
                            SoundCategory.BLOCKS,
                            1f,
                            1f
                        )

                        break
                    }
                }

                if (!foundBlock) {
                    player.sendMessage(TranslatableText("item.tutorialmod.dowsing_rod.no_valuables"), false)
                }

            }
        }

        context.stack.damage(1, context.player) { plyr ->
            plyr?.sendToolBreakStatus(plyr.activeHand)
        }

        return super.useOnBlock(context)
    }

    private fun addNbtToDataTablet(player: PlayerEntity, pos: BlockPos, blockBelow: Block) {
        val dataTablet = player.inventory.getStack(player.getFirstInventoryIndex(ModItems.DATA_TABLET))

        val nbtData = NbtCompound()
        nbtData.putString(
            "tutorialmod.last_ore",
            "Found ${blockBelow.asItem().name.string} at (${pos.x}, ${pos.y}, ${pos.z})"
        )

        dataTablet.nbt = nbtData
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        if (Screen.hasShiftDown()) {
            tooltip.add(TranslatableText("item.tutorialmod.dowsing_rod.tooltip.shift"))
        } else {
            tooltip.add(TranslatableText("item.tutorialmod.dowsing_rod.tooltip"))
        }
    }

    private fun outputValuableCoordinates(blockPos: BlockPos, player: PlayerEntity, blockBelow: Block) {
        player.sendMessage(
            LiteralText("Found ${blockBelow.asItem().name.string} at (${blockPos.x}, ${blockPos.y}, ${blockPos.z})"),
            false
        )
    }

    private fun isValuableBlock(block: Block): Boolean =
        Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(block).get())
            .isIn(ModTags.Blocks.DOWSING_ROD_DETECTABLE_BLOCKS)
}