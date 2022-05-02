package net.kaupenjoe.tutorialmod.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.kaupenjoe.tutorialmod.util.IEntityDataSaver
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.LiteralText

object SetHomeCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
        dispatcher.register(
            CommandManager.literal("home").then(
                CommandManager.literal("set").executes(::run)
            )
        )
    }

    private fun run(context: CommandContext<ServerCommandSource>): Int {
        val player = context.source.player as IEntityDataSaver

        val playerPos = context.source.player.blockPos
        val pos = "(${playerPos.x}, ${playerPos.y}, ${playerPos.z})"

        player.persistentData.putIntArray("homepos", intArrayOf(playerPos.x, playerPos.y, playerPos.z))

        context.source.sendFeedback(LiteralText("Set home at $pos"), true)
        return 1
    }
}