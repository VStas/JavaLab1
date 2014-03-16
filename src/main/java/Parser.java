import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser {

    public static String parse(String html) {
        Document doc = Jsoup.parse(html);
        return doc.text();
    }
}
