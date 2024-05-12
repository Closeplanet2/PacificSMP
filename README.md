# PacificSMP

Craftable Totems (Dolphins) that each give different lingering effects based on what totems the players have active!
Plugin Forum Link: https://bukkit.org/threads/pacific-smp-plugin.503685/

# Devlog
[![Watch the video](https://img.youtube.com/vi/7A-eNlAXkg4/maxresdefault.jpg)](https://www.youtube.com/watch?v=7A-eNlAXkg4){:target="_blank"}

# Downloads
* 1.20.4 - [https://github.com/Closeplanet2/PacificSMP/releases/tag/1.20.4](https://github.com/Closeplanet2/PacificSMP/releases/tag/1.20.4)
* 1.20.1 - [https://github.com/Closeplanet2/PacificSMP/releases/tag/1.20.1](https://github.com/Closeplanet2/PacificSMP/releases/tag/1.20.1)

# Mavern
```
<repository>
      <id>pacificsmp-1.20.1</id>
      <url>https://maven.pkg.github.com/closeplanet2/PacificSMP</url>
</repository>
```

```
<dependency>
  <groupId>com.pandapulsestudios</groupId>
  <artifactId>pacificsmp-1.20.1</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

# Depends
* [https://github.com/Closeplanet2/PulseCommandsAbstract/releases/tag/1.0.6-SNAPSHOT](https://github.com/Closeplanet2/PulseCommandsAbstract/releases/tag/1.0.6-SNAPSHOT) -> Uses the auto register loops, auto register events and variable tests
* [https://github.com/Closeplanet2/PulseConfig/releases/tag/2.0.3](https://github.com/Closeplanet2/PulseConfig/releases/tag/2.0.3) -> Uses to auto srialise the configs!
* [https://github.com/Closeplanet2/PulseCoreAbstract/releases/tag/1.0.1-SNAPSHOT](https://github.com/Closeplanet2/PulseCoreAbstract/releases/tag/1.0.1-SNAPSHOT) -> USes the auto player command methods

# External Depends
* [https://www.spigotmc.org/resources/placeholderapi.6245/](https://www.spigotmc.org/resources/placeholderapi.6245/)

# How to use the plugin
1. Install this plugin on your server
2. Download the depends on your server
3. Run the server, the event will use the default settings

# Optional,
1. Change the settings in the config below
2. Reload The configs

# Other Work
* [http://joshuafiler.org](http://joshuafiler.org)

# PacificSMP API for develoeprs
```
public static void EnableSystem(boolean state);
public static void SetMaximumDolphins(int amount);
public static void GivePlayerDolphin(Player player, CustomItem customItem);
public static void ClearPlayerDolphin(Player player);
public static void ResetConfigs();
public static void ReloadConfigs()
```

# PacificSMP Custom Events
```
EnableSystemEvent extends Event
PlayerAddDolphinEvent extends Event implements Cancellable
ReloadConfigEvent extends Event
ResetConfigEvent extends Event
```

# Player Commands -> Permssions below
```
/pacificsmp enable <true / false> -> enabled or disable the system
/pacificsmp configs reset -> Reset the configs
/pacificsmp configs reload -> Reload the configs
/pacificsmp dolphin give <PLAYER> <DOLPHIN>
/pacificsmp dolphin clear <PLAYER>
/pacificsmp dolphin max <Amount>
```

# Crafting Recipes
As detailed: https://docs.google.com/document/d/169dY-yQlHqdfduibfCRjNESGIRa-yqoIMOJvEerFVlI/edit

# CustomItems.yml
```
CustomItems:
  '# +------------------Stored customItems!': '------------------+ #'
  customItems:
    HealthyDolphin:
      ==: org.bukkit.inventory.ItemStack
      v: 3700
      type: BLUE_DYE
      meta:
        ==: ItemMeta
        meta-type: UNSPECIFIC
        display-name: '{"text":"","extra":[{"text":"Healthy Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#F7F748","bold":false}]}'
        lore:
        - '{"text":"","extra":[{"text":"Healthy Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#F7F748","bold":false}]}'
        custom-model-data: 0
    FlameDolphin:
      ==: org.bukkit.inventory.ItemStack
      v: 3700
      type: BLUE_DYE
      meta:
        ==: ItemMeta
        meta-type: UNSPECIFIC
        display-name: '{"text":"","extra":[{"text":"Flame Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#FC4521","bold":false}]}'
        lore:
        - '{"text":"","extra":[{"text":"Flame Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#FC4521","bold":false}]}'
        custom-model-data: 0
    DarkDolphin:
      ==: org.bukkit.inventory.ItemStack
      v: 3700
      type: BLUE_DYE
      meta:
        ==: ItemMeta
        meta-type: UNSPECIFIC
        display-name: '{"text":"","extra":[{"text":"Dark Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#242222","bold":false}]}'
        lore:
        - '{"text":"","extra":[{"text":"Dark Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#242222","bold":false}]}'
        custom-model-data: 0
    PowerDolphin:
      ==: org.bukkit.inventory.ItemStack
      v: 3700
      type: BLUE_DYE
      meta:
        ==: ItemMeta
        meta-type: UNSPECIFIC
        display-name: '{"text":"","extra":[{"text":"Power Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#6725F5","bold":false}]}'
        lore:
        - '{"text":"","extra":[{"text":"Power Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#6725F5","bold":false}]}'
        custom-model-data: 0
    SpeedDolphin:
      ==: org.bukkit.inventory.ItemStack
      v: 3700
      type: BLUE_DYE
      meta:
        ==: ItemMeta
        meta-type: UNSPECIFIC
        display-name: '{"text":"","extra":[{"text":"Speed Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#9AFF63","bold":false}]}'
        lore:
        - '{"text":"","extra":[{"text":"Speed Dolphin","obfuscated":false,"italic":false,"underlined":false,"strikethrough":false,"color":"#9AFF63","bold":false}]}'
        custom-model-data: 0
  '# +------------------Display debugs in the console logs for changes in this config!': '------------------+
    #'
  debugConfig: false
```

# Messages.yml
```
Messages:
  ? '# +------------------Messages to be displayed on the server! Leave blank and
    message wont be sent! Remove to reset to default!'
  : '------------------+ #'
  messages:
    AlreadyUsingDolphin: '#fa3448You are already using the dolphin %s!'
    PlayerReloadedConfig: '#7fff36You have reloaded the configs!'
    ReplacedDolphin: '#7fff36You have replaced dolphin %s with %s!'
    YouHaveLostYourDolphin: '#fa3448You have lost your dolphin %s to %s!'
    ConsoleDisableSystem: '#fa3448System has been disabled!'
    PlayerResetConfig: '#7fff36You have reset the configs!'
    XHasDroppedTheirDolphin: '#fa3448%s has dropped their %s dolphin!'
    ConsoleEnabledSystem: '#7fff36System has been enabled!'
    AddedDolphin: '#7fff36Added dolphin %s!'
  '# +------------------Display debugs in the console logs for changes in this config!': '------------------+
    #'
  debugConfig: false
```

# PacificSMPPlugin.yml
```
PacificSMPPlugin:
  '# +------------------WARNING: SYSTEM WONT RUN IF FALSE!': '------------------+
    #'
  systemEnabled: true
  debugConfig: false
  maximumDolphins: 100

```

# Permissions.yml
```
Permissions:
  '# +------------------Stored Permissions!': '------------------+ #'
  permissions:
    RELOAD_CONFIGS: PacificSMP.RELOAD_CONFIGS
    SET_MAX_DOLPHINS: PacificSMP.SET_MAX_DOLPHINS
    RESET_CONFIGS: PacificSMP.RESET_CONFIGS
    FLAME_DOLPHIN: PacificSMP.DARK_DOLPHIN
    DARK_DOLPHIN: PacificSMP.DARK_DOLPHIN
    SPEED_DOLPHIN: PacificSMP.DARK_DOLPHIN
    GIVE_PLAYER_DOLPHIN: PacificSMP.GIVE_PLAYER_DOLPHIN
    ASSASSIN_DOLPHIN: PacificSMP.DARK_DOLPHIN
    CLEAR_PLAYERS_DOLPHIN: PacificSMP.CLEAR_PLAYERS_DOLPHIN
    POWER_DOLPHIN: PacificSMP.DARK_DOLPHIN
    ENABLE_SYSTEM: PacificSMP.ENABLE_SYSTEM
    HEALTHY_DOLPHIN: PacificSMP.DARK_DOLPHIN
  '# +------------------Display debugs in the console logs for changes in this config!': '------------------+
    #'
  debugConfig: false
  '# +------------------Do you send player error message if doesn''t have permission?': '------------------+
    #'
  sendPlayerErrorMessage: true
```
