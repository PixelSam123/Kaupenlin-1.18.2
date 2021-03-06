package net.kaupenjoe.tutorialmod.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.kaupenjoe.tutorialmod.TutorialMod
import net.kaupenjoe.tutorialmod.block.ModBlocks
import net.kaupenjoe.tutorialmod.item.custom.*
import net.kaupenjoe.tutorialmod.sound.ModSounds
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.AliasedBlockItem
import net.minecraft.item.ArmorItem
import net.minecraft.item.BowItem
import net.minecraft.item.Item
import net.minecraft.item.ShovelItem
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModItems {
    val MYTHRIL_INGOT = registerItem(
        "mythril_ingot",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val MYTHRIL_NUGGET = registerItem(
        "mythril_nugget",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val RAW_MYTHRIL = registerItem(
        "raw_mythril",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val DOWSING_ROD = registerItem(
        "dowsing_rod",
        DowsingRodItem(FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(16))
    )

    val LILAC_FLOWER_BULB = registerItem(
        "lilac_flower_bulb",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val GRAPE = registerItem(
        "grape",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE))
    )

    val MYTHRIL_SWORD = registerItem(
        "mythril_sword",
        ModSlownessSwordItem(
            ModToolMaterials.MYTHRIL, 1, 2f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_AXE = registerItem(
        "mythril_axe",
        ModAxeItem(
            ModToolMaterials.MYTHRIL, 3f, 1f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_HOE = registerItem(
        "mythril_hoe",
        ModHoeItem(
            ModToolMaterials.MYTHRIL, 0, 0f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_SHOVEL = registerItem(
        "mythril_shovel",
        ShovelItem(
            ModToolMaterials.MYTHRIL, 0f, 1f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_PICKAXE = registerItem(
        "mythril_pickaxe",
        ModPickaxeItem(
            ModToolMaterials.MYTHRIL, 1, 0f,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )

    val MYTHRIL_HELMET = registerItem(
        "mythril_helmet",
        ModArmorItem(
            ModArmorMaterials.MYTHRIL, EquipmentSlot.HEAD,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_CHESTPLATE = registerItem(
        "mythril_chestplate",
        ArmorItem(
            ModArmorMaterials.MYTHRIL, EquipmentSlot.CHEST,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_LEGGINGS = registerItem(
        "mythril_leggings",
        ArmorItem(
            ModArmorMaterials.MYTHRIL, EquipmentSlot.LEGS,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )
    val MYTHRIL_BOOTS = registerItem(
        "mythril_boots",
        ArmorItem(
            ModArmorMaterials.MYTHRIL, EquipmentSlot.FEET,
            FabricItemSettings().group(ModItemGroup.MYTHRIL)
        )
    )

    val MAGIC_MYTHRIL_DUST = registerItem(
        "magic_mythril_dust",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val DATA_TABLET = registerItem(
        "data_tablet",
        DataTabletItem(FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1))
    )

    val GRAPE_SEEDS = registerItem(
        "grape_seeds",
        AliasedBlockItem(ModBlocks.GRAPE_VINE, FabricItemSettings().group(ModItemGroup.MYTHRIL))
    )

    val KAUPENBOW = registerItem(
        "kaupenbow",
        BowItem(FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(640))
    )

    val BAR_BRAWL_MUSIC_DISC = registerItem(
        "bar_brawl_music_disc",
        ModMusicDiscItem(
            7,
            ModSounds.BAR_BRAWL,
            FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1)
        )
    )

    val MYTHRIL_STAFF = registerItem(
        "mythril_staff",
        Item(FabricItemSettings().group(ModItemGroup.MYTHRIL).maxCount(1))
    )

    private fun registerItem(name: String, item: Item): Item =
        Registry.register(Registry.ITEM, Identifier(TutorialMod.MOD_ID, name), item)

    fun registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for ${TutorialMod.MOD_ID}")
    }
}