import json_simple.JsonArray;
import json_simple.JsonObject;
import json_simple.Jsoner;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class OnlineRecipeDatabase {

    String baseUrl = "http://www.recipepuppy.com/api/?";

    public JsonObject getRecipesByIngredients(String ingredients) throws Exception
    {
        //Getting the things ready to connect to the web
        String content  = "";
        try {
            URL url = new URL(baseUrl + "i=" + ingredients);
            Scanner urlscanner = new Scanner(url.openStream());
            while (urlscanner.hasNextLine()) {
                content += urlscanner.nextLine();
            }
            urlscanner.close();
        }
        catch(MalformedURLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.print(e.toString());
        }
        JsonObject urldata = (JsonObject)Jsoner.deserialize(content, new JsonObject());

        return urldata;
    }

    public JsonObject getRecipesByDish(String dish) throws Exception
    {
        //Getting the things ready to connect to the web
        String content = "";
        try {
            URL url = new URL(baseUrl + "q=" + dish);
            Scanner urlscanner = new Scanner(url.openStream());
            while (urlscanner.hasNextLine()) {
                content += urlscanner.nextLine();
            }
            urlscanner.close();
        }
        catch(MalformedURLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.print(e.toString());
        }
        JsonObject urldata = (JsonObject)Jsoner.deserialize(content, new JsonObject());

        return urldata;
    }


    public String formatRecipeAsString(JsonObject doc){
        /* TODO
This should return a String with each recipe in three lines:
Title:the title of the recipe
Link:the link to the recipe
Ingredients:The ingredients of teh recipe.*/
        String title  = (String)doc.get("title");
        String link = (String)doc.get("href");
        JsonArray ja = (JsonArray)doc.get("results");
        JsonObject obj = (JsonObject)ja.get(0);
        String ing = (String)obj.get("ingredients");
        String results = "Title:" + title + "\nLink:" + link + "\nIngredients:" + ing;
        return results;
    }

    public void saveRecipes(String text, String outfile){
        /* TODO
Given a String with some text in it, write that text to a file.
The name of the file is given in outfile */
        try(FileOutputStream fout = new FileOutputStream(outfile)){
            fout.write(text.getBytes());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File Not Found");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}