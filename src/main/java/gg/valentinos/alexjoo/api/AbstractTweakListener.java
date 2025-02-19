package gg.valentinos.alexjoo.api;

import gg.valentinos.alexjoo.ValentinosTweaks;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public abstract class AbstractTweakListener implements Listener {
    protected final ValentinosTweaks plugin = ValentinosTweaks.getInstance();
    protected boolean registered;

    public AbstractTweakListener() {
        this.registered = false;
    }

    public void register() {
        if (!registered) {
            plugin.getServer().getPluginManager().registerEvents(this, plugin);
            registered = true;
            onRegister();
        }
    }
    public void unregister() {
        if (registered) {
            HandlerList.unregisterAll(this);
            registered = false;
            onUnregister();
        }
    }

    protected abstract void onRegister();
    protected abstract void onUnregister();

}
