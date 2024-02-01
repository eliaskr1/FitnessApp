package se.nackademin;

import java.util.Optional;

//import static se.nackademin.BMI_utils.*;

/**
 * En klass som kör igenom hela BMI programmet.
 */
public class BMI {

      /**
     * Metoden som kör igenom BMI programmet.
     */
    public static void BMIcalc() {
        //Frågar om vikt och längd.
        double weight = BMI_utils.getValidNumericInput(Optional.empty(), "Hur mycket väger du (i kg)?: ");
        double heightInCentimeters = BMI_utils.getValidNumericInput(Optional.empty(), "Hur lång är du (i cm)?: ");

        // Konvertera längden till meter för BMI-beräkning
        double heightInMeters = heightInCentimeters / 100.0;
        
        // Beräkna och skriv ut BMI
        int bmi = (int) BMI_utils.calculateBMI(weight, heightInMeters);
        System.out.println('\n' + "Ditt BMI är: " + bmi);

        // Hämta användarinput för kön, ålder och aktivitetsnivå
        char gender = BMI_utils.getValidGenderInput(Optional.empty());
        int age = BMI_utils.getValidIntegerInput(Optional.empty(), "Ange din ålder: ");

        // Beräkna och skriv ut rekommenderat dagligt kaloriintag baserat på användarinformation
        int activityLevel = BMI_utils.getValidActivityLevelInput(Optional.empty());
        int suggestedCaloricIntake = BMI_utils.suggestCaloricIntake(gender, age, weight, heightInMeters, activityLevel);
        System.out.println('\n' + "Baserat på din basalmetabolism, aktivitetsnivå och ålder är den rekommenderade kaloriintaget/dag: " + suggestedCaloricIntake + " kal"+'\n');
          
        // Hämta användarinput för viktrelaterat mål
        int goal = BMI_utils.getValidGoalInput(Optional.empty());

        if (goal == 1) { //Behålla intag
            System.out.println("Ditt dagliga intag för att behålla din vikt är: " + suggestedCaloricIntake);
        } else if (goal == 2) { //Öka intag
            int caloriesForGain = suggestedCaloricIntake + 300;
            System.out.println("Ditt dagliga kaloriintag för att öka i vikt: " + caloriesForGain);

        } else if (goal == 3) { //Minska intag
            
            // Hämta användarinput för viktminskningsmål
            double kgAttGåNer = BMI_utils.getValidNumericInput(Optional.empty(), "Ange hur många kilo du vill gå ner: ");

            // Beräkna antal kalorier att minska och uppdatera det totala dagliga kaloriintaget
            int kalorierAttMinska = BMI_utils.antalerKalorierTillDatum(kgAttGåNer);
            int totalaMängdenKalorierMinskning = suggestedCaloricIntake - kalorierAttMinska;

            System.out.println("Antal kalorier att minska: " + kalorierAttMinska + " Kalorier"
            + "\n Din totala mängd kalorier blir " + totalaMängdenKalorierMinskning);

        }
        System.out.println("Tryck på enter för att fortsätta...");
        Main.scanner.nextLine();
    }
}
