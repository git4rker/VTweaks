package gg.valentinos.alexjoo.tweaks.welcome;

import gg.valentinos.alexjoo.api.AbstractTweakCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class WelcomeMessageCommand extends AbstractTweakCommand {
    private final WelcomeMessageTweak tweak;

    public WelcomeMessageCommand(WelcomeMessageTweak tweak) {
        super("welcome", "valentinostweaks.welcome", "/welcome", "Set the welcome message");
        this.tweak = tweak;
        registerSubCommand(new WelcomeSetSubCommand(tweak));
    }

    @Override
    protected boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(tweak.getMessage());
        return true;
    }

    @Override
    protected List<String> tabComplete(CommandSender sender, String[] args) {
        if (args.length == 1) {
            return List.of("set");
        }
        return List.of();
    }
}
