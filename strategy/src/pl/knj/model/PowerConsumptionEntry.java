package pl.knj.model;

import pl.knj.price.IPriceStrategy;
import pl.knj.price.impl.*;

import java.util.Collection;
import java.util.stream.Collectors;

public class PowerConsumptionEntry {

    private final String month;
    private final String year;
    private final int used;

    private final IPriceStrategy priceStrategy;

    private PowerConsumptionEntry(String month, String year, int used) {
        this.month = month;
        this.year = year;
        this.used = used;

        switch (year) {
            case "2018":
                this.priceStrategy = new PriceStrategy2018();
                break;
            case "2019":
                this.priceStrategy = new PriceStrategy2019();
                break;
            case "2020":
                this.priceStrategy = new PriceStrategy2020();
                break;
            default:
                this.priceStrategy = new PriceStrategy2020();
                break;
        }
    }

    public static PowerConsumptionEntry of(String line) {
        String[] splittedLine = line.split("[   |.]");
        if (splittedLine.length == 3) {
            return new PowerConsumptionEntry(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2]));
        }
        return null;
    }

    public static Collection<PowerConsumptionEntry> of(Collection<String> lines) {
        return lines.stream().map(PowerConsumptionEntry::of).collect(Collectors.toList());
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public int getUsed() {
        return used;
    }

    public double getPrice() {
        return priceStrategy.getPrice(this);
    }

    @Override
    public String toString() {
        return "PowerConsumptionEntry{" +
                "month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", used=" + used +
                '}';
    }
}
