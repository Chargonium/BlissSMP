package com.chargonium.blissSMP.events

import com.chargonium.blissSMP.BlissSMP.Companion.plugin
import org.bukkit.Location
import org.bukkit.NamespacedKey
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.persistence.PersistentDataType

class rightclick : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player

        // Check if the action is a right-click (either air or block)
        when (event.action) {
            Action.RIGHT_CLICK_BLOCK, Action.RIGHT_CLICK_AIR -> {
                // Run your code when a player right-clicks
                val itemInMainHand = player.inventory.itemInMainHand

                // Check if the item has meta and is not air
                val itemMeta = itemInMainHand.itemMeta ?: return

                // Retrieve the NBT data from the item
                val key = NamespacedKey(plugin, "gem")
                val nbtData = itemMeta.persistentDataContainer.get(key, PersistentDataType.STRING)
                if (nbtData != null) {
                    // Perform actions based on the NBT value using a switch-like when statement
                    when (nbtData) {
                        "lightning" -> {
                            val targetBlock = player.getTargetBlockExact(100) // Look for a block within 100 blocks

                            if (targetBlock != null) {
                                val blockLocation: Location = targetBlock.location
                                player.world.strikeLightning(blockLocation)
                            }
                        }
                    }
                }
            }
            else -> {
                // Do nothing for other actions
            }
        }
    }
}