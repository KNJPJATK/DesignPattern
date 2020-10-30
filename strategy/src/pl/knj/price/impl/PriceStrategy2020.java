package pl.knj.price.impl;

import pl.knj.model.PowerConsumptionEntry;
import pl.knj.price.IPriceStrategy;

public class PriceStrategy2020 implements IPriceStrategy {

    @Override
    public double getPrice(PowerConsumptionEntry powerConsumptionEntry) {
        return 0.32 * powerConsumptionEntry.getUsed();
    }

}
