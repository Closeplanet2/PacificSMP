package com.pandapulsestudios.pacificsmp.VariableTest;

import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.Enums.PersistentDataTypes;
import com.pandapulsestudios.pulsecore.VariableAPI.Interface.PulseVariableTest;

import java.util.ArrayList;
import java.util.List;

@PulseAutoRegister
public class CustomItemVariableTest implements PulseVariableTest {
    @Override
    public PersistentDataTypes PersistentDataType() { return PersistentDataTypes.STRING; }

    @Override
    public boolean IsType(Object variable) {
        try{
            var test = CustomItem.valueOf(variable.toString());
            return true;
        }catch (IllegalArgumentException ignored){ return false; }
    }

    @Override
    public List<Class<?>> ClassTypes() {
        var data = new ArrayList<Class<?>>();
        data.add(CustomItem.class);
        data.add(CustomItem[].class);
        return data;
    }

    @Override
    public Object SerializeData(Object serializedData) {
        return serializedData.toString();
    }

    @Override
    public Object DeSerializeData(Object serializedData) {
        return CustomItem.valueOf(serializedData.toString());
    }

    @Override
    public Object ReturnDefaultValue() { return CustomItem.DarkDolphin; }

    @Override
    public List<String> TabData(List<String> list, String s) {
        var data = new ArrayList<String>();
        for(var x : CustomItem.values()) if(x.name().contains(s)) data.add(x.name());
        return data;
    }
}
