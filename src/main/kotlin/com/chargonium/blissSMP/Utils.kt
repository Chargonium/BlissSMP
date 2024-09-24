package com.chargonium.blissSMP

import org.bukkit.Material
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
}