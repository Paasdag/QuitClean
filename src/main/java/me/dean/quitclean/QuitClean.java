package me.dean.quitclean;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuitClean extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Quit Clean Enabled");
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public boolean onQuitEvent(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        PlayerInventory plrinv = p.getInventory();
        System.out.println("Check 1");
        if (getConfig().getBoolean("CleanOnQuit"))
            if (!p.hasPermission("QuitClean.bypass")) {
                System.out.println("check 2");
                plrinv.clear();
                plrinv.setArmorContents(new ItemStack[]{(ItemStack) null});
            }
        return false;
    }


    @Override
    public void onDisable() {
        System.out.println("Quit clean Disabled");
    }
}
