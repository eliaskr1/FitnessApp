package se.nackademin;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static se.nackademin.BMI_utils.*;

public class BMI {


    public static void BMIcalc() {
        double weight = getValidNumericInput("Hur mycket väger du?: ");
        double heightInCentimeters = getValidNumericInput("Hur lång är du?(i cm): ");

        double heightInMeters = heightInCentimeters / 100.0;

        int bmi = (int) calculateBMI(weight, heightInMeters);
        System.out.println("Din BMI är: " + bmi);

        char gender = getValidGenderInput();
        int age = getValidIntegerInput("Ange din ålder: ");

        String activityLevel = getValidActivityLevelInput();

        int suggestedCaloricIntake = suggestCaloricIntake(gender, age, weight, heightInMeters, activityLevel);
        System.out.println("Baserat på din basalmetabolism, aktivitetsnivå och ålder är den rekommenderade kaloriintaget/dag: " + suggestedCaloricIntake + "kal");

        String goal = getValidGoalInput();

        if (goal.equalsIgnoreCase("Behålla")) {
            System.out.println("Ditt dagliga intag för att behålla din vikt är: " + suggestedCaloricIntake);
        } else if (goal.equalsIgnoreCase("Öka")) {
            int caloriesForGain = suggestedCaloricIntake + 300;
            System.out.println("Ditt dagliga kaloriintag för att öka i vikt: " + caloriesForGain);
        } else if (goal.equalsIgnoreCase("Minska")) {
            double intendedCaloricDeficitPerDay = getValidNumericInput("Ange hur stor kaloriunderskott du vill ha (i kalorier): ");
            double kilogramsToLose = getValidNumericInput("Ange hur många kilo du vill gå ner: ");

            int daysToReachGoal = calculateDaysToReachGoal(intendedCaloricDeficitPerDay, kilogramsToLose);

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, daysToReachGoal);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateToReachGoal = sdf.format(calendar.getTime());

            System.out.println("För att gå ner " + kilogramsToLose + " kilo med ett underskott på "
                    + intendedCaloricDeficitPerDay + " kalorier, kan du nå ditt mål om " + daysToReachGoal + " dagar, datum: " + dateToReachGoal);
        }
    }
}