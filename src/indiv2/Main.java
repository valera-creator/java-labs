package indiv2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String pathTxtFile = "src\\indiv2\\data_anime.txt";
        String pathJsonFile = "src\\indiv2\\output.json";

        WorkWithFiles.receiveInfo(pathTxtFile, animeList);
        Anime.searchInfoGenres(animeList);

        CorrectSearchData.chooseVar(scanner, animeList);
        String[] params = CorrectSearchData.inputParamSearch(scanner, animeList);

        scanner.close();
    }
}