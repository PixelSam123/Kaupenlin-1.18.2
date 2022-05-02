package net.kaupenjoe.tutorialmod.event

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents
import net.kaupenjoe.tutorialmod.util.IEntityDataSaver
import net.minecraft.server.network.ServerPlayerEntity

class ModPlayerEventCopyFrom : ServerPlayerEvents.CopyFrom {
    override fun copyFromPlayer(oldPlayer: ServerPlayerEntity?, newPlayer: ServerPlayerEntity?, alive: Boolean) {
        val original = oldPlayer as IEntityDataSaver
        val player = newPlayer as IEntityDataSaver

        player.persistentData.putIntArray("homepos", original.persistentData.getIntArray("homepos"))
    }
}