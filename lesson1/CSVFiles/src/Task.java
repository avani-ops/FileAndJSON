import javax.xml.crypto.Data;
import java.io.*;

public class Task {
    public static void main(String[] ar) {
        Task t = new Task();
        Database d = t.readCSV("./resources/iris.data");
    }

    public Database readCSV(String filename) {
        String contents = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(filename)))
        {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while((lengthRead = in.read(buffer)) >0)
            {
                contents += new String(buffer,0,lengthRead);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        Database db = new Database(contents);
        System.out.println(contents);
        return db;
    }
}
