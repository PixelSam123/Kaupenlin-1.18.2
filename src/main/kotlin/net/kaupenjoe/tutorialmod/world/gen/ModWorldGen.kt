package net.kaupenjoe.tutorialmod.world.gen

object ModWorldGen {
    fun generateModWorldGen() {
        ModOreGeneration.generateOres()
        ModFlowerGeneration.generateFlowers()
        ModTreeGeneration.generateTrees()
    }
}