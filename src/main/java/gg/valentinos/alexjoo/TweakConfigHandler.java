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
        return tweakConfigs.get(tweakId);
    }
    public void setTweakEnabled(String tweakId, boolean enabled) {
        enabledStates.put(tweakId, enabled);
        ValentinosTweaks.getInstance().getConfig().set("tweaks." + tweakId + ".enabled", enabled);
        ValentinosTweaks.getInstance().saveConfig();
    }
    public void setTweakConfig(String tweakId, ConfigurationSection config) {
        tweakConfigs.put(tweakId, config);
        ValentinosTweaks.getInstance().getConfig().set("tweaks." + tweakId, config);
        ValentinosTweaks.getInstance().saveConfig();
    }

    public void reload(){
        ValentinosTweaks.getInstance().reloadConfig();

        enabledStates.clear();
        tweakConfigs.clear();

        ConfigurationSection tweaksSection = ValentinosTweaks.getInstance().getConfig().getConfigurationSection("tweaks");
        if (tweaksSection != null) {
            for (String tweakId : tweaksSection.getKeys(false)) {
                boolean enabled = tweaksSection.getBoolean(tweakId + ".enabled", false);
                enabledStates.put(tweakId, enabled);

                ConfigurationSection configSection = tweaksSection.getConfigurationSection(tweakId);
                if (configSection != null) {
                    tweakConfigs.put(tweakId, configSection);
                }
            }
        }
    }
}
