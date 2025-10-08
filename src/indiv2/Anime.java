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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getTypeAnime() {
        return typeAnime;
    }

    public int getCntSeries() {
        return cntSeries;
    }

    public double getRating() {
        return rating;
    }

    public int getCntParticipants() {
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
}
