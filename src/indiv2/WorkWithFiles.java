package indiv2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WorkWithFiles {
    public static void receiveInfo(String path, List<Anime> animeList) {
        BufferedReader br;
        String line;
        String[] lines = new String[7];
        int i = 0;

        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
                if (i == 7) {
                    i = 0;
                    Anime anime = new Anime(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5], lines[6]);
                    if (Anime.checkUniqueId(Integer.parseInt(lines[0]), animeList))
                        animeList.add(anime);
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public static void writeJson(Map<String, Object> data, String jsonPath) {
        // создание объекта с отступами
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(data);
        System.out.println("Данные для записи в Json:");
        System.out.println(json);

        // запись в файл
        try (FileWriter writer = new FileWriter(jsonPath)) {
            writer.write(json);
            System.out.println("\nJSON успешно записан в файл " + jsonPath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
