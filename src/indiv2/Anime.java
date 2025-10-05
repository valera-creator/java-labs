package indiv2;

import java.util.*;

public class Anime {
    private int id;
    private String name;
    private List<String> genres = new ArrayList<>();
    private String typeAnime;
    private int cntSeries;
    private double rating;
    private int cntParticipants;

    public Anime(String id, String name, String genre, String typeAnime, String cntSeries, String rating,
                 String cntParticipants) {
        this.setId(id);
        this.setName(name);
        this.setGenres(genre);
        this.setTypeAnime(typeAnime);
        this.setCntSeries(cntSeries);
        this.setRating(rating);
        this.setCntParticipants(cntParticipants);
    }

    public static boolean checkUniqueId(int id, List<Anime> animeList) {
        for (Anime anime : animeList)
            if (id == anime.id)
                throw new IllegalArgumentException("Ошибка: id " + id + " уже был ранее передан в аниме " + anime.name);

        return true;
    }

    public void setId(String id) {
        int val;
        try {
            val = Integer.parseInt(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("\"" + id + "\"  - не число и не подходит для id!");
        }
        if (val < 0)
            throw new IllegalArgumentException("id не может быть отрицательным! Получен (" + id + ")");
        this.id = val;
    }

    private double getRating() {
        return rating;
    }

    private int getCntParticipants() {
        return cntParticipants;
    }

    public void setName(String name) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя аниме не может быть пустым!");
        this.name = name;
    }

    public void setGenres(String genres) {
        List<String> listGenres;
        if (genres.isEmpty())
            throw new IllegalArgumentException("У аниме " + this.name + " не указаны жанры");
        listGenres = Arrays.stream(genres.split(",")).toList();
        listGenres = listGenres.stream().map(String::strip).toList();
        this.genres = listGenres;
    }

    public void setTypeAnime(String typeAnime) {
        if (typeAnime.isEmpty())
            throw new IllegalArgumentException("У аниме " + this.name + " не указан тип!");
        this.typeAnime = typeAnime;
    }

    public void setCntSeries(String cntSeries) {
        int val;
        if (Objects.equals(cntSeries, "Unknown") || Objects.equals(cntSeries, "unknown"))
            this.cntSeries = -1;
        else {
            try {
                val = Integer.parseInt(cntSeries);
            } catch (Exception e) {
                throw new IllegalArgumentException("\"" + cntSeries + "\"  - не число и не подходит для количества " +
                        "серий у аниме " + this.name + "!");
            }
            this.cntSeries = val;
        }
    }

    public void setRating(String rating) {
        double val;
        if (Objects.equals(rating, "Unknown") || Objects.equals(rating, "unknown"))
            this.rating = -1;
        else {
            try {
                val = Double.parseDouble(rating);
            } catch (Exception e) {
                throw new IllegalArgumentException("\"" + rating + "\"  - не число и не подходит для рейтинга у аниме "
                        + this.name + "!");
            }
            if (val < 0 || val > 10)
                throw new IllegalArgumentException("\"" + rating + "\"  - рейтинг должен быть от 0 до 10 (аниме "
                        + this.name + ")!");
            this.rating = val;
        }
    }

    public void setCntParticipants(String cntParticipants) {
        int val;
        if (Objects.equals(cntParticipants, "Unknown") || Objects.equals(cntParticipants, "unknown"))
            this.cntParticipants = -1;
        else {
            try {
                val = Integer.parseInt(cntParticipants);
            } catch (Exception e) {
                throw new IllegalArgumentException("\"" + cntParticipants + "\"  - не число и не подходит для " +
                        "описания количества " + "пользователей сообщества у аниме " + this.name + "!");
            }
            if (val < 0)
                throw new IllegalArgumentException("\"" + cntParticipants + "\"  - кол-во пользователей сообщества у " +
                        "аниме  " + this.name + " не может быть отрицательным!");
            this.cntParticipants = val;
        }
    }

    @Override
    public String toString() {
        String cntSeries = this.cntSeries == -1 ? "Unknown" : String.valueOf(this.cntSeries);
        String rating = this.rating == -1 ? "Unknown" : String.valueOf(this.rating);
        String cntParticipants = this.cntParticipants == -1 ? "Unknown" : String.valueOf(this.cntParticipants);

        return "id: " + this.id + "; название: " + this.name + "; жанры: " + String.join(", ", this.genres) +
                "; тип аниме: " + this.typeAnime + "; количество серий: " + cntSeries + "; рейтинг: " + rating +
                "; количество пользователей сообщества: " + cntParticipants;
    }

    public static void printAllAnime(List<Anime> animeList) {
        for (Anime anime : animeList)
            System.out.println(anime);
    }

    private static HashSet<String> getAllGenres(List<Anime> animeList) {
        HashSet<String> genres = new HashSet<>();
        for (Anime anime : animeList)
            genres.addAll(anime.genres);
        return genres;
    }

    private static void makeTable(int cntAnime, List<Anime> list, String genre) {
        Optional<Anime> data = list.stream().max(Comparator.comparing(Anime::getRating));
        double maxRating = data.map(anime -> anime.rating).orElse(0.0);

        data = list.stream().min(Comparator.comparing(Anime::getRating));
        double minRating = data.map(anime -> anime.rating).orElse(0.0);

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
            List<Anime> animeGenresList = search.stream().filter(anime -> anime.genres.contains(genre)).
                    toList();
            int cntAnime = animeGenresList.size();

            animeGenresList = animeGenresList.stream().filter(anime -> anime.rating != -1 &&
                    anime.cntParticipants != -1).toList();

            if (animeGenresList.isEmpty()) {
                System.out.println(error2);
                continue;
            }
            makeTable(cntAnime, animeGenresList, genre);
        }
        System.out.println("\n");
    }

    private static void searchBest20(String varietyAnime, List<Anime> search) {
        List<Anime> filterSearch = search.stream().filter(anime -> anime.rating != -1).toList();

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
        List<Anime> serials = animeList.stream().filter(anime -> anime.cntSeries > 1).toList();
        searchGenresAnime("Нет информации о сериалах", "\nИнформация о сериалах", "", serials);
        searchBest20("сериалах", serials);
    }

    public static void searchFilms(List<Anime> animeList) {
        List<Anime> films = animeList.stream().filter(anime -> anime.cntSeries == 1).toList();
        searchGenresAnime("Нет информации о фильмах", "\nИнформация о фильмах", "", films);
        searchBest20("фильмах", films);
    }
}
