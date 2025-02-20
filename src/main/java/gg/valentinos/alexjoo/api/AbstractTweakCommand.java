package gg.valentinos.alexjoo.api;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract class for a tweak command.
 * It initializes the subcommands for the command, and handles the execution, tab completion and permission checks.
 */
public abstract class AbstractTweakCommand implements CommandExecutor, TabCompleter {
    /**
     * the name of the command. needs to be written in the plugin.yml
     */
    protected final String commandName;
    /**
     * the permission required to use the command
     */
    protected final String permission;
    /**
     * the usage of the command. like /command < arg1 > < arg2 >
     */
    protected final String usage;
    /**
     * the description of the command. Use this for the help command
     */
    protected final String description;
    /**
     * the subcommands of the command. The key is the name of the subcommand, and the value is the subcommand object
     */
    private final Map<String, AbstractTweakSubCommand> subCommands = new HashMap<>();

    /**
     * Constructor for the command
     * @param commandName the name of the command. needs to be written in the plugin.yml
     * @param permission the permission required to use the command
     * @param usage the usage of the command. like /command < arg1 > < arg2 >
     * @param description the description of the command. Use this for the help command
     */
    public AbstractTweakCommand(String commandName, String permission, String description, String usage) {
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
        if (!execute(sender, args)) {
            sender.sendMessage(usage);
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        return tabComplete(sender, args);
    }

    /**
     * Method to execute the command. This is called when the command is used without any recognised subcommands.
     * @param sender the sender of the command
     * @param args the arguments of the command
     * @return whether the command was executed successfully
     */
    protected abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Method to tab complete the command. This is called when the command is used without any recognised subcommands.
     * @param sender the sender of the command
     * @param args the arguments of the command
     * @return the list of possible completions
     */
    protected List<String> tabComplete(CommandSender sender, String[] args){
        if (!sender.hasPermission(permission)) {
            return List.of();
        }
        if (args.length == 1){
            return subCommands.keySet().stream().toList();
        }
        else{
            AbstractTweakSubCommand subCommand = subCommands.get(args[0].toLowerCase());
            if (subCommand != null){
                return subCommand.tabComplete(sender, args);
            }
        }
        return List.of();
    }

    /**
     * Method to register a subcommand to the command
     * @param subCommand the subcommand to register
     */
    protected void registerSubCommand(AbstractTweakSubCommand subCommand) {
        subCommands.put(subCommand.getName().toLowerCase(), subCommand);
    }
}
