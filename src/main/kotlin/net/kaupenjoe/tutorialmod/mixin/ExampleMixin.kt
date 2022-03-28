package net.kaupenjoe.tutorialmod.mixin

import net.kaupenjoe.tutorialmod.TutorialMod
import net.minecraft.client.gui.screen.TitleScreen
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(TitleScreen::class)
class ExampleMixin {
    @Inject(at = [At("HEAD")], method = ["init()V"])
    private fun init(info: CallbackInfo) {
        TutorialMod.LOGGER.info("This line is printed by an example mod mixin!")
    }
}