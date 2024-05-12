package com.pandapulsestudios.pacificsmp.PulseConfigs.Static;

import com.pandapulsestudios.pacificsmp.Enum.Static.Permission;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulseconfig.Objects.SaveableHashmap;
import com.pandapulsestudios.pulsecore.ChatAPI.Enum.MessageType;
import com.pandapulsestudios.pulsecore.ChatAPI.Object.ChatBuilderAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class Permissions implements PulseConfig {
    public static Permissions ReturnStatic(){
        var stored = StorageAPI.ReturnStatic(Permissions.class, StorageType.CONFIG, false);
        return stored == null ? new Permissions() : (Permissions) stored;
    }

    @Override
    public JavaPlugin mainClass() {return PacificSMP.GetInstance();}

    @Override
    public void FirstLoadConfig() {
        for(var permission : Permission.values()){
            if(!permissions.containsKey(permission)) permissions.put(permission, permission.permission);
        }
    }

    @Override
    public void AfterLoadConfig() {
        for(var permission : Permission.values()){
            if(!permissions.containsKey(permission)) permissions.put(permission, permission.permission);
        }
        StorageAPI.Save(this, debugConfig);
    }

    @Override
    public void BeforeSaveConfig() {
        for(var permission : Permission.values()){
            if(!permissions.containsKey(permission)) permissions.put(permission, permission.permission);
        }
    }

    @StorageComment("Stored Permissions!")
    public SaveableHashmap<Permission, String> permissions = new SaveableHashmap<>(Permission.class, String.class);
    @StorageComment("Display debugs in the console logs for changes in this config!")
    public boolean debugConfig = false;
    @StorageComment("Do you send player error message if doesn't have permission?")
    public boolean sendPlayerErrorMessage = true;


    public boolean DoesPlayerHavePermission(Permission permission, Player player, boolean sendError){
        if(permission == null || player == null) return false;
        var storedPermission = permissions.getOrDefault(permission, permission.permission);
        var permissionState = player.hasPermission(storedPermission);
        if(!permissionState && sendError && sendPlayerErrorMessage) ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(player).SendMessage(permission.error, true);
        return permissionState;
    }
}
