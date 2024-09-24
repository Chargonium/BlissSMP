package com.chargonium.blissSMP

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
}