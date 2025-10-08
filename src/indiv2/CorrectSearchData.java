package indiv2;

import java.util.List;
import java.util.Scanner;

public class CorrectSearchData {
    public static void chooseFilmOrSerial(Scanner scanner, List<Anime> animeList) {
        while (true) {
            System.out.print("Выбери, о чем хочешь получить информацию, введи \"фильм\" или \"сериал\": ");
            String s = scanner.nextLine().toLowerCase();
            if (s.equals("фильм")) {
                AnimeAction.searchFilms(animeList);
                return;
            } else if (s.equals("сериал")) {
                AnimeAction.searchSerials(animeList);
                return;
            } else
                System.err.println("\nи чё означает \"" + s + "\"? Вводи по новой давай!");
        }
    }

    private static boolean checkCorrectInt(String str, int limit) {
        String[] strings = str.split("\\s+");
        if (strings.length != 2) {
            System.err.println("Ошибка в воде рейтинга: не два значения");
            return false;
        }
        try {
            int first = Integer.parseInt(strings[0].replace(",", "."));
            int second = Integer.parseInt(strings[1].replace(",", "."));

            if (first <= limit || second <= limit) {
                System.err.println("Ошибка: диапазон не может быть задан числом, которое меньше " + (limit + 1));
                return false;
            }
            if (first > second) {
                System.err.println("Ошибка: первое число диапазона рейтинга больше второго числа");
                return false;
            }

            return true;
        } catch (Exception e) {
            System.err.println("Ошибка обработки числа: " + e.getMessage());
            return false;
        }
    }

    private static boolean checkCorrectRating(String rating) {
        String[] strings = rating.split("\\s+");
        if (strings.length != 2) {
            System.err.println("Ошибка в вводе рейтинга: не два значения");
            return false;
        }
        try {
            double first = Double.parseDouble(strings[0].replace(",", "."));
            double second = Double.parseDouble(strings[1].replace(",", "."));

            if (first < 0 || second < 0) {
                System.err.println("Ошибка: диапазон не может быть задан отрицательными числами");
                return false;
            }
            if (first > second) {
                System.err.println("Ошибка: первое число диапазона рейтинга больше второго числа");
                return false;
            }
            if (first > 10 || second > 10) {
                System.err.println("Ошибка: диапазон не должен превосходить значение 10");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static String[] inputParamSearch(Scanner scanner) {
        String genre;
        String type;
        String cntSeries;
        String rating;
        String cntPeoples;

        System.out.println("\n");
        while (true) {
            System.out.print("Введите жанр для поиска: ");
            genre = scanner.nextLine();
            if (!genre.isEmpty())
                break;
            else
                System.err.println("Ошибка: жанр не может быть пустотой");
        }
        while (true) {
            System.out.print("Введите тип для поиска: ");
            type = scanner.nextLine();
            if (!type.isEmpty())
                break;
            else
                System.err.println("Ошибка: тип не может быть пустотой");
        }
        while (true) {
            System.out.print("Введите диапазон серий (два числа через пробел) или слово \"любой\": ");
            cntSeries = scanner.nextLine();
            if (cntSeries.equalsIgnoreCase("любой"))
                break;
            else if (checkCorrectInt(cntSeries, 0))
                break;
        }
        while (true) {
            System.out.print("Введите диапазон рейтинга от 0 до 10 (два числа через пробел) или слово \"любой\": ");
            rating = scanner.nextLine();
            if (rating.equalsIgnoreCase("любой"))
                break;
            else if (checkCorrectRating(rating))
                break;
        }
        while (true) {
            System.out.print("Введите диапазон подписчиков сообщества (два числа через пробел) или слово \"любой\": ");
            cntPeoples = scanner.nextLine();
            if (cntPeoples.equalsIgnoreCase("любой"))
                break;
            else if (checkCorrectInt(cntPeoples, -1))
                break;
        }
        return new String[]{genre, type, cntSeries, rating, cntPeoples};
    }

}
