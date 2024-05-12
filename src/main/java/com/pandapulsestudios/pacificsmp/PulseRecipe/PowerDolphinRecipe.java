package com.pandapulsestudios.pacificsmp.PulseRecipe;

import com.pandapulsestudios.pacificsmp.Enum.Normal.NBTTags;
import com.pandapulsestudios.pacificsmp.Enum.Static.CustomItem;
import com.pandapulsestudios.pacificsmp.PacificSMP;
import com.pandapulsestudios.pacificsmp.PulseConfigs.Static.CustomItems;
import com.pandapulsestudios.pulsecore.JavaAPI.Interface.PulseAutoRegister;
import com.pandapulsestudios.pulsecore.NBTAPI.API.NBTAPI;
import com.pandapulsestudios.pulsecore.RecipeAPI.Enum.RecipeType;
import com.pandapulsestudios.pulsecore.RecipeAPI.Interface.PulseRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;

@PulseAutoRegister
public class PowerDolphinRecipe implements PulseRecipe {
    private static final CustomItem CUSTOM_ITEM = CustomItem.PowerDolphin;
    private static final NBTTags NBT_TAGS = NBTTags.DolphinTypeKey;

    @Override
    public RecipeType recipeType() { return RecipeType.ShapedRecipe; }
    @Override
    public ItemStack recipeResult() {
        var rewardItem = CustomItems.ReturnStatic().ReturnItemStack(CUSTOM_ITEM, 1);
        NBTAPI.Add(PacificSMP.GetInstance(), rewardItem, PersistentDataType.STRING, NBT_TAGS.tag, CUSTOM_ITEM.name());
        return rewardItem;
    }

    @Override
    public List<String> recipeShape() {
        return List.of("QWE", "WRW", "EWQ");
    }

    @Override
    public HashMap<Character, RecipeChoice> recipeMaterials() {
        var hashmap = new HashMap<Character, RecipeChoice>();
        hashmap.put('Q', new RecipeChoice.MaterialChoice(Material.PRISMARINE_SHARD));
        hashmap.put('W', new RecipeChoice.MaterialChoice(Material.DIAMOND_SWORD));
        hashmap.put('E', new RecipeChoice.MaterialChoice(Material.PRISMARINE_CRYSTALS));
        hashmap.put('R', new RecipeChoice.MaterialChoice(Material.HEART_OF_THE_SEA));
        return hashmap;
    }
}
