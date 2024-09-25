package com.chargonium.blissSMP

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import java.security.MessageDigest

class Utils {
    fun generateCustomModelData(identifier: String): Int {
        val hash = MessageDigest.getInstance("SHA-256").digest(identifier.toByteArray())
        val hashString = hash.joinToString("") { String.format("%02x", it) }

        return hashString.substring(0, 6).toInt(16)
    }

    fun getCustomModelData(player: Player): Int? {
        val mainHandItem: ItemStack = player.inventory.itemInMainHand
        val itemMeta: ItemMeta? = mainHandItem.itemMeta

        if (itemMeta != null && itemMeta.hasCustomModelData()) {
            return itemMeta.customModelData
        }

        return null
    }

    fun getCustomModelData(item: ItemStack): Int? {
        val itemMeta: ItemMeta? = item.itemMeta

        if (itemMeta != null && itemMeta.hasCustomModelData()) {
            return itemMeta.customModelData
        }

        return null
    }
/*
* for (item in inventory.contents) {
            if (item != null && item.type == material && item.customModelData == customModelData) {
                return getNBTData(item)
            }
        }
*
* */
    fun getItem(player: Player, material: Material): ItemStack? {
        val inventory = player.inventory

        for (item in inventory.contents) {
            if (item != null && item.type == material) {
                return item;
            }
        }

        return null
    }

    fun getToolsWithoutEfficiencyV(player: Player): List<ItemStack> {
        val toolsWithEfficiencyV = mutableListOf<ItemStack>()
        val toolsThatCanBeEnchanted = listOf(
            Material.WOODEN_PICKAXE, Material.STONE_PICKAXE, Material.IRON_PICKAXE, Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE, Material.GOLDEN_PICKAXE,
            Material.WOODEN_AXE, Material.STONE_AXE, Material.IRON_AXE, Material.DIAMOND_AXE, Material.NETHERITE_AXE, Material.GOLDEN_AXE,
            Material.WOODEN_SHOVEL, Material.STONE_SHOVEL, Material.IRON_SHOVEL, Material.DIAMOND_SHOVEL, Material.NETHERITE_SHOVEL, Material.GOLDEN_SHOVEL,
            Material.WOODEN_HOE, Material.STONE_HOE, Material.IRON_HOE, Material.DIAMOND_HOE, Material.NETHERITE_HOE, Material.GOLDEN_HOE
        )

        for (item in player.inventory.contents) {
            if (item != null && toolsThatCanBeEnchanted.contains(item.type)) {
                val efficiencyLevel = item.getEnchantmentLevel(Enchantment.DIG_SPEED)
                if (efficiencyLevel < 5) {
                    toolsWithEfficiencyV.add(item)
                }
            }
        }

        return toolsWithEfficiencyV
    }
}