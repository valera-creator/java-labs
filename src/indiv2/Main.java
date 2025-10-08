package indiv2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String pathTxtFile = "src\\indiv2\\data_anime.txt";
        String pathJsonFile = "src\\indiv2\\output.json";

        WorkWithFiles.receiveInfo(pathTxtFile, animeList);
        AnimeAction.searchInfoGenres(animeList);

        CorrectSearchData.chooseFilmOrSerial(scanner, animeList);
        String[] params = CorrectSearchData.inputParamSearch(scanner);
        List<Anime> filterList = AnimeAction.filterAnime(params, animeList);
        AnimeAction.printFilter(filterList);

        List<Map<String, Object>> data = WorkWithFiles.convertToMapObj(filterList);
        WorkWithFiles.writeJson(data, pathJsonFile);

        scanner.close();
    }
}