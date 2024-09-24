package com.chargonium.blissSMP.commands

import com.chargonium.blissSMP.BlissSMP.Companion.plugin
import com.chargonium.blissSMP.BlissUtils
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType


class testItem : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player) {
            val utils = BlissUtils()
            val player = sender

            val diamond = ItemStack(Material.DIAMOND)
            val itemMeta = diamond.itemMeta

            // Use the PersistentDataContainer to store custom data
            val key = NamespacedKey(plugin, "gem")
            plugin.logger.info("[BlissSMP] "+utils.generateCustomModelData("com.chargonium.BlissSMP.lightningGem").toString())
            itemMeta?.persistentDataContainer?.set(key, PersistentDataType.STRING, "lightning")
            itemMeta?.setCustomModelData(utils.generateCustomModelData("com.chargonium.BlissSMP.lightningGem"))

            // Set the modified meta back to the item
            diamond.itemMeta = itemMeta

            // Give the player the item
            player.inventory.addItem(diamond)
        }
        return true;
    }
}