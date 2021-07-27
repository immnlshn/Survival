package de.mvnuuh.minecraft.survival.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.Collections;

public class ShopInventoryBuilder implements InventoryHolder {

    protected final Inventory inv;
    protected final Item placeholderItem = new Item("     ", Material.GRAY_STAINED_GLASS_PANE, 1);
    protected final Item buyItem = new Item("§b§lKaufen", Material.NAME_TAG, 1);
    protected final Item item;
    protected final int prize;


    public ShopInventoryBuilder(Item item, int prize){
        this.item = item;
        this.prize = prize;
        this.buyItem.addMeta(Collections.singletonList("§eLinksklick um das Item zu kaufen."));
        this.inv = Bukkit.createInventory(this, 27, "   §6§lSHOP   ");
        for (int i = 0; i<=8; i++) inv.setItem(i, this.placeholderItem);
        inv.setItem(9, this.placeholderItem);
        inv.setItem(10, this.item);
        inv.setItem(16, this.buyItem);
        inv.setItem(17, this.placeholderItem);
        for (int i = 18; i<=26; i++) inv.setItem(i, this.placeholderItem);
    }

    public Item getShopItem(){return item;}
    public int getPrize(){return prize;}

    @Override
    public Inventory getInventory() { return inv; }
}
