package com.chargonium.blissSMP.gemLogic

import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Speed : gem {
    override fun give(player: Player): Boolean {
        val gem = ItemStack(Material.CLAY_BALL)
        val itemMeta = gem.itemMeta

        itemMeta?.setCustomModelData(gems.speed[0] as Int?)
        gem.itemMeta = itemMeta

        player.inventory.addItem(gem)
        return true
    }

    override fun passiveEffect(player: Player) {
        TODO("Not yet implemented")
    }

    override fun onLeftClick(player: Player) {
        TODO("Not yet implemented")
    }

    override fun onRightClick(player: Player) {
        TODO("Not yet implemented")
    }
}