package net.kaupenjoe.tutorialmod.item.custom

import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.text.LiteralText
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.math.BlockPos

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
                        break
                    }
                }

                if (!foundBlock) {
                    player.sendMessage(TranslatableText("item.tutorialmod.dowsing_rod.no_valuables"), false)
                }

                context.stack.damage(1, player) {
                    plyr -> plyr.sendToolBreakStatus(player.activeHand)
                }
            }
        }

        return super.useOnBlock(context)
    }

    private fun outputValuableCoordinates(blockPos: BlockPos, player: PlayerEntity, blockBelow: Block) {
        player.sendMessage(
            LiteralText("Found ${blockBelow.asItem().name.string} at (${blockPos.x}, ${blockPos.y}, ${blockPos.z})"),
            false
        )
    }

    private fun isValuableBlock(block: Block): Boolean = when (block) {
        Blocks.COAL_ORE,
        Blocks.COPPER_ORE,
        Blocks.DIAMOND_ORE,
        Blocks.IRON_ORE -> true
        else -> false
    }
}