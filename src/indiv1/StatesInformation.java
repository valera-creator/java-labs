package indiv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatesInformation {
    private final List<Stat> stats = new ArrayList<>();

    public void addStat(Stat stat) {
        stats.add(stat);
    }

    public void printCities() {
        if (this.stats.isEmpty()) {
            System.out.println("Нет информации ни об одном штате");
            return;
        }

        for (Stat stat : this.stats) {
            System.out.println("Штат " + stat.getNameState());
            List<City> cities = stat.getCities();
            if (cities.isEmpty())
                System.out.println("Нет информации о городах штата " + stat.getNameState());
            for (City city : cities)
                System.out.println(city);
            System.out.println();
        }
    }

    public List<Stat> getStats() {
        return this.stats;
    }

    public boolean checkStatInList(String name) {
        if (this.stats.isEmpty())
            return false;

        for (Stat curStat : this.stats)
            if (Objects.equals(curStat.getNameState(), name))
                return true;
        return false;
    }

    public Stat getStatByName(String name) {
        if (this.stats.isEmpty())
            return null;

        for (Stat curStat : this.stats) {
            if (Objects.equals(name, curStat.getNameState()))
                return curStat;
        }
        return null;
    }

    public boolean checkCityInStates(String cityName, String stateName) {
        Stat stat = this.getStatByName(stateName);
        if (stat == null)
            return false;

        for (City city : stat.getCities()) {
            if (Objects.equals(city.getNameCity(), cityName))
                return true;
        }
        return false;
    }

    private long getCntPeoplesCountry2017() {
        long cnt = 0;
        for (Stat stat : this.getStats()) {
            for (City city : stat.getCities())
                cnt += city.getCntPeoples2017();
        }
        return cnt;
    }

    public void calculateAborigine() {
        double percentAborigineInCountry = 2.5;
        double percentAborigineCountry;
        for (Stat stat : this.stats) {
            for (City city : stat.getCities()) {
                percentAborigineCountry = this.getCntPeoplesCountry2017() * percentAborigineInCountry / 100;
                city.setAboriginalCount((int) (percentAborigineCountry * (city.getPercentAborigine() / 100.0)));
            }
        }
    }

    public static void addStatsAndCities(String[] parts, StatesInformation statesInformation) {
        City city = City.createCity(parts);
        if (statesInformation.checkCityInStates(city.getNameCity(), city.getNameState()))
            throw new IllegalArgumentException("Город " + city.getNameCity() + " Был повторно передан в штат " +
                    city.getNameState());

        if (!statesInformation.checkStatInList(city.getNameState())) {
            Stat stat = new Stat(city.getNameState());
            stat.addCity(city);
            statesInformation.addStat(stat);
        } else {
            Stat stat = statesInformation.getStatByName(city.getNameState());
            assert stat != null;
            stat.addCity(city);
        }
    }
}
