package com.example.betterteams;

import com.booksaw.betterTeams.extension.BetterTeamsExtension;

public class MyFirstExtension extends BetterTeamsExtension {

    @Override
    public void onLoad() {
        getLogger().info("PvP Restriction Extension loading...");
    }

    @Override
    public void onEnable() {
        // Register the listener using the Main BetterTeams plugin instance
        // We use 'Main.plugin' because BetterTeamsExtension is not a JavaPlugin itself
        getPlugin().getServer().getPluginManager().registerEvents(new PvPListener(), getPlugin());

        getLogger().info("PvP Restriction Extension has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PvP Restriction Extension disabled!");
    }
}