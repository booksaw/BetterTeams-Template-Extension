package com.example.betterteams;

import com.booksaw.betterTeams.Team;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PvPListener implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        // 1. Check if both the Victim and the Attacker are players
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
            return;
        }

        Player victim = (Player) event.getEntity();
        Player attacker = (Player) event.getDamager();

        // 2. Get the teams for both players
        Team victimTeam = Team.getTeam(victim);
        Team attackerTeam = Team.getTeam(attacker);

        // 3. Logic: If either player is NOT in a team (team is null), cancel the attack
        if (victimTeam == null || attackerTeam == null) {
            event.setCancelled(true);
            attacker.sendMessage(ChatColor.RED + "PvP is disabled because one of you is not in a team!");
        }
    }
}
