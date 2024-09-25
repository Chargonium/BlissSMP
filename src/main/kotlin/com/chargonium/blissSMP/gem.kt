package com.chargonium.blissSMP

import org.bukkit.entity.Player

interface gem {
    fun give(player: Player): Boolean
    fun passiveEffect(player: Player)
    fun onLeftClick(player: Player)
    fun onRightClick(player: Player)
    fun onPlayerMove(player: Player)
}