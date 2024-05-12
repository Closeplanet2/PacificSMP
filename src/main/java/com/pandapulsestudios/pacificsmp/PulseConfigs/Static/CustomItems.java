package com.pandapulsestudios.pacificsmp.PulseConfigs.Static;

import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.Enum.Static.Permission;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulseconfig.Objects.SaveableHashmap;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class CustomItems implements PulseConfig {
    public static CustomItems ReturnStatic(){
        var stored = StorageAPI.ReturnStatic(CustomItems.class, StorageType.CONFIG, false);
        return stored == null ? new CustomItems() : (CustomItems) stored;
    }

    @Override
    public JavaPlugin mainClass() {return PacificSMP.GetInstance();}

    @Override
    public void FirstLoadConfig() {
        for(var customItem : CustomItem.values()){
            if(!customItems.containsKey(customItem)) customItems.put(customItem, customItem.ReturnItemStack(1));
        }
    }

    @Override
    public void AfterLoadConfig() {
        for(var customItem : CustomItem.values()){
            if(!customItems.containsKey(customItem)) customItems.put(customItem, customItem.ReturnItemStack(1));
        }
        StorageAPI.Save(this, debugConfig);
    }

    @Override
    public void BeforeSaveConfig() {
        for(var customItem : CustomItem.values()){
            if(!customItems.containsKey(customItem)) customItems.put(customItem, customItem.ReturnItemStack(1));
        }
    }

    @StorageComment("Stored customItems!")
    public SaveableHashmap<CustomItem, ItemStack> customItems = new SaveableHashmap<>(CustomItem.class, ItemStack.class);
    @StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;

    public ItemStack ReturnItemStack(CustomItem customItem, int amount){
        var itemStack = customItems.getOrDefault(customItem, customItem.ReturnItemStack(amount));
        itemStack.setAmount(amount);
        return itemStack;
    }
}
