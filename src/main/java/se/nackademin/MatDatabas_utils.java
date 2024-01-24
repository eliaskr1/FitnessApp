package se.nackademin;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.round;

/**
 * Klassen skapar vår matdatabas med instansvariabler, konstruktorer och metoder.
 * <p>
 * Privat variabel av typen map som säkert objekt, kan ej nås i andra klasser.
 * </p>
 * <p>
 * Konstruktorn Matdatabas-utils skapar foodMap som instans av HashMap.
 * </p>
 * <p>
 * Metod addfood lägger till nycklar och värden i avbildninstabell
 * </p>
 */

public class MatDatabas_utils {

    private static Map<String, Double> foodMap;

    public MatDatabas_utils() {
        foodMap = new HashMap<>();
    }

    public void addFood(String foodName, double caloriesPer100Grams) {
        foodMap.put(getFirstWord(foodName).toLowerCase(), caloriesPer100Grams);
    }

    /**
     * Metoden är en getter som inhämtar information om mat i map
     * <p>Metoden getOrDefault returnerar 0.0, för att undvika få nullvärde om nyckeln saknas.</p>
     * @param foodName matar in sträng som används som nyckel i map
     * @return värdet kalorier av typen double
     */
    public double getCalories(String foodName) {
        return foodMap.getOrDefault(getFirstWord(foodName).toLowerCase(), 0.0);
    }

    /**
     *  Metoden gör en formatterad utskrift av mapp med numrerade nycklar i block av 5.
     */
    public static void displayFoodList() {
        int count = 0;
        int index = 1;

        for (String food : foodMap.keySet()) {

            System.out.printf("|| %02d %-17s", index, capitalFirstLetter(food)); // Justerat formatet
            index++;

            count++;

            // Om 5 produkter har skrivits ut, radbrytning och återställning av count.
            if (count % 5 == 0) {
                System.out.print("||");
                System.out.println();
                count = 0;
            }
        }
    }

    /**
     * Metoden räknar ut total mängd kalorier för en viss matprodukt.
     * @param foodName matprodukt
     * @param amountInGrams user inmatning av intagna gram av matprodukt
     * <p>
     * Första If satsen hanterar inmatning av null-värden genom att kasta exception.
     * Andra If satsen hämtar nycklar och värden.
     * Else sats returnerar 0 ifall produkten inte finns i databasen.
     * </p>
     * @return avrundat antal intagna kalorier av vald produkt efter matteräkning
     */
    public static double calculateCalories(String foodName, double amountInGrams) {
        if (foodName == null) {
            throw new IllegalArgumentException("Null-värden ej tillåtna");
        }
        // Kontrollera om maten finns i databasen
        if (foodMap.containsKey(foodName.toLowerCase())) {
            double caloriesPer100Grams = foodMap.get(foodName.toLowerCase());
            return round((caloriesPer100Grams / 100.0) * amountInGrams);
        } else {
            System.out.println("Maten hittades inte i databasen.");
            return 0;
        }
    }

    /**
     * Booleansk metod för att säkerställa att en sträng siffra kan konverteras till integer
     * @param str tar emot siffran som sträng
     * <p>
     * Metoden fångar upp undantag om konvertering är ej möjlig.
     * </p>
     * @return värdet Sant vid lyckad konvertering
     */
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Metod för att parsa siffra till produkt i matdatabas
     * @param selectedProductInt siffra angett av user
     * <p>
     * En for-loop kopplar siffran till en produkt.
     * </p>
     * @return den matchande produkten eller null vid misslyckande
     */
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

    /**
     * Metod inhämtar första ordet i en sträng genom att splittra en sträng array
     * @param input sträng som ska splittras
     * @return första elementet i arrayen
     */

    private static String getFirstWord(String input) {
        return input.split("\\s+")[0];
    }

    /**
     * Metoden tar emot Sträng och omvandlar första bokstav till versal
     * @param input inmatning av sträng
     * @return sträng med första bokstav i versal
     */
    private static String capitalFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}