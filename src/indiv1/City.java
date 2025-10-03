package indiv1;


public class City {
    private String nameCity = "";
    private String nameState = "";
    private int cntPeoples2011 = 0;
    private int cntPeoples2017 = 0;
    private double percentAborigine = 0;


    public City(String nameCity, String nameState, String cntPeoples2011, String cntPeoples2017, String percentAborigine) {
        this.setNameCity(nameCity);
        this.setNameState(nameState);
        this.setCntPeoples2011(cntPeoples2011);
        this.setCntPeoples2017(cntPeoples2017);
        this.setPercentAborigine(percentAborigine);
    }

    public void setNameCity(String nameCity) {
        if (nameCity.isEmpty())
            throw new IllegalArgumentException("Название города не может быть пустым!");
        this.nameCity = nameCity;
    }

    public void setNameState(String nameState) {
        if (nameState.isEmpty())
            throw new IllegalArgumentException("Название штата не может быть пустым!");
        this.nameState = nameState;
    }

    public void setCntPeoples2011(String cntPeoples2011) {
        int val;
        try {
            val = Integer.parseInt(cntPeoples2011);
        } catch (Exception e) {
            throw new IllegalArgumentException("\"" + cntPeoples2011 + "\"  - не число!");
        }
        if (val < 0)
            throw new IllegalArgumentException("В 2011 году в городе \"" + this.nameCity + "\" не могло проживать " +
                    "отрицательное количество человек!");
        this.cntPeoples2011 = val;
    }

    public void setCntPeoples2017(String cntPeoples2017) {
        int val;
        try {
            val = Integer.parseInt(cntPeoples2017);
        } catch (Exception e) {
            throw new IllegalArgumentException("\"" + cntPeoples2017 + "\"  - не число!");
        }
        if (val < 0)
            throw new IllegalArgumentException("В 2017 году в городе \"" + this.nameCity + "\" не могло проживать " +
                    "отрицательное количество человек!");
        this.cntPeoples2017 = val;
    }

    public void setPercentAborigine(String percentAborigine) {
        percentAborigine = percentAborigine.replaceAll("%", "");
        double val;
        try {
            val = Double.parseDouble(percentAborigine);
        } catch (Exception e) {
            throw new IllegalArgumentException("\"" + percentAborigine + "\"  - не число!");
        }
        if (val < 0) {
            throw new IllegalArgumentException("Количество аборигенов в городе " +
                    this.nameCity + " не может быть отрицательным!");
        }
        this.percentAborigine = val;
    }

    public String getNameCity() {
        return nameCity;
    }

    public int getCntPeoples2011() {
        return cntPeoples2011;
    }

    public int getCntPeoples2017() {
        return cntPeoples2017;
    }

    public String getNameState() {
        return nameState;
    }

    private double getPercentPopulation() {
        double diff;
        if (this.getCntPeoples2011() == 0) {
            if (this.getCntPeoples2017() == 0)
                diff = 0;
            else
                diff = 100;
        } else
            diff = ((double) this.getCntPeoples2017() * 100 / this.getCntPeoples2011()) - 100;
        return Math.round(diff * 100.0) / 100.0;
    }

    public static City createCity(String[] info) {
        try {
            return new City(info[0], info[1], info[2], info[3], info[4]);
        } catch (Exception e) {
            System.err.println("Ошибка создания города: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    private static long getCntPeoplesCountry2017() {
        long cnt = 0;
        for (Stat stat : Stat.getStats()) {
            for (City city : stat.getCities())
                cnt += city.cntPeoples2017;
        }
        return cnt;
    }

    private int calculateNumAborigine2017() {
        double percentAborigineInCountry = 2.5;
        double peoples = getCntPeoplesCountry2017() * percentAborigineInCountry / 100;
        return (int) (peoples * (this.percentAborigine / 100.0));
    }

    @Override
    public String toString() {
        return "Город: " + this.nameCity + ", Численность населения в 2011: " +
                this.cntPeoples2011 + ", Численность населения в 2017: " + this.cntPeoples2017 + ", Доля аборигенов: "
                + this.percentAborigine + "%" + ", Процент прироста с 2011 по 2017 год: " +
                this.getPercentPopulation() + "%, Примерное число аборигенов в городе в 2017 " +
                "году: " + this.calculateNumAborigine2017();
    }
}
