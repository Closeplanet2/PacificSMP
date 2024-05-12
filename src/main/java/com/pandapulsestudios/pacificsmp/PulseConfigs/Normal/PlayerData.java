package com.pandapulsestudios.pacificsmp.PulseConfigs.Normal;

import com.pandapulsestudios.pacificsmp.Enum.Normal.AddDolphinReturn;
import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.Enum.Static.Message;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.CustomItems;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Messages;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.PacificSMPPlugin;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Objects.SaveableArrayList;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class PlayerData implements PulseConfig {
    @Override
    public JavaPlugin mainClass() { return PacificSMP.GetInstance(); }
    @Override
    public String documentID() { return documentID; }
    @Override
    public boolean useSubFolder() { return true; }

    public String documentID;
    public SaveableArrayList<CustomItem> dolphins = new SaveableArrayList<>(CustomItem.class);

    public PlayerData(String documentID){
        this.documentID = documentID;
    }

    public void AddDolphin(Player player, CustomItem customItem){
        if(dolphins.contains(customItem)){
            Messages.ReturnStatic().SendMessageToPlayer(Message.AlreadyUsingDolphin, player, customItem.dolphinName);
            return;
        }

        var maximumDolphins = PacificSMPPlugin.ReturnStatic().maximumDolphins;

        if(dolphins.size() < maximumDolphins){
            dolphins.add(customItem);
            Messages.ReturnStatic().SendMessageToPlayer(Message.AddedDolphin, player, customItem.dolphinName);
            return;
        }

        var oldDolphin = dolphins.remove(0);
        dolphins.add(customItem);
        Messages.ReturnStatic().SendMessageToPlayer(Message.ReplacedDolphin, player, oldDolphin.dolphinName, customItem.dolphinName);
    }

    public CustomItem RemoveRandomOnDeath(){
        if(dolphins.isEmpty()) return null;
        return dolphins.remove(new Random().nextInt(dolphins.size()));
    }

}
