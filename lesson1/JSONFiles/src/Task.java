import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Task {
    public static void main(String[] args){
        Task t = new Task();
        JsonObject doc = t.readJson("./resources/restaurant-data.json");
        Database db = new Database(doc);
        System.out.println(db.getRestaurant("Hometown BBQ"));
        System.out.println(db.getAvgReviews("Casa Enrique"));
    }

    public JsonObject readJson(String filename) {

        /* TODO: create a JSON object with the contents of  "filename". You can use the method below to help you read the file. */
        JsonObject rest = (JsonObject)Jsoner.deserialize(readFile(filename), new JsonObject());
        return rest;
    }

    public String readFile(String filename){
        String content = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String data = reader.readLine();
            while(data != null)
            {
                content += data;
                data = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        content = new String(content.getBytes(), StandardCharsets.UTF_8);
        return content;
    }
}