package gg.valentinos.alexjoo.tweaks.welcome;

import gg.valentinos.alexjoo.api.AbstractTweakSubCommand;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class WelcomeSetSubCommand extends AbstractTweakSubCommand {
    private final WelcomeMessageTweak tweak;

    protected WelcomeSetSubCommand(WelcomeMessageTweak tweak) {
        super("set", "tweaks.welcome.set", "Set the welcome message", "/welcome set <message>");
        this.tweak = tweak;
    }

    @Override
    protected boolean execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(usage);
            return true;
        }
        String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        tweak.setMessage(message);
        sender.sendMessage("Welcome message set to: " + message);
        return true;
    }

    @Override
    protected List<String> tabComplete(CommandSender sender, String[] args) {
        return List.of("Hello World!");
    }
}
