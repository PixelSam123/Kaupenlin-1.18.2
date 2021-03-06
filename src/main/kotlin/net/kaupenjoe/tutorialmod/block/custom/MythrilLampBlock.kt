package net.kaupenjoe.tutorialmod.block.custom

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class MythrilLampBlock(settings: Settings) : Block(settings) {
    companion object {
        val CLICKED = BooleanProperty.of("clicked")
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient && hand == Hand.MAIN_HAND) {
            val currentState = state.get(CLICKED)
            world.setBlockState(pos, state.with(CLICKED, !currentState), NOTIFY_ALL)
        }

        return ActionResult.SUCCESS
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(CLICKED)
    }
}