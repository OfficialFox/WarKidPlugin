package nl.officialfox.zalm;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ZalmListener implements Listener {
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();

        if (damaged instanceof Player && damager instanceof Item) {
            ItemStack item = ((Item) damager).getItemStack();

            if (item.getType() == Material.COOKED_FISH) {
                Location playerLoc = damaged.getLocation();
                Location creeperLoc = playerLoc.clone().add(0, 0, -5);
                Creeper creeper = (Creeper) damaged.getWorld().spawnEntity(creeperLoc, EntityType.CREEPER);
                creeper.setTarget((LivingEntity) damaged);
            }
        }
    }
}