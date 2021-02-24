public class Task {
    public static void main(String[] args){
        OnlineRecipeDatabase ord = new OnlineRecipeDatabase();
        try {
            String ommelets = ord.formatRecipeAsString(ord.getRecipesByDish("ommelette"));
            String gotRice = ord.formatRecipeAsString(ord.getRecipesByIngredients("rice,onions"));
            System.out.println(ommelets);
            System.out.println(gotRice);
            ord.saveRecipes(gotRice,"rice.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}