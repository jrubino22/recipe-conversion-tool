/* - This is the main project file. Run this file to convert your recipe.
   - Once this program is finished running, your new recipe will be saved in 
   converted_recipe.txt.
*/

import java.util.Scanner;
import java.io.IOException;

public class RecipeConverter {
    public static void main(String[] args) {
        // Set up scanner for recipe input and create a new recipe object
        Scanner scanner = new Scanner(System.in);
        Recipe recipe = new Recipe();

        // Get original servings and number of ingredients from user
        System.out.print("Enter original number of servings: ");
        double originalServings = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter number of ingredients: ");
        int numberOfIngredients = Integer.parseInt(scanner.nextLine());
      
        // Get ingredients from user and add them to the recipe
        for (int i = 1; i <= numberOfIngredients; i++) {
            System.out.print("Enter name of ingredient " + i + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter quantity of ingredient " + i + ": ");
            double quantity = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter unit of ingredient " + i + ": ");
            String unit = scanner.nextLine();

            Ingredient ingredient = new Ingredient(name, quantity, unit);
            recipe.addIngredient(ingredient);
        }

        // Get desired servings from user
        System.out.print("Enter desired number of servings: ");
        double desiredServings = Double.parseDouble(scanner.nextLine());

        // convert recipe to desired servings
        recipe.adjustRecipe(originalServings, desiredServings);

       // Save converted recipe to converted_recipe.txt and handle potential error.
        try {
            recipe.saveToFile("converted_recipe.txt");
            System.out.println("Converted recipe saved to file 'converted_recipe.txt'");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + 
e.getMessage());
        }
    }
}