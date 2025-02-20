package gg.valentinos.alexjoo.tweaks.welcome;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import gg.valentinos.alexjoo.api.AbstractTweakListener;

public class WelcomeListener extends AbstractTweakListener {
    private final WelcomeMessageTweak tweak;

    public WelcomeListener(WelcomeMessageTweak tweak) {
        super();
        this.tweak = tweak;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(tweak.getMessage());
    }

    @Override
    protected void onRegister() {
        // sometimes you don't need to put anything here
    }

    @Override
    protected void onUnregister() {
        // sometimes you don't need to put anything here
    }
}
