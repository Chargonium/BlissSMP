package com.chargonium.blissSMP.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class getModelData : CommandExecutor {
    override fun onCommand(sender: CommandSender, p1: Command, p2: String, p3: Array<out String>?): Boolean {
        if (sender is Player) {
            val player = sender
            val itemInMainHand = player.inventory.itemInMainHand

            // Check if the item has meta and is not air
            val itemMeta = itemInMainHand.itemMeta ?: return false;

            player.sendMessage(itemMeta.customModelData.toString())
        }
        return true
    }
}