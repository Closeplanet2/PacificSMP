package com.pandapulsestudios.pacificsmp.PulseLoop;

import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.LoopAPI.Interface.PulseLoop;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@PulseAutoRegister
public class PacificSMPLoop implements PulseLoop {
    @Override
    public void START() {}

    @Override
    public void LOOP() {
        for(var player : Bukkit.getOnlinePlayers()){
            var playerData = PacificSMP.ReturnPlayerData(player);
            if(playerData.dolphins.contains(CustomItem.DarkDolphin)) player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 1));
            if(playerData.dolphins.contains(CustomItem.SpeedDolphin)){
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 40, 0));
            }
            if(playerData.dolphins.contains(CustomItem.FlameDolphin)) player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 40, 0));
            if(playerData.dolphins.contains(CustomItem.PowerDolphin)) player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0));
            player.setMaxHealth(playerData.dolphins.contains(CustomItem.HealthyDolphin) ? 26 : 20);
        }
    }
}
