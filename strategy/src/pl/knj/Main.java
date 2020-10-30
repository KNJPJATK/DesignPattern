package pl.knj;

import pl.knj.model.PowerConsumptionEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {

    public static final String POWER_CONSUMPTION_FILE_NAME = "powerconsumption.txt";

    public static void main(String[] args) throws IOException {
        Collection<PowerConsumptionEntry> powerConsumptionEntries = PowerConsumptionEntry.of(readPowerConsumption(POWER_CONSUMPTION_FILE_NAME));

        double summaryPrice = powerConsumptionEntries.stream().mapToDouble(PowerConsumptionEntry::getPrice).sum();
        System.out.println(summaryPrice);
    }

    private static Collection<String> readPowerConsumption(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().collect(Collectors.toList());
        }
    }

}
