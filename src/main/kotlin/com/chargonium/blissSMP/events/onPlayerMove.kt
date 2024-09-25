package com.chargonium.blissSMP.events

import com.chargonium.blissSMP.Utils
import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.inventory.ItemStack

class onPlayerMove : Listener{
    @EventHandler
    fun onPlayerMove(event: PlayerMoveEvent) {
        val player = event.player
        val gem: ItemStack? = Utils().getItem(player, gems.gemItem)
        if (gem == null) return;
        val modelData = Utils().getCustomModelData(gem)
        when (modelData) {
            gems.speed[0] -> {
                val gemInstance: gem = gems.speed[1] as gem
                gemInstance.onPlayerMove(player)
            }
        }
    }
}