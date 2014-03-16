import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String defaultUrl = "http://www.stackoverflow.com";
        String defaultFile = "words.txt";

        System.out.println("URL (def=" + defaultUrl + "): ");
        String url = scan.next();

        if (url.equals("def")) url = defaultUrl;

        System.out.println("file (def=" + defaultFile + "): ");
        String file = scan.next();

        if (file.equals("def")) file = defaultFile;


        Map<String, Integer> wordToCountMap = new HashMap<String, Integer>();

        String html = Parser.parse(NetworkHelper.getHtml(url));
        String[] words = html.split(" ");

        for (String s : words) {
            int count = wordToCountMap.containsKey(s) ? wordToCountMap.get(s) : 0;
            wordToCountMap.put(s, count + 1);
        }

        FileHelper.saveString(wordToCountMap.toString(), file);
        System.out.println("Results from " + url + " are saved to " + file);
    }
}
