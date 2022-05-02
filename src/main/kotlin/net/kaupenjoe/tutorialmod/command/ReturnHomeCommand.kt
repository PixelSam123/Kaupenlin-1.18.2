package net.kaupenjoe.tutorialmod.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.kaupenjoe.tutorialmod.util.IEntityDataSaver
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.LiteralText

object ReturnHomeCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>, dedicated: Boolean) {
        dispatcher.register(
            CommandManager.literal("home").then(
                CommandManager.literal("return").executes(::run)
            )
        )
    }

    private fun run(context: CommandContext<ServerCommandSource>): Int {
        val player = context.source.player as IEntityDataSaver

        // not 0 means it contains SOMETHING
        val homePos = player.persistentData.getIntArray("homepos").map { it.toDouble() }

        return if (homePos.isNotEmpty()) {
            context.source.player.requestTeleport(homePos[0], homePos[1], homePos[2])

            context.source.sendFeedback(LiteralText("Player returned Home!"), true)
            1
        } else {
            context.source.sendFeedback(LiteralText("No Home Position has been Set!"), true)
            -1
        }
    }
}