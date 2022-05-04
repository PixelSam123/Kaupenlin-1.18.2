package net.kaupenjoe.tutorialmod.world.gen

object ModWorldGen {
    fun generateModWorldGen() {
        ModFlowerGeneration.generateFlowers()
        ModTreeGeneration.generateTrees()
    }
}