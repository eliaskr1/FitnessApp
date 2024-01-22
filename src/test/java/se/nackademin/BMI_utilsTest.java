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
        // Act
        char result = BMI_utils.getValidGenderInput(Optional.of("K"));

        // Assert
        assertEquals('K', result);
    }

    @Test
    void getValidIntegerInput() {
        // Act
        int result = BMI_utils.getValidIntegerInput(Optional.of("1"), "");

        // Assert
        assertEquals(1, result);
    }

    @Test
    void getValidNumericInput() {
        // Act
        double result = BMI_utils.getValidNumericInput(Optional.of("1"), "");

        // Assert
        assertEquals(1.0, result);
    }

    @Test
    void getValidGoalInput() {
    }

    @Test
    void getValidActivityLevelInput() {
    }

    @Test
    void suggestCaloricIntake() {
    }

    @Test
    void calculateDaysToReachGoal() {
    }
}