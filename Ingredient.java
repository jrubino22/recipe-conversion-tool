//Class representing an ingredient
public class Ingredient {
    // Ingredient fields
    private String name;
    private double quantity;
    private String unit;

   // Constructor for the ingredient fields
    public Ingredient(String name, double quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Converts the ingredients based on servings
    public void adjustQuantity(double originalServings, double desiredServings) {
        this.quantity = (this.quantity / originalServings) * desiredServings;
    }

    // String representation of the converted ingredients
    public String toString() {
      return name + ": " + quantity + " " + unit;
    }
}