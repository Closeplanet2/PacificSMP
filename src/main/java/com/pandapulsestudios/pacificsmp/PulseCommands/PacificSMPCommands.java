package com.pandapulsestudios.pacificsmp.PulseCommands;

import com.pandapulsestudios.api.Enum.TabType;
import com.pandapulsestudios.api.Interface.*;
import com.pandapulsestudios.pacificsmp.API.PacificSMPAPI;
import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.Enum.Static.Message;
import com.pandapulsestudios.pacificsmp.Enum.Static.Permission;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Messages;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.PacificSMPPlugin;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Permissions;
import com.pandapulsestudios.pulsecommands.PlayerCommand;
import com.pandapulsestudios.pulsecore.ChatAPI.Enum.MessageType;
import com.pandapulsestudios.pulsecore.ChatAPI.Object.ChatBuilderAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@PulseAutoRegister
public class PacificSMPCommands extends PlayerCommand {
    public PacificSMPCommands() {
        super(PacificSMP.GetInstance(), "pacificsmp", false, "psmp");
    }

    @Override
    public void NoMethodFound(Player player, String s, String[] strings) {}

    @Override
    public String helpMenuPrefix(Player player) { return "#4254f5[#4298f5Pacific SMP Commands#4254f5]#68ed90"; }

    @Override
    public LinkedHashMap<String, String> helpMenuFormat(Player player, LinkedHashMap<String, String> linkedHashMap) {
        var data = new LinkedHashMap<String, String>();
        for(var key : linkedHashMap.keySet()) data.put("#28bf56" + key, "#28bf56" + linkedHashMap.get(key));
        return data;
    }

    @Override
    public String helpMenuSuffix(Player player) { return "#4254f5============"; }

    @PCMethod
    @PCSignature({"enable"})
    @PCAutoTab(pos = 1)
    public void EnableSystem(CraftPlayer craftPlayer, boolean state){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.ENABLE_SYSTEM, craftPlayer, true)) return;
        PacificSMPAPI.EnableSystem(state);
        if(craftPlayer != null) Messages.ReturnStatic().SendMessageToPlayer(state ? Message.ConsoleEnabledSystem : Message.ConsoleDisableSystem, craftPlayer);
    }

    @PCMethod
    @PCSignature({"configs", "reset"})
    public void ResetConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RESET_CONFIGS, admin, true)) return;
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;
        PacificSMPAPI.ResetConfigs();
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerResetConfig, admin);
    }

    @PCMethod
    @PCSignature({"configs", "reload"})
    public void ReloadConfigs(CraftPlayer admin){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.RELOAD_CONFIGS, admin, true)) return;
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;
        PacificSMPAPI.ReloadConfigs();
        Messages.ReturnStatic().SendMessageToPlayer(Message.PlayerReloadedConfig, admin);
    }

    @PCMethod
    @PCSignature({"dolphin", "give"})
    @PCTab(pos = 1, type = TabType.Information_From_Function, data = "OnlinePlayers")
    @PCAutoTab(pos = 2)
    public void GiveDolphin(CraftPlayer admin, String playerName, CustomItem customItem){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.GIVE_PLAYER_DOLPHIN, admin, true)) return;
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;

        var targetPlayer = Bukkit.getPlayer(playerName);
        if(targetPlayer == null){
            ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(admin).SendMessage(ChatColor.RED + "Invalid target!", true);
            return;
        }

        PacificSMPAPI.GivePlayerDolphin(targetPlayer, customItem);
        if(admin != targetPlayer){
            ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(admin).SendMessage(ChatColor.GREEN + "Added Dolphin!", true);
        }
    }

    @PCMethod
    @PCSignature({"dolphin", "clear"})
    @PCTab(pos = 1, type = TabType.Information_From_Function, data = "OnlinePlayers")
    public void ClearDolphin(CraftPlayer admin, String playerName){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.CLEAR_PLAYERS_DOLPHIN, admin, true)) return;
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;

        var targetPlayer = Bukkit.getPlayer(playerName);
        if(targetPlayer == null){
            ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(admin).SendMessage(ChatColor.RED + "Invalid target!", true);
            return;
        }

        PacificSMPAPI.ClearPlayerDolphin(targetPlayer);
        if(admin != targetPlayer){
            ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(admin).SendMessage(ChatColor.GREEN + "Cleared Dolphins!", true);
        }
    }

    @PCMethod
    @PCSignature({"dolphin", "max"})
    @PCAutoTab(pos = 1)
    public void MaxDolphins(CraftPlayer admin, int amount){
        if(!Permissions.ReturnStatic().DoesPlayerHavePermission(Permission.CLEAR_PLAYERS_DOLPHIN, admin, true)) return;
        if(!PacificSMPPlugin.ReturnStatic().systemEnabled) return;
        PacificSMPAPI.SetMaximumDolphins(amount);
        ChatBuilderAPI.chatBuilder().messageType(MessageType.Player).playerToo(admin).SendMessage(ChatColor.GREEN + "Set Max Dolphins!", true);
    }

    @PCMethodData
    public List<String> OnlinePlayers(String current){
        var data = new ArrayList<String>();
        for(var player : Bukkit.getOnlinePlayers()){
            if(player.getDisplayName().toLowerCase().contains(current.toLowerCase())){
                data.add(player.getDisplayName());
            }
        }
        return data;
    }
}
