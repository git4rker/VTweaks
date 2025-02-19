package gg.valentinos.alexjoo;

import org.bukkit.plugin.java.JavaPlugin;

public final class ValentinosTweaks extends JavaPlugin {
    private static ValentinosTweaks instance;
    private TweakConfigHandler tweakConfig;
    private TweakManager tweakManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;
        tweakConfig = new TweakConfigHandler();
        tweakManager = new TweakManager();

        tweakManager.loadTweaks();

        getLogger().info("ValentinosTweaks has been enabled!");
    }

    @Override
    public void onDisable() {
        if (tweakManager != null) {
            tweakManager.unloadTweaks();
        }

        tweakManager = null;
        tweakConfig = null;
        instance = null;

        getLogger().info("ValentinosTweaks has been disabled!");
    }

    public TweakConfigHandler getTweakConfigHandler() {
        return tweakConfig;
    }
    public TweakManager getTweakManager() {
        return tweakManager;
    }
    public static ValentinosTweaks getInstance() {
        return instance;
    }
}
