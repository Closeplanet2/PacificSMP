package com.pandapulsestudios.pacificsmp.Enum.Static;

import com.pandapulsestudios.pulsecore.ChatAPI.API.MessageAPI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public enum CustomItem {
    DarkDolphin("#242222Dark Dolphin", Material.BLUE_DYE, List.of("#242222Dark Dolphin"), 0, Permission.DARK_DOLPHIN),
    SpeedDolphin("#9aff63Speed Dolphin", Material.BLUE_DYE, List.of("#9aff63Speed Dolphin"), 0, Permission.SPEED_DOLPHIN),
    FlameDolphin("#fc4521Flame Dolphin",  Material.BLUE_DYE, List.of("#fc4521Flame Dolphin"), 0, Permission.FLAME_DOLPHIN),
    HealthyDolphin("#f7f748Healthy Dolphin", Material.BLUE_DYE, List.of("#f7f748Healthy Dolphin"), 0, Permission.HEALTHY_DOLPHIN),
    PowerDolphin("#6725f5Power Dolphin", Material.BLUE_DYE, List.of("#6725f5Power Dolphin"), 0, Permission.POWER_DOLPHIN);

    public final String dolphinName;
    public final Material itemMaterial;
    public final List<String> itemLore;
    public final int modelData;
    public final Permission interactItemPermission;

    CustomItem(String dolphinName, Material itemMaterial, List<String> itemLore, int modelData,  Permission interactItemPermission){
        this.dolphinName = dolphinName;
        this.itemMaterial = itemMaterial;
        this.itemLore = itemLore;
        this.modelData = modelData;
        this.interactItemPermission = interactItemPermission;
    }

    public ItemStack ReturnItemStack(int amount){
        var itemStack = new ItemStack(itemMaterial, amount);
        var itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            itemMeta.setDisplayName(MessageAPI.FormatMessage(dolphinName, true, true, null));
            var lore = new ArrayList<String>();
            for(var x : itemLore) lore.add(MessageAPI.FormatMessage(x, true, true, null));
            itemMeta.setLore(lore);
            itemMeta.setCustomModelData(modelData);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}
