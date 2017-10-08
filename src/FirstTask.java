import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        String word = "China";
        Map<String, Integer> stringIntegerMap = firstTask();
        System.out.println("Первое задание: " + stringIntegerMap);
        System.out.println("Второе задание: " + secondTask(word));
    }

    public static String readFile(String pathName) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathName)));
        String line;
        while ((line = reader.readLine()) != null) {
            contentBuilder.append(line).append(" ");
        }
        reader.close();
        return contentBuilder.toString();
    }

    public static Map<String, Integer> firstTask() throws IOException {
        String resultText = readFile("resources\\text").toLowerCase().replaceAll("\\.", "").replaceAll(",", "");
        String rez[] = resultText.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < rez.length; i++) {
            Integer integer = map.get(rez[i]);
            if (integer == null) {
                integer = 0;
            }
            integer++;
            map.put(rez[i], integer);
        }
        return map;
    }

    public static List<String> stringList(String pathName) throws IOException {
        List<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathName)));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public static String secondTask(String word) throws IOException {
        List<String> lines = stringList("resources\\text");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(word)) {
                stringBuilder.append("Номер строки: ").append(i + 1).append("; Строка: ").append(lines.get(i));
            }
        }
        return stringBuilder.toString();
    }

}
