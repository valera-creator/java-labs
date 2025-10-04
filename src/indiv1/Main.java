package indiv1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src\\indiv1\\data_AUS_state.csv";
        StatesInformation statesInformation = new StatesInformation();
        ParsingText(path, statesInformation);

        statesInformation.calculateAborigine();
        statesInformation.printCities();
    }

    private static void ParsingText(String path, StatesInformation statesInformation) {
        BufferedReader br;
        String line;

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {

                // регулярка с условием
                // ?= - просмотр вперед
                // [^"]* - любые символы, кроме кавычки, сколько угодно раз
                // \" - кавычка
                // [^"]* - любые символы, кроме кавычки, сколько угодно раз
                // \" - кавычка
                // скобки с * - сколько угодно раз

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (parts.length != 5)
                    throw new IllegalArgumentException("Передано не 5 характеристик в csv");

                parts[2] = parts[2].replaceAll("\"", "").replaceAll(",", "");
                parts[3] = parts[3].replaceAll("\"", "").replaceAll(",", "");

                StatesInformation.addStatsAndCities(parts, statesInformation);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
