package indiv2;

import java.util.*;

public class AnimeAction {
    private static HashSet<String> getAllGenres(List<Anime> animeList) {
        HashSet<String> genres = new HashSet<>();
        for (Anime anime : animeList)
            genres.addAll(anime.getGenres());
        return genres;
    }

    private static void makeTable(int cntAnime, List<Anime> list, String genre) {
        Optional<Anime> data = list.stream().max(Comparator.comparing(Anime::getRating));
        double maxRating = data.map(Anime::getRating).orElse(0.0);

        data = list.stream().min(Comparator.comparing(Anime::getRating));
        double minRating = data.map(Anime::getRating).orElse(0.0);

        double averageRating = list.stream().mapToDouble(Anime::getRating).average().orElse(0.0);
        int cntPeoples = (int) list.stream().mapToInt(Anime::getCntParticipants).average().
                orElse(0);

        System.out.println("-".repeat(105));
        System.out.printf("Жанр: %-17s | Кол-во: %3d | Ср. рейт: %.2f | Макс: %.2f | Мин: %.2f | " +
                "Ср. участники: %8d%n", genre, cntAnime, averageRating, maxRating, minRating, cntPeoples);
        System.out.println("-".repeat(105));
    }

    private static void searchGenresAnime(String error1, String text1, String error2, List<Anime> search) {
        HashSet<String> genres = getAllGenres(search);
        if (genres.isEmpty()) {
            System.out.println(error1);
            return;
        }

        System.out.println(" ".repeat(40) + text1);
        for (String genre : genres) {
            List<Anime> animeGenresList = search.stream().filter(anime -> anime.getGenres().contains(genre)).
                    toList();
            int cntAnime = animeGenresList.size();

            animeGenresList = animeGenresList.stream().filter(anime -> anime.getRating() != -1 &&
                    anime.getCntParticipants() != -1).toList();

            if (animeGenresList.isEmpty()) {
                System.out.println(error2);
                continue;
            }
            makeTable(cntAnime, animeGenresList, genre);
        }
        System.out.println("\n");
    }

    private static void searchBest20(String varietyAnime, List<Anime> search) {
        List<Anime> filterSearch = search.stream().filter(anime -> anime.getRating() != -1).toList();

        if (filterSearch.isEmpty()) {
            System.out.println("Нет аниме с известным рейтингом в " + varietyAnime);
            return;
        }

        List<Anime> top20 = filterSearch.stream().sorted(Comparator.comparing(Anime::getRating).reversed()).limit(20).toList();
        System.out.println("Информация о топ " + top20.size() + " лучших по рейтингу " + varietyAnime + ":");
        for (int i = 0; i < top20.size(); i++)
            System.out.println((i + 1) + ") " + top20.get(i));
    }

    public static void searchInfoGenres(List<Anime> animeList) {
        System.out.println("Для предотвращения некорректности рассчетов таблица не будет содержать строки, в которых " +
                "были не до конца известны данные");
        searchGenresAnime("Информация о жанрах отсутствует", "\nИнформация о всех жанрах",
                "Нет данных про аниме, у которого присутствовали известные параметры", animeList);
    }

    public static void searchSerials(List<Anime> animeList) {
        List<Anime> serials = animeList.stream().filter(anime -> anime.getCntSeries() > 1).toList();
        searchGenresAnime("Нет информации о сериалах", "\nИнформация о сериалах", "", serials);
        searchBest20("сериалах", serials);
    }

    public static void searchFilms(List<Anime> animeList) {
        List<Anime> films = animeList.stream().filter(anime -> anime.getCntSeries() == 1).toList();
        searchGenresAnime("Нет информации о фильмах", "\nИнформация о фильмах", "", films);
        searchBest20("фильмах", films);
    }

    public static void printFilter(List<Anime> filterList) {
        if (filterList.isEmpty())
            System.out.println("\nПо вашему запросу ничего не нашлось!");
        else {
            System.out.println("Полученные данные после фильтрации: ");
            for (Anime anime : filterList)
                System.out.println(anime);
        }
    }

    public static List<Anime> filterAnime(String[] data, List<Anime> animeList) {
        // проверка корректности данных не требуется, т.к. при вводе значений учтено все в методе inputParamSearch

        List<Anime> filterList;

        if (data[0].equalsIgnoreCase("любой"))
            filterList = animeList;
        else
            filterList = animeList.stream().filter(anime -> anime.getGenres().contains(data[0])).toList();
        if (!data[1].equalsIgnoreCase("любой"))
            filterList = filterList.stream().filter(anime -> Objects.equals(anime.getTypeAnime(), data[1])).toList();
        if (!data[2].equalsIgnoreCase("любой")) {
            int left = Integer.parseInt(data[2].split("\\s+")[0]);
            int right = Integer.parseInt(data[2].split("\\s+")[1]);
            filterList = filterList.stream().filter(anime -> anime.getCntSeries() >= left && anime.getCntSeries() <= right).toList();
        }
        if (!data[3].equalsIgnoreCase("любой")) {
            double left = Double.parseDouble(data[3].split("\\s+")[0]);
            double right = Double.parseDouble(data[3].split("\\s+")[1]);
            filterList = filterList.stream().filter(anime -> anime.getRating() >= left && anime.getRating() <= right).toList();
        }
        if (!data[4].equalsIgnoreCase("любой")) {
            int left = Integer.parseInt(data[4].split("\\s+")[0]);
            int right = Integer.parseInt(data[4].split("\\s+")[1]);
            filterList = filterList.stream().filter(anime -> anime.getCntParticipants() >= left && anime.getCntParticipants() <= right).toList();
        }

        return filterList;
    }
}
