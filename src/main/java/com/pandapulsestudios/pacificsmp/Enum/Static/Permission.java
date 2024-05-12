package com.pandapulsestudios.pacificsmp.Enum.Static;

public enum Permission {
    RELOAD_CONFIGS("PacificSMP.RELOAD_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    RESET_CONFIGS("PacificSMP.RESET_CONFIGS", "#fa3448You do not have the permissions to use this command!"),
    ENABLE_SYSTEM("PacificSMP.ENABLE_SYSTEM", "#fa3448You do not have the permissions to use this command!"),
    DARK_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    SPEED_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    FLAME_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    HEALTHY_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    POWER_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    ASSASSIN_DOLPHIN("PacificSMP.DARK_DOLPHIN", "#fa3448You don't have permission to use this this dolphin!"),
    GIVE_PLAYER_DOLPHIN("PacificSMP.GIVE_PLAYER_DOLPHIN", "#fa3448You do not have the permissions to use this command!"),
    CLEAR_PLAYERS_DOLPHIN("PacificSMP.CLEAR_PLAYERS_DOLPHIN", "#fa3448You do not have the permissions to use this command!"),
    SET_MAX_DOLPHINS("PacificSMP.SET_MAX_DOLPHINS", "#fa3448You do not have the permissions to use this command!");

    public final String permission;
    public final String error;
    Permission(String permission, String error){
        this.permission = permission;
        this.error = error;
    }
}
