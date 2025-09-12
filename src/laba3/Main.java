package laba3;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(54, 400);
        Bus bus2 = new Bus(45, 500);

        bus1.setOccupiedPlaces(30);
        bus2.setOccupiedPlaces(25);

        System.out.println("рентабельность поездки для первого автобуса: " + bus1.getAllCosts());
        System.out.println("рентабельность поездки для второго автобуса: " + bus2.getAllCosts());
    }
}
