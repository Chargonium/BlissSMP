package com.chargonium.blissSMP

import com.chargonium.blissSMP.commands.getModelData
import com.chargonium.blissSMP.commands.testItem
import com.chargonium.blissSMP.events.onPlayerInteract
import com.chargonium.blissSMP.events.onPlayerMove
import com.chargonium.blissSMP.events.updatePassiveEffects
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BlissSMP : JavaPlugin() {

    companion object {
        lateinit var plugin: BlissSMP
    }

    override fun onEnable() {
        plugin = this

        gems().initGems()

        updatePassiveEffects().runTaskTimer(this, 0, 5)
        this.getCommand("testItem")?.setExecutor(testItem());
        this.getCommand("getModelData")?.setExecutor(getModelData());
        server.pluginManager.registerEvents(onPlayerInteract(), this)
        server.pluginManager.registerEvents(onPlayerMove(), this)
        Bukkit.getLogger().info("[BlissSMP] Plugin Succesfully Loaded!");

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
