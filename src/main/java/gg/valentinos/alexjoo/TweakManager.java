package gg.valentinos.alexjoo;

import gg.valentinos.alexjoo.api.AbstractTweak;
import gg.valentinos.alexjoo.tweaks.welcome.WelcomeMessageTweak;

import java.util.Collection;
import java.util.HashMap;

public class TweakManager {
    private final HashMap<String, AbstractTweak> tweaks;
    private final ValentinosTweaks plugin = ValentinosTweaks.getInstance();

    public TweakManager() {
        this.tweaks = new HashMap<>();
    }

    public void loadTweaks(){
        registerTweak(new WelcomeMessageTweak());

        for (AbstractTweak tweak : tweaks.values()) {
            plugin.getLogger().info("Loading tweak: " + tweak.getId() + "...");
            tweak.setConfig(ValentinosTweaks.getInstance().getTweakConfigHandler().getTweakConfig(tweak.getId()));
            tweak.setEnabled(ValentinosTweaks.getInstance().getTweakConfigHandler().isTweakEnabled(tweak.getId()));
        }
    }

    public void unloadTweaks(){
        for (AbstractTweak tweak : tweaks.values()) {
            tweak.setEnabled(false);
        }
    }

    public Collection<AbstractTweak> getAllTweaks() {
        return tweaks.values();
    }

    private void registerTweak(AbstractTweak tweak) {
        tweaks.put(tweak.getId(), tweak);
    }
}
