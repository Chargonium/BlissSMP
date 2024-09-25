package com.chargonium.blissSMP

import com.chargonium.blissSMP.gemLogic.Speed
import com.chargonium.blissSMP.gemLogic.Strength
import org.bukkit.Material

class gems {
    companion object {
        val gemItem: Material = Material.CLAY_BALL
        var all: Array<Array<Any?>?> =  arrayOfNulls(2)
        var speed: Array<Any?> = arrayOfNulls(2)
        var strength: Array<Any?> = arrayOfNulls(2)
    }

    fun initGems() {
        speed[0] = Utils().generateCustomModelData("com.chargonium.BlissSMP.gems.speed")
        speed[1] = Speed()

        strength[0] = Utils().generateCustomModelData("com.chargonium.BlissSMP.gems.strength")
        strength[1] = Strength()

        all[0] = speed
        all[1] = strength
    }
}