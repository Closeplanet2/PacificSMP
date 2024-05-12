package com.pandapulsestudios.pacificsmp.Events.Normal;

import com.pandapulsestudios.pacificsmp.API.PacificSMPAPI;
import com.pandapulsestudios.pacificsmp.Enum.Normal.NBTTags;
import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.CustomItems;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.PacificSMPPlugin;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.API.NBTAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.persistence.PersistentDataType;

@PulseAutoRegister
public class PlayerInteractItem implements Listener {
    private static final NBTTags NBT_TAGS = NBTTags.DolphinTypeKey;
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event){
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;

        var eventAction = event.getAction();
        if(eventAction == Action.LEFT_CLICK_AIR || eventAction == Action.LEFT_CLICK_BLOCK || event.getHand() != EquipmentSlot.HAND) return;

        var player = event.getPlayer();
        var itemMainHand = player.getInventory().getItemInMainHand();

        if(!NBTAPI.Has(PacificSMP.GetInstance(), itemMainHand, PersistentDataType.STRING, NBT_TAGS.tag)) return;
        var nbtTag = (String) NBTAPI.Get(PacificSMP.GetInstance(), itemMainHand, NBT_TAGS.tag, PersistentDataType.STRING);
        var dolphin = CustomItem.valueOf(nbtTag);
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(dolphin.interactItemPermission, player, true)) return;

        PacificSMPAPI.GivePlayerDolphin(player, dolphin);
        player.getInventory().removeItem(itemMainHand);
        event.setCancelled(true);
    }
}
