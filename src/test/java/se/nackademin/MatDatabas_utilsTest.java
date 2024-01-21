package se.nackademin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatDatabas_utilsTest {

    @Test
    void addFood() {
        // Arrange
        MatDatabas_utils matDB = new MatDatabas_utils();
        String foodName = "Kyckling (grillad)";
        double caloriesPer100Grams = 165.0;

        // Act
        matDB.addFood(foodName, caloriesPer100Grams);
        double retrievedCalories = matDB.getCalories(foodName);

        // Assert
        assertEquals(caloriesPer100Grams, retrievedCalories, 0.001);
    }

    @Test
    void displayFoodList() {
    }

    @Test
    void calculateCalories() {
        // Arrange
        MatDatabas_utils matDB2 = new MatDatabas_utils();
        matDB2.addFood("Kyckling (grillad)", 165.0);
        String existingFoodName = "Kyckling";
        double amountInGrams = 200.0;

        // Act
        double calculatedCalories = MatDatabas_utils.calculateCalories(existingFoodName, amountInGrams);

        // Assert
        double expectedCalories = (165.0 / 100.0) * amountInGrams;
        assertEquals(expectedCalories, calculatedCalories, 0.001);
    }
    @Test
    public void testCalculateCaloriesForNonExistingFood() {
        // Arrange
        String nonExistingFoodName = "NonExistingFood";
        double amountInGrams = 150.0;

        // Act
        double calculatedCalories = MatDatabas_utils.calculateCalories(nonExistingFoodName, amountInGrams);

        // Assert
        assertEquals(0.0, calculatedCalories, 0.001);
    }
}