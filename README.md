
# VTweaks - Minecraft plugin
This plugin is a collection of tweaks and features that I've added to my Minecraft server. It's a work in progress and I'm adding new features as I need them with a development team.
V in VTweaks stands for Valentinos - my gaming community server, if you want to join here's the invite: 

## Features
### Welcome Message Feature
This is mostly an example of how every feature should look and how it should be documented. This feature is disabled by default.

This feature creates a welcome message which is sent to every player upon joining the server. The message is configurable in the configs and the plugin enables 1 command with an optional subcommand.

The command is `/welcome` which upon the execution without arguments - simply shows the sender the current welcome message. Requires `tweaks.welcome` permission.

The subcommand is `/welcome set <message>` allows the sender to set a new welcome message, this **will** overwrite what is written in the config. The message can be a multi word message. Requires `tweaks.welcome.set` permission

```yaml
welcome:
    enabled: false
    message: "Welcome to the server!"
```

### Enchant Disabler
This feature adds a new configurable list in the config `enchant-disabler.items`. All the items in the list will be un-enchantable, be it through the enchanting table or the anvil. Here is it's content by default:
```yaml
  enchant-disabler:
    enabled: true
    # Get material names from here: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html
    items:
      - "ELYTRA"
  #      - "MACE"
```

## Plans
- [ ] **Enable/Disable features** - Enable or disable features through commands in game.
- [x] **Item enchantment forbidding** - Forbid enchanting certain items.
- [ ] **Item crafting unusability** - Forbid certain items from being used in recipes.
- [ ] **Custom potion effects** - Add custom potion effects.
- [ ] **Help and list commands** - List all available commands and help for each command.
- [ ] and more...

