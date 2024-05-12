package com.pandapulsestudios.pacificsmp.Enum.Normal;

import com.pandapulsestudios.pacificsmp.Enum.Static.Message;

public enum AddDolphinReturn {
    AlreadyUsingDolphin(Message.AlreadyUsingDolphin),
    AddedDolphin(Message.AddedDolphin),
    ReplacedDolphin(Message.ReplacedDolphin);

    public final Message message;
    AddDolphinReturn(Message message){
        this.message = message;
    }

}
