package pl.knj.price;

import pl.knj.model.PowerConsumptionEntry;

public interface IPriceStrategy {

    double getPrice(PowerConsumptionEntry powerConsumptionEntry);

}
