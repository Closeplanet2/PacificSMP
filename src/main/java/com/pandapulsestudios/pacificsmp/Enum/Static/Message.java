package com.pandapulsestudios.pacificsmp.Enum.Static;

public enum Message {
    ConsoleEnabledSystem("#7fff36System has been enabled!"),
    ConsoleDisableSystem("#fa3448System has been disabled!"),
    PlayerReloadedConfig("#7fff36You have reloaded the configs!"),
    PlayerResetConfig("#7fff36You have reset the configs!"),
    AlreadyUsingDolphin("#fa3448You are already using the dolphin %s!"),
    AddedDolphin("#7fff36Added dolphin %s!"),
    ReplacedDolphin("#7fff36You have replaced dolphin %s with %s!"),
    YouHaveLostYourDolphin("#fa3448You have lost your dolphin %s to %s!"),
    XHasDroppedTheirDolphin("#fa3448%s has dropped their %s dolphin!");

    public final String message;
    Message(String message){
        this.message = message;
    }
}
