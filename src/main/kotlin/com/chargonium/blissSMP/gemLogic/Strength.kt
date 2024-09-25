package com.chargonium.blissSMP.gemLogic

import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class Strength : gem {
    override fun give(player: Player): Boolean {
        val gem = ItemStack(gems.gemItem)
        val itemMeta = gem.itemMeta

        itemMeta?.setCustomModelData(gems.strength[0] as Int?)
        itemMeta?.displayName(Component.text("Strength Gem").decoration(TextDecoration.ITALIC, false))
        gem.itemMeta = itemMeta

        player.inventory.addItem(gem)
        return true
    }

    override fun passiveEffect(player: Player) {
        player.addPotionEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE, 6, 1, true))
    }

    override fun onLeftClick(player: Player) {
        TODO("Not yet implemented")
    }

    override fun onRightClick(player: Player) {
        TODO("Not yet implemented")
    }

    override fun onPlayerMove(player: Player) {
        TODO("Not yet implemented")
    }
}