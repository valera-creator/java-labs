package indiv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stat {
    private static final List<Stat> stats = new ArrayList<>();
    private String nameState;
    private final List<City> cities = new ArrayList<>();

    public Stat(String nameState) {
        this.setNameState(nameState);
    }

    public void setNameState(String nameState) {
        if (nameState.isEmpty())
            throw new IllegalArgumentException("Название штата не может быть пустым!");
        this.nameState = nameState;
    }

    public static boolean checkStatInList(String name) {
        if (stats.isEmpty())
            return false;

        for (Stat curStat : stats)
            if (Objects.equals(curStat.nameState, name))
                return true;
        return false;
    }

    public static Stat getStatByName(String name) {
        if (stats.isEmpty())
            return null;

        for (Stat curStat : stats) {
            if (Objects.equals(name, curStat.getNameState()))
                return curStat;
        }
        return null;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public static void addStat(Stat stat) {
        stats.add(stat);
    }

    public String getNameState() {
        return nameState;
    }

    public List<City> getCities() {
        return this.cities;
    }

    public static List<Stat> getStats() {
        return stats;
    }

    public static void printCities() {
        if (stats.isEmpty()) {
            System.out.println("Нет информации ни об одном штате");
            return;
        }

        for (Stat stat : stats) {
            System.out.println("Штат " + stat.getNameState());
            List<City> cities = stat.getCities();
            if (cities.isEmpty())
                System.out.println("Нет информации о городах штата " + stat.getNameState());
            for (City city : cities)
                System.out.println(city);
            System.out.println();
        }
    }

    public static boolean checkCityInStates(String cityName, String stateName) {
        Stat stat = getStatByName(stateName);
        if (stat == null)
            return false;

        for (City city : stat.getCities()) {
            if (Objects.equals(city.getNameCity(), cityName))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        List<String> names = new ArrayList<>();
        for (City city : this.cities)
            names.add(city.getNameCity());
        return "Штат " + this.nameState + "\nГорода: " + String.join(", ", names) + "\n";
    }
}
