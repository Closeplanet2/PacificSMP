package com.pandapulsestudios.pacificsmp.PulseConfigs.Static;

import com.pandapulsestudios.pacificsmp.Events.Custom.EnableSystemEvent;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pulseconfig.API.StorageAPI;
import com.pandapulsestudios.pulseconfig.Enum.StorageType;
import com.pandapulsestudios.pulseconfig.Interface.PulseConfig;
import com.pandapulsestudios.pulseconfig.Interface.StorageComment;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import org.bukkit.plugin.java.JavaPlugin;

@PulseAutoRegister
public class PacificSMPPlugin implements PulseConfig {
    public static PacificSMPPlugin ReturnStatic(){
        var stored = StorageAPI.ReturnStatic(PacificSMPPlugin.class, StorageType.CONFIG, false);
        return stored == null ? new PacificSMPPlugin() : (PacificSMPPlugin) stored;
    }

    @Override
    public JavaPlugin mainClass() {return PacificSMP.GetInstance();}

    @StorageComment("WARNING: SYSTEM WONT RUN IF FALSE!")
    public boolean systemEnabled = true;
    public boolean debugConfig = false;
    public int maximumDolphins = 2;

    public void ToggleSystemEnabled(boolean newState){
        new EnableSystemEvent(systemEnabled, newState);
        systemEnabled = newState;
        SaveConfig(false);
    }

    public void SetMaximumDolphins(int amount){
        maximumDolphins = amount;
        SaveConfig(false);
    }
}
