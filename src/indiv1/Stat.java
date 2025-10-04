package indiv1;

import java.util.ArrayList;
import java.util.List;

public class Stat {

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

    public void addCity(City city) {
        this.cities.add(city);
    }

    public String getNameState() {
        return this.nameState;
    }

    public List<City> getCities() {
        return this.cities;
    }


    @Override
    public String toString() {
        List<String> names = new ArrayList<>();
        for (City city : this.cities)
            names.add(city.getNameCity());
        return "Штат " + this.nameState + "\nГорода: " + String.join(", ", names) + "\n";
    }
}
