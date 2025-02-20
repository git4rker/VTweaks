package gg.valentinos.alexjoo.api;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * Abstract class for subcommands of the tweak command. This class provides a simple way to create subcommands.
 */
public abstract class AbstractTweakSubCommand {
    /**
     * The name of the subcommand.
     */
    protected String name;
    /**
     * The description of the subcommand.
     */
    protected String description;
    /**
     * The usage of the subcommand.
     */
    protected String usage;
    /**
     * The permission required to execute the subcommand. For consistency, the permission starts with the parent command's permission.
     */
    protected String permission;

    /**
     * Constructor.
     *
     * @param name        The name of the subcommand.
     * @param permission  The permission required to execute the subcommand.
     * @param description The description of the subcommand.
     * @param usage       The usage of the subcommand.
     */
    protected AbstractTweakSubCommand(String name, String permission, String description, String usage) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.usage = usage;
    }

    /**
     * Returns the name of the subcommand.
     *
     * @return The name of the subcommand.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the description of the subcommand.
     *
     * @return The description of the subcommand.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Returns the usage of the subcommand.
     *
     * @return The usage of the subcommand.
     */
    public String getUsage() {
        return usage;
    }
    /**
     * Returns the permission required to execute the subcommand.
     *
     * @return The permission required to execute the subcommand.
     */
    public String getPermission() {
        return permission;
    }

    /**
     * Executes the subcommand.
     *
     * @param sender The sender of the command.
     * @param args   The arguments of the command.
     * @return Whether the command was executed successfully. Most cases should return true.
     */
    protected abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Returns the list of possible tab completions for the subcommand.
     *
     * @param sender The sender of the command.
     * @param args   The arguments of the command.
     * @return The list of possible tab completions for the subcommand.
     */
    protected abstract List<String> tabComplete(CommandSender sender, String[] args);
}
