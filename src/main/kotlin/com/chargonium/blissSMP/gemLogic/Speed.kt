package com.chargonium.blissSMP.gemLogic

import com.chargonium.blissSMP.BlissSMP.Companion.plugin
import com.chargonium.blissSMP.Utils
import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class Speed() : gem {
    private val cooldowns: BooleanArray = booleanArrayOf(true, true)
    override fun give(player: Player): Boolean {
        val gem = ItemStack(gems.gemItem)
        val itemMeta = gem.itemMeta

        itemMeta?.setCustomModelData(gems.speed[0] as Int?)
        itemMeta?.displayName(Component.text("Speed Gem").decoration(TextDecoration.ITALIC, false))
        gem.itemMeta = itemMeta

        player.inventory.addItem(gem)
        return true
    }

    override fun passiveEffect(player: Player) {
        player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 6, 2, true))
        player.addPotionEffect(PotionEffect(PotionEffectType.DOLPHINS_GRACE, 6, 0, true))

        for (item in Utils().getToolsWithoutEfficiencyV(player)) {
            val itemMeta = item.itemMeta
            itemMeta.addEnchant(Enchantment.DIG_SPEED, 5, true)
            item.itemMeta = itemMeta
        }
    }

    override fun onLeftClick(player: Player) {
        if (cooldowns[0]) {
            val targetEntity = player.getTargetEntity(5) // Check within 5 blocks
            if (targetEntity != null && targetEntity is Player) {
                cooldowns[0] = false
                Bukkit.getScheduler().runTaskLater(plugin, Runnable { cooldowns[0] = true }, 20*40)
                targetEntity.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 20 * 30, 1)) // Slow for 5 seconds
                targetEntity.addPotionEffect(
                    PotionEffect(
                        PotionEffectType.SLOW_DIGGING,
                        20 * 30,
                        2
                    )
                )
                targetEntity.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 1, 0))
            }
        }
    }

    override fun onRightClick(player: Player) {
        if (cooldowns[1]) {
            val targetEntity = player.getTargetEntity(5) // Check within 5 blocks
            if (targetEntity != null && targetEntity is Player) {
                cooldowns[1] = false
                Bukkit.getScheduler().runTaskLater(plugin, Runnable { cooldowns[1] = true }, 20*60)
                targetEntity.addPotionEffect(PotionEffect(PotionEffectType.SLOW, 20 * 40, 1)) // Slow for 5 seconds
                targetEntity.addPotionEffect(
                    PotionEffect(
                        PotionEffectType.SLOW_DIGGING,
                        20 * 40,
                        2
                    )
                )
                targetEntity.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 1, 0))
            }
        }
    }

    override fun onPlayerMove(player: Player) {
        val blockUnderPlayer = player.location.subtract(0.0, 1.0, 0.0).block
        if (blockUnderPlayer.type == Material.SOUL_SAND || blockUnderPlayer.type == Material.SOUL_SOIL) { player.walkSpeed = 0.2f } else { player.walkSpeed = 0.2f }
    }
}