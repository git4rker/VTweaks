package gg.valentinos.alexjoo.api;

import gg.valentinos.alexjoo.ValentinosTweaks;
import org.bukkit.configuration.ConfigurationSection;

public abstract class AbstractTweak {
    protected final String id;
    protected boolean enabled;
    protected ConfigurationSection config;
    protected final ValentinosTweaks plugin = ValentinosTweaks.getInstance();


    public AbstractTweak(String id) {
        this.id = id;
        this.enabled = false;
    }

    public abstract void onEnable();
    public abstract void onDisable();

    public String getId() {
        return id;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    public void setConfig(ConfigurationSection config) {
        this.config = config;
    }
}
