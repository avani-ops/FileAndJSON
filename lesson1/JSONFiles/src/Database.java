import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class Database {
    JsonObject restaurant;
    /* TODO
Declare a member variable that can
be EASILY set from the constructor. */

    public Database(JsonObject data){
        /* TODO
set the memebr variable declared above.*/
        this.restaurant = data;
    }

    public JsonObject getRestaurant(String name){
        /* TODO
Complete this method as specified. */
        return restaurant;
    }

    public double getAvgReviews(String name){
        /* TODO
Complete this method as specified.
 The previous method may be of help.
*/
        JsonArray ja = (JsonArray)restaurant.get("reviews");
        JsonObject first = (JsonObject)ja.get(0);
        JsonObject second = (JsonObject)ja.get(1);
        JsonObject third = (JsonObject)ja.get(2);
        double rating_1 = (double)first.get("rating");
        double rating_2 = (double)second.get("rating");
        double rating_3 = (double)third.get("rating");
        double average = (rating_1 + rating_2 + rating_3)/3;
        return average;
    }
}