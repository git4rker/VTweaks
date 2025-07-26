package gg.valentinos.alexjoo;

import gg.valentinos.alexjoo.api.AbstractTweak;
import gg.valentinos.alexjoo.tweaks.animal_swim.AnimalSwimTweak;
import gg.valentinos.alexjoo.tweaks.enchant_disabler.EnchantDisablerTweak;
import gg.valentinos.alexjoo.tweaks.welcome.WelcomeMessageTweak;
import java.util.Collection;
import java.util.HashMap;

public class TweakManager {
    private final HashMap<String, AbstractTweak> tweaks;
    private final VTweaks plugin = VTweaks.getInstance();

    public TweakManager() {
        this.tweaks = new HashMap<>();
    }

    public void loadTweaks(){
        registerTweak(new WelcomeMessageTweak());
        registerTweak(new EnchantDisablerTweak());
        registerTweak(new AnimalSwimTweak());

        for (AbstractTweak tweak : tweaks.values()) {
            tweak.setConfig(plugin.getTweakConfigHandler().getTweakConfig(tweak.getId()));
            tweak.setEnabled(plugin.getTweakConfigHandler().isTweakEnabled(tweak.getId()));
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
