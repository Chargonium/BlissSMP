package com.chargonium.blissSMP.commands

import com.chargonium.blissSMP.gem
import com.chargonium.blissSMP.gems
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class testItem : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender is Player) {
            var gemInstance =  gems.speed[1] as gem
            gemInstance.give(sender)
            return true;
        }
        return false;
    }
}