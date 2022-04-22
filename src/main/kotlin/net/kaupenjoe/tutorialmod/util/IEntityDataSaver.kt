package net.kaupenjoe.tutorialmod.util

import net.minecraft.nbt.NbtCompound

interface IEntityDataSaver {
    fun getPersistentData(): NbtCompound
}