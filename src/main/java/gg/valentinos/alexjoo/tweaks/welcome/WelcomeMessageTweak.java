package gg.valentinos.alexjoo.tweaks.welcome;

import gg.valentinos.alexjoo.api.AbstractTweak;

import java.util.Objects;

public class WelcomeMessageTweak extends AbstractTweak {
    private String message;
    private final WelcomeListener listener = new WelcomeListener(this);

    public WelcomeMessageTweak() {
        super("welcome");
    }

    @Override
    public void onEnable() {
        message = config.getString("message");

        Objects.requireNonNull(plugin.getCommand("welcome")).setExecutor(new WelcomeMessageCommand(this));

        listener.register();

        plugin.getLogger().info("Welcome message enabled");
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Welcome message disabled");

        listener.unregister();
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
        config.set("message", message);
        plugin.getTweakConfigHandler().setTweakConfig(id, config);
    }

}
