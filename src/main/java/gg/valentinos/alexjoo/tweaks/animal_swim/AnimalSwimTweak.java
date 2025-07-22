package gg.valentinos.alexjoo.tweaks.animal_swim;

import java.util.List;

import org.bukkit.entity.Entity;

import gg.valentinos.alexjoo.api.AbstractTweak;

public class AnimalSwimTweak extends AbstractTweak {
    private final AnimalSwimListener listener = new AnimalSwimListener(this);
    private List<String> entities;
    private double swimAssistVelocity;

    public AnimalSwimTweak() {
        super("animal-swim");
    }

    @Override
    public void onEnable() {
        entities = config.getStringList("entities");
        swimAssistVelocity = config.getDouble("swim-assist-velocity");
        
        listener.register();
    }

    @Override
    public void onDisable() {
        listener.unregister();
    }

    public boolean isEntityEligible(Entity entity) {
      return entities.contains(entity.getType().name());
    }

    public double getSwimAssistVelocity() {
      return swimAssistVelocity;
    }
}
