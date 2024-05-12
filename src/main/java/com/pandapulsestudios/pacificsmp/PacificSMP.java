package com.pandapulsestudios.pacificsmp;

import com.pandapulsestudios.pacificsmp.PulseConfigs.Normal.PlayerData;
import com.pandapulsestudios.pacificsmp.VariableTest.CustomItemVariableTest;
import com.pandapulsestudios.pacificsmp.VariableTest.MessageVariableTest;
import com.pandapulsestudios.pacificsmp.VariableTest.PermissionVariableTest;
import com.pandapulsestudios.pulsecommands.PulseCommands;
import com.pandapulsestudios.pulseconfig.API.ConfigAPI;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulsecore.ChatAPI.Object.ChatBuilderAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.API.ClassAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class PacificSMP extends JavaPlugin {
    private static PacificSMP Instance;
    public static PacificSMP GetInstance(){return Instance;}
    private static HashMap<UUID, PlayerData> playerData = new HashMap<>();

    public static PlayerData ReturnPlayerData(Player player){
        return playerData.getOrDefault(player.getUniqueId(), new PlayerData(player.getUniqueId().toString()));
    }

    public static void SavePlayerData(Player player, PlayerData playerData){
        playerData.SaveConfig(false);
        PacificSMP.playerData.put(player.getUniqueId(), playerData);
    }

    @Override
    public void onEnable() {
        Instance = this;
        ClassAPI.RegisterPulseVariableTest(new MessageVariableTest());
        ClassAPI.RegisterPulseVariableTest(new PermissionVariableTest());
        ClassAPI.RegisterPulseVariableTest(new CustomItemVariableTest());
        StorageAPI.RegisterStatic(this, false);
        ClassAPI.RegisterClasses(this);
        PulseCommands.RegisterRaw(this);
        playerData = ReturnAllPlayerData();
    }

    private HashMap<UUID, PlayerData> ReturnAllPlayerData(){
        var hashmap = new HashMap<UUID, PlayerData>();
        var returnedData = ConfigAPI.ReturnAllConfigDocuments(new PlayerData(""), false);
        for(var key : returnedData.keySet()){
            var config = (PlayerData) returnedData.get(key);
            hashmap.put(UUID.fromString(key), config);
        }
        ChatBuilderAPI.chatBuilder().SendMessage(String.format("#88f78aRegistered %d player data!", hashmap.size()), true);
        return hashmap;
    }
}
