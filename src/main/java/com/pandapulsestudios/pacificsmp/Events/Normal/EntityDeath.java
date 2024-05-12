package com.pandapulsestudios.pacificsmp.Events.Normal;

import com.pandapulsestudios.pacificsmp.Enum.Normal.NBTTags;
import com.pandapulsestudios.pacificsmp.Enum.Static.Message;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.Messages;
import com.pandapulsestudios.pulsecore.Data.API.UUIDDataAPI;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.API.NBTAPI;
import com.pandapulsestudios.pulsecore.StorageDataAPI.API.UUIDStorageAPI;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

@PulseAutoRegister
public class EntityDeath implements Listener {
    private static final NBTTags NBT_TAGS = NBTTags.DolphinTypeKey;

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){
        UUIDStorageAPI.Store(event.getEntity().getUniqueId(), "onEntityDamage", event.getDamager().getType().name());
    }

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent event){
        if(!(event.getEntity() instanceof Player player)) return;
        var entityTypeStore = (String) UUIDStorageAPI.Get(player.getUniqueId(), "onEntityDamage", EntityType.PLAYER.name()).getStorageData();
        var entityType = EntityType.valueOf(entityTypeStore);
        if(entityType != EntityType.PLAYER) return;

        var playerData = PacificSMP.ReturnPlayerData(player);
        var randomRemoved = playerData.RemoveRandomOnDeath();
        if(randomRemoved != null){
            var itemStack = randomRemoved.ReturnItemStack(1);
            NBTAPI.Add(PacificSMP.GetInstance(), itemStack, PersistentDataType.STRING, NBT_TAGS.tag, randomRemoved.name());
            event.getDrops().add(randomRemoved.ReturnItemStack(1));

            Messages.ReturnStatic().SendMessageToPlayer(Message.YouHaveLostYourDolphin, player, randomRemoved.dolphinName, player.getKiller().getDisplayName());
            Messages.ReturnStatic().SendMessageToPlayer(Message.XHasDroppedTheirDolphin, player.getKiller(), player.getDisplayName(), randomRemoved.dolphinName);
        }

        PacificSMP.SavePlayerData(player, playerData);
    }
}
