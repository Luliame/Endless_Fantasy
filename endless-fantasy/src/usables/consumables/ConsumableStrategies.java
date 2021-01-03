package usables.consumables;

import usables.UsableState;

public interface ConsumableStrategies extends UsableState {
    void use();
    boolean shouldDelete(int maxUsage);
}
