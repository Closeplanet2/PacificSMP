package com.pandapulsestudios.pacificsmp.Events.Custom;

import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nullable;

@Getter
public class PlayerAddDolphinEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    @Getter
    private boolean cancelled;
    private final CustomItem customItem;
    private final Player player;

    public PlayerAddDolphinEvent(CustomItem customItem, Player player){
        this.customItem = customItem;
        this.player = player;
        Bukkit.getPluginManager().callEvent(this);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
    public HandlerList getHandlers() {
        return handlers;
    }
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

}
