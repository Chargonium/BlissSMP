package com.chargonium.blissSMP

import com.chargonium.blissSMP.gemLogic.Speed
import org.bukkit.Material

class gems {
    companion object {
        val gemItem: Material = Material.CLAY_BALL
        var all: Array<Array<Any?>?> =  arrayOfNulls(1)
        var speed: Array<Any?> = arrayOfNulls(2)
    }

    fun initGems() {
        speed[0] = Utils().generateCustomModelData("com.chargonium.BlissSMP.gems.speed")
        speed[1] = Speed()

        all[0] = speed
    }
}