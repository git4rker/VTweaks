package gg.valentinos.alexjoo.api;

import gg.valentinos.alexjoo.VTweaks;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Abstract class for a tweak. Treat this as a plugin module.
 * It initializes the commands, listeners, and configurations for the tweak.
 */
public abstract class AbstractTweak {
    /**
     * The plugin instance.
     */
    protected static final VTweaks plugin = VTweaks.getInstance();
    /**
     * The unique identifier for the tweak. This is the key in the configuration file.
     */
    protected final String id;
    /**
     * Whether the tweak is enabled.
     */
    protected boolean enabled;
    /**
     * The configuration section for the tweak.
     */
    protected ConfigurationSection config;

    /**
     * Constructor for the tweak.
     * @param id The unique identifier for the tweak. This is the key in the configuration file.
     */
    public AbstractTweak(String id) {
        this.id = id;
        this.enabled = false;
    }

    /**
     * Method to initialize the tweak. This is where you should register commands, listeners, etc.
     */
    public abstract void onEnable();
    /**
     * Method to disable the tweak. This is where you should unregister commands, listeners, etc.
     */
    public abstract void onDisable();

    /**
     * @return The unique identifier for the tweak. This is the key in the configuration file.
     */
    public String getId() {
        return id;
    }
    /**
     * @return Whether the tweak is enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }
    /**
     * Set the enabled state of the tweak. Automatically calls onEnable or onDisable.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
    /**
     * @param config The configuration section for the tweak.
     */
    public void setConfig(ConfigurationSection config) {
        this.config = config;
    }
}
