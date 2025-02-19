package gg.valentinos.alexjoo;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class TweakConfigHandler {
    private final HashMap<String, Boolean> enabledStates;
    private final HashMap<String, ConfigurationSection> tweakConfigs;

    public TweakConfigHandler() {
        this.enabledStates = new HashMap<>();
        this.tweakConfigs = new HashMap<>();
        reload();
    }

    public boolean isTweakEnabled(String tweakId) {
        return enabledStates.getOrDefault(tweakId, false);
    }
    public ConfigurationSection getTweakConfig(String tweakId) {
        ValentinosTweaks.getInstance().getLogger().info(tweakConfigs.toString());
        return tweakConfigs.get(tweakId);
    }

    public void reload(){
        ValentinosTweaks.getInstance().reloadConfig();

        enabledStates.clear();
        tweakConfigs.clear();

        ConfigurationSection tweaksSection = ValentinosTweaks.getInstance().getConfig().getConfigurationSection("tweaks");
        for (String key : tweaksSection.getKeys(false)) {
            Object value = tweaksSection.get(key);
            ValentinosTweaks.getInstance().getLogger().info(key + " = " + value);
        }
        if (tweaksSection != null) {
            for (String tweakId : tweaksSection.getKeys(false)) {
                boolean enabled = tweaksSection.getBoolean(tweakId + ".enabled", false);
                enabledStates.put(tweakId, enabled);

                ConfigurationSection configSection = tweaksSection.getConfigurationSection(tweakId);
                for (String key : configSection.getKeys(false)) {
                    Object value = configSection.get(key);
                    ValentinosTweaks.getInstance().getLogger().info(key + " = " + value);
                }
                if (configSection != null) {
                    tweakConfigs.put(tweakId, configSection);
                }
            }
        }
    }
}
