package pl.knj.price.impl;

import pl.knj.model.PowerConsumptionEntry;
import pl.knj.price.IPriceStrategy;

public class PriceStrategy2019 implements IPriceStrategy {

    @Override
    public double getPrice(PowerConsumptionEntry powerConsumptionEntry) {
        return .21 * powerConsumptionEntry.getUsed();
    }

}
