package gg.valentinos.alexjoo.tweaks.enchant_disabler;

import gg.valentinos.alexjoo.api.AbstractTweakListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantDisablerListener extends AbstractTweakListener {
    private final EnchantDisablerTweak tweak;

    public EnchantDisablerListener(EnchantDisablerTweak tweak) {
        super();
        this.tweak = tweak;
    }

    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        ItemStack item = event.getItem();
        String itemName = item.getType().name();

        if (tweak.isEnchantmentDisabled(itemName)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onAnvilEnchant(PrepareAnvilEvent event) {
        ItemStack first = event.getInventory().getFirstItem();
        ItemStack second = event.getInventory().getSecondItem();
        ItemStack result = event.getResult();

        // Safeguard
        if (first == null || second == null || result == null) return;

        String firstName = first.getType().name();

        if (!tweak.isEnchantmentDisabled(firstName)) return; // return if item is enchantable

        // If the result and first item don't have the same enchantments, don't allow the anvil usage
        if (!first.getEnchantments().equals(result.getEnchantments())) {
            event.setResult(null);
        }
    }




    @Override
    protected void onRegister() {
        // Still dont know bro
    }

    @Override
    protected void onUnregister() {
        // Still dont know bro
    }
}
