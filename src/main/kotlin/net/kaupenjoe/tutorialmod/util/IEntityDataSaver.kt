package net.kaupenjoe.tutorialmod.util

import net.minecraft.nbt.NbtCompound

interface IEntityDataSaver {
    var persistentData: NbtCompound
}