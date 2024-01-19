package se.nackademin;

import java.util.HashMap;
import java.util.Map;


public class MatDatabas_utils {
    // Metoder för att skapa våran mat databas
    private static Map<String, Double> foodMap;

    public MatDatabas_utils() {
        foodMap = new HashMap<>();
    }

    public void addFood(String foodName, double caloriesPer100Grams) {
        foodMap.put(getFirstWord(foodName).toLowerCase(), caloriesPer100Grams);
    }

    public static void displayFoodList() {
        int count = 0;
        int index = 1;

        for (String food : foodMap.keySet()) {

            System.out.printf("|| %02d %-17s", index, capitalFirstLetter(food)); // Justerat formatet
            index++;

            count++;

            // Om 4 produkter har skrivits ut, radbrytning och återställning av count.
            if (count % 5 == 0) {
                System.out.print("||");
                System.out.println();
                count = 0;
            }
        }
    }

    public static double calculateCalories(String foodName, double amountInGrams) {
        // Kontrollera om maten finns i databasen
        if (foodMap.containsKey(foodName.toLowerCase())) {
            double caloriesPer100Grams = foodMap.get(foodName.toLowerCase());
            return (caloriesPer100Grams / 100.0) * amountInGrams;
        } else {
            System.out.println("Maten hittades inte i databasen.");
            return 0;
        }
    }

    public static String convertIntToFood(String selectedProductInt) {
        int selectedProduct = (Integer.parseInt(selectedProductInt));
        int count = 1;

        for (String food : foodMap.keySet()) {
            if (count == selectedProduct) {
                return food;
            }
            count++;
        }
        return null;
    }

    // Hjälpmetod för att kolla om en sträng är en int

    private static String getFirstWord(String input) {
        return input.split("\\s+")[0];
    }
    private static String capitalFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}