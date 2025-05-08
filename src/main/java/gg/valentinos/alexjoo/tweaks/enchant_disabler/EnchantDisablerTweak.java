package gg.valentinos.alexjoo.tweaks.enchant_disabler;

import gg.valentinos.alexjoo.api.AbstractTweak;
import java.util.HashSet;

import java.util.Set;

public class EnchantDisablerTweak extends AbstractTweak {
    private final EnchantDisablerListener listener = new EnchantDisablerListener(this);
    private final Set<String> disabledEnchantItems = new HashSet<>();

    public EnchantDisablerTweak() {
        super("enchant-disabler");
    }

    @Override
    public void onEnable() {
        disabledEnchantItems.addAll(config.getStringList("items"));

        listener.register();
        plugin.getLogger().info("Enchanting disabled for: " + disabledEnchantItems);
    }

    @Override
    public void onDisable() {
        listener.unregister();
        plugin.getLogger().info("EnchantDisabler disabled");
    }

    public boolean isEnchantmentDisabled(String itemName) {
        return disabledEnchantItems.contains(itemName);
    }

    public Set<String> getDisabledEnchantItems() {
        return disabledEnchantItems;
    }
}
