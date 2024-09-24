package com.chargonium.blissSMP

import com.chargonium.blissSMP.gemLogic.Speed

class gems {
    companion object {
        var all: Array<Array<Any?>?> =  arrayOfNulls(1)
        var speed: Array<Any?> = arrayOfNulls(2)
    }

    fun initGems() {
        speed[0] = Utils().generateCustomModelData("com.chargonium.BlissSMP.gems.speed")
        speed[1] = Speed()

        all[0] = speed
    }
}