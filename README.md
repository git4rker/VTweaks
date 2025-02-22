
# ValentinosTweaks - Minecraft plugin

This plugin is a collection of tweaks and features that I've added to my Minecraft server. It's a work in progress and I'm adding new features as I need them with a development team.

## Features
### Welcome Message Feature
This feature creates a welcome message which is sent to every player upon joining the server. The message is configurable in the configs and the plugin enables 1 command with an optional subcommand.
The command is `/welcome` which upon the execution without arguments - simply shows the sender the current welcome message. Requres `tweaks.welcome` permission.
The subcommand is `/welcome set <message>` allows the sender to set a new welcome message, this **will** overwrite what is written in the config. The message can be a multi word message. Requires `tweaks.welcome.set` permission
```yaml
tweaks:
  welcome:
    enabled: true
    message: "Welcome to the server!"
```

## Plans
- **Enable/Disable features** - Enable or disable features through commands in game.
- **Item enchantment forbidding** - Forbid enchanting certain items.
- **Item crafting unusability** - Forbid certain items from being used in recipes.
- **Custom potion effects** - Add custom potion effects.
- **Help and list commands** - List all available commands and help for each command.
- and more...

