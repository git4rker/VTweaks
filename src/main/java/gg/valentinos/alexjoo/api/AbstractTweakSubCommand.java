package gg.valentinos.alexjoo.api;

import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class AbstractTweakSubCommand {
    protected String name;
    protected String description;
    protected String usage;
    protected String permission;

    protected AbstractTweakSubCommand(String name, String permission, String description, String usage) {
        this.name = name;
        this.permission = permission;
        this.description = description;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getUsage() {
        return usage;
    }
    public String getPermission() {
        return permission;
    }

    protected abstract boolean execute(CommandSender sender, String[] args);

    protected abstract List<String> tabComplete(CommandSender sender, String[] args);
}
