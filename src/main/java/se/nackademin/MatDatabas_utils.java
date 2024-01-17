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

    public double getCalories(String foodName) {
        return foodMap.getOrDefault(getFirstWord(foodName).toLowerCase(), 0.0);
    }

    public static void displayFoodList() {
        for (String food : foodMap.keySet()) {
            System.out.println(capitalFirstLetter(food));
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
    private static String getFirstWord(String input) {
        return input.split("\\s+")[0];
    }
    private static String capitalFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}