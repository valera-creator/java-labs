package laba3;

public class Bus {
    private int cntPlaces;
    private int costPlace;
    private int occupiedPlaces = 0;

    // обычный конструктор
    public Bus() {
    }

    // конструктор с параметрами
    public Bus(int cntPlaces, int costPlace) {
        if (cntPlaces < 0 || costPlace < 0) {
            System.out.println("неправильно переданные значения (отрицательные) " +
                    "в конструктор класса с двумя параметрами");
            System.exit(0);
        }

        this.cntPlaces = cntPlaces;
        this.costPlace = costPlace;
    }

    // конструктор с параметрами
    public Bus(int cntPlaces, int costPlace, int occupiedPlaces) {
        if (cntPlaces < 0 || costPlace < 0 || occupiedPlaces < 0) {
            System.out.println("неправильно переданные значения (отрицательные) " +
                    "в конструктор класса с тремя параметрами");
            System.exit(0);
        }
        if (cntPlaces < occupiedPlaces) {
            System.out.println("неправильно переданные значения (количество мест меньше количества занятых мест) " +
                    "в конструктор класса с тремя параметрами");
            System.exit(0);
        }

        this.cntPlaces = cntPlaces;
        this.costPlace = costPlace;
        this.occupiedPlaces = occupiedPlaces;
    }

    // конструктор копирования
    public Bus(Bus bus) {
        this.cntPlaces = bus.cntPlaces;
        this.costPlace = bus.costPlace;
        this.occupiedPlaces = bus.occupiedPlaces;
    }

    // возврат значений
    public int getPlaces() {
        return this.cntPlaces;
    }

    public int getCostPlace() {
        return this.costPlace;
    }

    public int getOccupiedPlaces() {
        return this.occupiedPlaces;
    }

    // изменение значений
    public void setCntPlaces(int newCntPlaces) {
        if (newCntPlaces > 0 && this.occupiedPlaces <= newCntPlaces)
            this.cntPlaces = newCntPlaces;
        else {
            System.out.println("ошибка изменения: некорректное изменение количества мест");
            System.exit(0);
        }
    }

    public void setCostPlace(int newCostPlace) {
        if (newCostPlace >= 0)
            this.costPlace = newCostPlace;
        else {
            System.out.println("ошибка изменения: некорректное изменение цены поездки (отрицательная)");
            System.exit(0);
        }
    }

    public void setOccupiedPlaces(int newOccupiedPlaces) {
        if (newOccupiedPlaces >= 0 && newOccupiedPlaces <= this.cntPlaces)
            this.occupiedPlaces = newOccupiedPlaces;
        else {
            System.out.println("ошибка изменения: некорректное изменение количества занятых мест");
            System.exit(0);
        }

    }

    // рассчет значений
    public int getFreePlaces() {
        return this.cntPlaces - this.occupiedPlaces;
    }

    public String checkEmptyFull() {
        if (this.occupiedPlaces == 0)
            return "пустой";
        if (this.occupiedPlaces == this.cntPlaces)
            return "заполненный";
        return "не пустой и не заполненный";
    }

    public int getAllCosts() {
        return this.occupiedPlaces * this.costPlace;
    }
}
