package de.mvnuuh.minecraft.survival.listener;

import de.mvnuuh.minecraft.survival.entities.ShopVillager;
import de.mvnuuh.minecraft.survival.inventories.Item;
import de.mvnuuh.minecraft.survival.inventories.ShopInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ShopHandler implements Listener {

    @EventHandler
    public void onVillagerInteract(PlayerInteractEntityEvent event){
        if(!(event.getRightClicked() instanceof Villager)) return;
        Villager villager = (Villager) event.getRightClicked();
        if(villager.getCustomName() == null)return;
        if(villager.getCustomName().equals(ShopVillager.customName)){
            event.setCancelled(true);
            ShopInventory inv = new ShopInventory(new Item("",Material.EMERALD,64),1);
            event.getPlayer().openInventory(inv.getInventory());
        }
    }
    @EventHandler
    public void onClickInventory(InventoryClickEvent event){
        if(event.getClickedInventory() == null) return;
        if(event.getClickedInventory().getHolder() instanceof ShopInventory) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            ShopInventory shop = ((ShopInventory) event.getClickedInventory().getHolder());
            switch (event.getCurrentItem().getType()){
                case NAME_TAG:
                    for(ItemStack item : player.getInventory().getContents()){
                        if(item.getType().equals(Material.EMERALD)){
                            if(item.getAmount() >=1){
                                player.getInventory().remove(new ItemStack(Material.EMERALD, 1));
                                player.sendMessage("§eDu hast §6"+shop.getShopItem().getName()+"§e gekauft.");
                                player.getInventory().addItem(shop.getShopItem());
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                    player.sendMessage("§cNicht genug Geld.");
                    break;
                default:
                    break;
            }

        }
    }

}
