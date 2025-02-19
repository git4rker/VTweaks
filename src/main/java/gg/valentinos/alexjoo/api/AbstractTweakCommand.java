package gg.valentinos.alexjoo.api;

import gg.valentinos.alexjoo.ValentinosTweaks;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractTweakCommand implements CommandExecutor, TabCompleter {
    protected final String commandName;
    protected final String permission;
    protected final String usage;
    protected final String description;
    private final Map<String, AbstractTweakSubCommand> subCommands = new HashMap<>();

    public AbstractTweakCommand(String commandName, String permission, String usage, String description) {
        this.commandName = commandName;
        this.permission = permission;
        this.usage = usage;
        this.description = description;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage("You don't have permission to use this command!");
            return true;
        }
        if (args.length > 1) {
            AbstractTweakSubCommand subCommand = subCommands.get(args[0].toLowerCase());
            if (subCommand != null) {
                if (!sender.hasPermission(subCommand.getPermission())) {
                    sender.sendMessage("You don't have permission to use this command!");
                    return true;
                }
                return subCommand.execute(sender, args);
            }
        }
        return execute(sender, args);
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (sender.hasPermission(permission)) {
            return tabComplete(sender, args);
        }
        return List.of();
    }

    protected abstract boolean execute(CommandSender sender, String[] args);

    protected List<String> tabComplete(CommandSender sender, String[] args){
        if (args.length == 1){
            return subCommands.keySet().stream().toList();
        }
        else {
            AbstractTweakSubCommand subCommand = subCommands.get(args[0].toLowerCase());
            if (subCommand != null){
                return subCommand.tabComplete(sender, args);
            }
        }
        return List.of();
    }

    protected void registerSubCommand(AbstractTweakSubCommand subCommand) {
        subCommands.put(subCommand.getName().toLowerCase(), subCommand);
    }
}
