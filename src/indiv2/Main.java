package indiv2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        List<Anime> animeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String pathTxtFile = "src\\indiv2\\data_anime.txt";
        String pathJsonFile = "src\\indiv2\\output.json";

        WorkWithFiles.receiveInfo(pathTxtFile, animeList);
        Anime.searchInfoGenres(animeList);

        chooseVar(scanner, animeList);
        scanner.close();
    }

    public static void chooseVar(Scanner scanner, List<Anime> animeList) {
        while (true) {
            System.out.print("Выбери, о чем хочешь получить информацию, введи \"фильм\" или \"сериал\": ");
            String s = scanner.nextLine().toLowerCase();
            if (s.equals("фильм")) {
                Anime.searchFilms(animeList);
                return;
            } else if (s.equals("сериал")) {
                Anime.searchSerials(animeList);
                return;
            } else
                System.out.println("и чё означает \"" + s + "\"? Вводи по новой давай!");
        }
    }
}