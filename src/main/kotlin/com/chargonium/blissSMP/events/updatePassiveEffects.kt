package com.chargonium.blissSMP.events

import com.chargonium.blissSMP.Utils
import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scheduler.BukkitRunnable

class updatePassiveEffects : BukkitRunnable() {
    override fun run() {
        for (player in Bukkit.getOnlinePlayers()) {
            processPlayer(player)
        }
    }

    private fun processPlayer(player: Player) {

        val gem: ItemStack? = Utils().getItem(player, gems.gemItem)
        if (gem == null) return;
        val modelData = Utils().getCustomModelData(gem)
        when (modelData) {
            gems.speed[0] -> {
                val gemInstance: gem = gems.speed[1] as gem
                gemInstance.passiveEffect(player)
            }
        }
    }
}