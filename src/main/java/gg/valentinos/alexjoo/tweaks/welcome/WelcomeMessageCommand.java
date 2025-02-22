package gg.valentinos.alexjoo.tweaks.welcome;

import gg.valentinos.alexjoo.api.AbstractTweakCommand;
import org.bukkit.command.CommandSender;

public class WelcomeMessageCommand extends AbstractTweakCommand {
    private final WelcomeMessageTweak tweak;

    public WelcomeMessageCommand(WelcomeMessageTweak tweak) {
        super("welcome", "tweaks.welcome", "Set the welcome message", "/welcome [set <message>]");
        this.tweak = tweak;
        registerSubCommand(new WelcomeSetSubCommand(tweak));
    }

    @Override
    protected boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(tweak.getMessage());
        return true;
    }

}
