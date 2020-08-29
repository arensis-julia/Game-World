import java.util.*;
import java.io.*;

public class ScoreBoard {
    private static LinkedHashMap<String, Score> scores = new LinkedHashMap<String, Score>();

    static void getScore(GameType type) {
        scores.clear();
        String path = null;
        try {
            if(type == GameType.LEXIO) {
                path = java.net.URLDecoder.decode(ScoreBoard.class.getResource("1_lexio_scores.txt").getPath(),
                "UTF-8");
            }

            File file = new File(path);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String id = line.split(" ")[1];
                Score score = new Score(Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[0]), line.split(" ")[3]);
                scores.put(id, score);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] File not found: " + path);
        } catch (UnsupportedEncodingException e) {
            System.out.println("[ERROR] Invalid encoding mode");
        }
    }

    public static void printScoreBoard(GameType type) {
        getScore(type);
        System.out.println("Rank\t|Player  \t|Score\t|Time               |");
        Iterator<String> iterator = scores.keySet().iterator();
        while(iterator.hasNext()) {
            String id = iterator.next();
            Score s = scores.get(id);
            System.out.println("no " + s.getRank() + ".\t|" + id + "\t\t|" + s.getScore() + "\t|" + s.getUpdateTime() + "|");
        }
    }
}