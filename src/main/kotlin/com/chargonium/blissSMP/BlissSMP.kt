package com.chargonium.blissSMP

import com.chargonium.blissSMP.commands.getModelData
import com.chargonium.blissSMP.commands.testItem
import com.chargonium.blissSMP.events.onPlayerInteract
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class BlissSMP : JavaPlugin() {

    companion object {
        lateinit var plugin: BlissSMP
    }

    override fun onEnable() {
        plugin = this

        gems().initGems()


        this.getCommand("testItem")?.setExecutor(testItem());
        this.getCommand("getModelData")?.setExecutor(getModelData());
        Bukkit.getLogger().info("[BlissSMP] Plugin Succesfully Loaded!");
        server.pluginManager.registerEvents(onPlayerInteract(), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
