package net.kaupenjoe.tutorialmod.mixin

import net.kaupenjoe.tutorialmod.util.IEntityDataSaver
import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

@Mixin(Entity::class)
abstract class ModEntityDataSaver : IEntityDataSaver {
    private var persistentData: NbtCompound? = null

    @Inject(method = ["writeNbt"], at = [At("HEAD")])
    fun injectWriteMethod(nbt: NbtCompound, info: CallbackInfoReturnable<NbtCompound>) {
        if (persistentData != null) {
            nbt.put("tutorialmod.kaupen_data", persistentData)
        }
    }

    @Inject(method = ["readNbt"], at = [At("HEAD")])
    fun injectReadMethod(nbt: NbtCompound, info: CallbackInfo) {
        if (nbt.contains("tutorialmod.kaupen_data", 10)) {
            persistentData = nbt.getCompound("tutorialmod.kaupen_data")
        }
    }

    override fun getPersistentData(): NbtCompound {
        if (persistentData == null) {
            persistentData = NbtCompound()
        }

        return persistentData as NbtCompound
    }
}