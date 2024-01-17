package se.nackademin;

import org.junit.jupiter.api.Test;

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
    }

    @Test
    void getValidIntegerInput() {
    }

    @Test
    void getValidNumericInput() {
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