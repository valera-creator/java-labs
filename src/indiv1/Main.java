package indiv1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src\\indiv1\\data_AUS_state.csv";
        ParsingText(path);
        Stat.printCities();
    }

    public static void addStatsAndCities(String[] parts) {
        City city = City.createCity(parts);
        if (Stat.checkCityInStates(city.getNameCity(), city.getNameState()))
            throw new IllegalArgumentException("Город " + city.getNameCity() + " Был повторно передан в штат " +
                    city.getNameState());

        if (!Stat.checkStatInList(city.getNameState())) {
            Stat stat = new Stat(city.getNameState());
            stat.addCity(city);
            Stat.addStat(stat);
        } else {
            Stat stat = Stat.getStatByName(city.getNameState());
            assert stat != null;
            stat.addCity(city);
        }
    }

    private static void ParsingText(String path) {
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

                addStatsAndCities(parts);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
