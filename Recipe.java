import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//class representing a recipe
public class Recipe {

    // list to store ingredients
    private List<Ingredient> ingredients;

    // constructor for the ingredients list
    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    //adds ingredients to the recipe
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    // Convert recipe from original to desired servings
    public void adjustRecipe(double originalServings, double desiredServings) {
        for (Ingredient ingredient : ingredients) {
            ingredient.adjustQuantity(originalServings, desiredServings);
        }
    }

    // Saves the recipe to a given file
    public void saveToFile(String filename) throws IOException {
      for (Ingredient ingredient : ingredients) {
          // Append converted ingredients to a file
          Files.writeString(Paths.get(filename), ingredient.toString() + "\n",
                          StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      }
    }
  
}