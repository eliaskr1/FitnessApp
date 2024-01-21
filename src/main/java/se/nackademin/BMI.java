package se.nackademin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Optional;

import static se.nackademin.BMI_utils.*;

public class BMI {


    public static void BMIcalc() {
        double weight = getValidNumericInput("Hur mycket väger du (i kg)?: ");
        double heightInCentimeters = getValidNumericInput("Hur lång är du (i cm)?: ");

        double heightInMeters = heightInCentimeters / 100.0;

        int bmi = (int) calculateBMI(weight, heightInMeters);
        System.out.println('\n' + "Ditt BMI är: " + bmi);

        char gender = getValidGenderInput(Optional.empty());
        int age = getValidIntegerInput(Optional.empty(), "Ange din ålder: ");

        int activityLevel = getValidActivityLevelInput();

        int suggestedCaloricIntake = suggestCaloricIntake(gender, age, weight, heightInMeters, activityLevel);
        System.out.println('\n' + "Baserat på din basalmetabolism, aktivitetsnivå och ålder är den rekommenderade kaloriintaget/dag: " + suggestedCaloricIntake + " kal"+'\n');

        int goal = getValidGoalInput();

        if (goal == 1) { //Behålla intag
            System.out.println("Ditt dagliga intag för att behålla din vikt är: " + suggestedCaloricIntake);
        } else if (goal == 2) { //Öka intag
            int caloriesForGain = suggestedCaloricIntake + 300;
            System.out.println("Ditt dagliga kaloriintag för att öka i vikt: " + caloriesForGain);

        } else if (goal == 3) { //Minska intag
            double intendedCaloricDeficitPerDay = getValidNumericInput("Ange hur stor kaloriunderskott du vill ha (i kalorier): ");
            double kilogramsToLose = getValidNumericInput("Ange hur många kilo du vill gå ner: ");


            double kgAttGåNer = getValidNumericInput("Ange hur många kilo du vill gå ner: ");
            int kalorierAttMinska = antalerKalorierTillDatum(kgAttGåNer);
            int totalaMängdenKalorierMinskning = suggestedCaloricIntake - kalorierAttMinska;

            System.out.println("Antal kalorier att minska: " + kalorierAttMinska + " Kalorier"
            + "\n Din totala mängd kalorier blir " + totalaMängdenKalorierMinskning);

        }
        Main.scanner.nextLine();
    }
}