package com.chargonium.blissSMP.events

import com.chargonium.blissSMP.Utils
import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

class onPlayerInteract : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player

        // Check if the action is a right-click (either air or block)
        val modelData = Utils().getCustomModelData(player)

        when (modelData) {
            gems.speed[0] -> {
                val gemInstance = gems.speed[1] as gem
                when (event.action) {
                    Action.RIGHT_CLICK_BLOCK, Action.RIGHT_CLICK_AIR -> { gemInstance.onRightClick(player) }
                    Action.LEFT_CLICK_BLOCK, Action.LEFT_CLICK_AIR -> { gemInstance.onLeftClick(player) }
                    else -> {}
                }
            }
        }
    }
}