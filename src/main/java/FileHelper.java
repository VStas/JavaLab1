import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileHelper {

    public static void saveString(String string, String file) {
        try {
            PrintWriter out = new PrintWriter(file);
            out.println(string);
            out.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
