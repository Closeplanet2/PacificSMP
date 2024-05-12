package com.pandapulsestudios.pacificsmp.API;

import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.Events.Custom.PlayerAddDolphinEvent;
import com.pandapulsestudios.pacificsmp.Events.Custom.ReloadConfigEvent;
import com.pandapulsestudios.pacificsmp.Events.Custom.ResetConfigEvent;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Messages;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.PacificSMPPlugin;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import org.bukkit.entity.Player;

public class PacificSMPAPI {
    public static void EnableSystem(boolean state){
        PacificSMPPlugin.ReturnStatic().ToggleSystemEnabled(state);
    }

    public static void SetMaximumDolphins(int amount){
        PacificSMPPlugin.ReturnStatic().SetMaximumDolphins(amount);
    }

    public static void GivePlayerDolphin(Player player, CustomItem customItem){
        var playerAddDolphin = new PlayerAddDolphinEvent(customItem, player);
        if(playerAddDolphin.isCancelled()) return;

        var playerData = PacificSMP.ReturnPlayerData(player);
        playerData.AddDolphin(player, customItem);
        PacificSMP.SavePlayerData(player, playerData);
    }

    public static void ClearPlayerDolphin(Player player){
        var playerData = PacificSMP.ReturnPlayerData(player);
        playerData.dolphins.clear();
        PacificSMP.SavePlayerData(player, playerData);
    }

    public static void ResetConfigs(){
        StorageAPI.ResetStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ResetStatic(PacificSMPPlugin.class, StorageType.CONFIG, false, PacificSMPPlugin.ReturnStatic().debugConfig);
        new ResetConfigEvent();
    }

    public static void ReloadConfigs(){
        StorageAPI.ReloadStatic(Messages.class, StorageType.CONFIG, false, Messages.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(Permissions.class, StorageType.CONFIG, false, Permissions.ReturnStatic().debugConfig);
        StorageAPI.ReloadStatic(PacificSMPPlugin.class, StorageType.CONFIG, false, PacificSMPPlugin.ReturnStatic().debugConfig);
        new ReloadConfigEvent();
    }
}
