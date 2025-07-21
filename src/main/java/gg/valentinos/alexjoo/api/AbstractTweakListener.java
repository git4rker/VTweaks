package gg.valentinos.alexjoo.api;

import gg.valentinos.alexjoo.VTweaks;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 * Abstract class for all tweak listeners. This class provides a simple way to register and unregister listeners.
 */
public abstract class AbstractTweakListener implements Listener {
    /**
     * The plugin instance.
     */
    protected static final VTweaks plugin = VTweaks.getInstance();
    /**
     * Whether the listener is registered.
     */
    protected boolean registered;

    /**
     * Constructor.
     */
    public AbstractTweakListener() {
        this.registered = false;
    }

    /**
     * Registers the listener and calls {@link #onRegister()}. Does nothing if the listener is already registered.
     */
    public void register() {
        if (!registered) {
            plugin.getServer().getPluginManager().registerEvents(this, plugin);
            registered = true;
            onRegister();
        }
    }
    /**
     * Unregisters the listener and calls {@link #onUnregister()}. Does nothing if the listener is not registered.
     */
    public void unregister() {
        if (registered) {
            HandlerList.unregisterAll(this);
            registered = false;
            onUnregister();
        }
    }

    /**
     * Called when the listener is registered.
     */
    protected void onRegister() {}
    /**
     * Called when the listener is unregistered.
     */
    protected void onUnregister() {}

}
