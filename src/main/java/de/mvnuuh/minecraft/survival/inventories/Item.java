package de.mvnuuh.minecraft.survival.inventories;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Item extends ItemStack {
    protected ItemMeta meta;
    public Item(String name, Material m, int amount){
        super(m, amount);
        meta = getItemMeta();
        meta.setDisplayName(name);
        setItemMeta(meta);
    }
    public void addMeta(List lore){
        meta.setLore(lore);
        setItemMeta(meta);
    }
    public String getName(){return getType().toString();}
}
