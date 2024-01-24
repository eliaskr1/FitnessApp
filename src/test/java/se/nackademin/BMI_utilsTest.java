package se.nackademin;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BMI_utilsTest {


    @Test
    void calculateBMI() {
        // Arrange
        double weight = 70.0;  // in kilograms
        double height = 1.75; // in meters

        // Act
        double calculatedBMI = BMI_utils.calculateBMI(weight, height);
        double expectedBMI = weight / (height * height);

        // Assert
        assertEquals(expectedBMI, calculatedBMI, 0.001);
    }

    @Test
    void getValidGenderInput() {
        // Använder mockinput med korrekt input för att se att uträkningar görs rätt

        // Act
        char result = BMI_utils.getValidGenderInput(Optional.of("K"));

        // Assert
        assertEquals('K', result);
    }

    @Test
    void getValidIntegerInput() {
        // Använder mockinput med korrekt input för att se att uträkningar görs rätt

        // Act
        int result = BMI_utils.getValidIntegerInput(Optional.of("1"), "");

        // Assert
        assertEquals(1, result);
    }

    @Test
    void getValidNumericInput() {
        // Använder mockinput med korrekt input för att se att uträkningar görs rätt

        // Act
        double result = BMI_utils.getValidNumericInput(Optional.of("1"), "");

        // Assert
        assertEquals(1.0, result);
    }

    @Test
    void getValidGoalInput() {
        // Använder mockinput med korrekt input för att se att uträkningar görs rätt

        // Act
        int result = BMI_utils.getValidGoalInput(Optional.of("1"));

        // Assert
        assertEquals(1, result);
    }

    @Test
    void getValidActivityLevelInput() {
        // Använder mockinput med korrekt input för att se att uträkningar görs rätt

        // Act
        int result = BMI_utils.getValidActivityLevelInput(Optional.of("1"));

        // Assert
        assertEquals(1, result);
    }

    @Test
    void suggestCaloricIntake() {
        // Arrange
        char gender = 'M';
        int age = 25;
        double weight = 90.0;
        double height = 1.9;
        int activityLevel = 2;

        // Act
        int result = BMI_utils.suggestCaloricIntake(gender, age, weight, height, activityLevel);

        // Assert
        assertEquals(2837, result);
    }

}