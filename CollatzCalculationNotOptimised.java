import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class calculates the Collatz numbers without optimization
 */

public class CollatzCalculationNotOptimised {
    // Store calculated Collatz lengths in a map to avoid duplicate calculations.
    private Map<Integer, Integer> collatzLengths = new HashMap<>();

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    // In dieser optimierten Version speichern wir die Länge der Collatz-Folge für jede Zahl in einer HashMap.
    // Wenn wir die Länge einer Zahl berechnen müssen, die wir bereits zuvor berechnet haben, geben wir einfach
    // den gespeicherten Wert zurück, anstatt die Berechnung erneut durchzuführen. Das führt zu einer signifikanten
    // Verbesserung der Laufzeit, besonders wenn wir eine grosse Anzahl von Zahlen betrachten.
    public int calculateCollatzSeriesSuboptimally(int number) {
        int maxLength = 0;
        int numberWithMaxLength = 0;

        for (int i = 1; i <= x; i++) {
            int length = getCollatzLength(i);
            if (length > maxLength) {
                maxLength = length;
                numberWithMaxLength = i;
            }
        }

        return numberWithMaxLength;
    }

    /**
     * Calculates all the numbers through the Collatz algorithm and gives back list
     * with all the numbers it had to go through to finally reach 4,2,1
     *
     * @param collatzNumber
     * @return list with all the numbers it had to go through
     */
    public void notOptimizedCollatzAlgorithm(CollatzNumber collatzNumber) {
        List<Integer> seriesInProcess = new ArrayList<>();
        seriesInProcess.add(collatzNumber.getNumber());

        while (!areTheLastThreeNumbers42And1(seriesInProcess)) {
            if (isEven(getTheLastNumberOftheList(seriesInProcess))) {
                int evenNumber = getTheLastNumberOftheList(seriesInProcess);
                seriesInProcess.add(evenNumber / 2);
            } else {
                int oddNumber = getTheLastNumberOftheList(seriesInProcess);
                seriesInProcess.add(oddNumber * 3 + 1);
            }
        }
        collatzNumber.setNumberOfSteps(seriesInProcess.size() - 1);//because the first number should not count as a step
        collatzNumber.setSeries(seriesInProcess);
        collatzNumber.setSeriesIsCalculated(true);
    }

    /**
     * checks if the last numbers in the series are 4,2,1
     *
     * @param list
     * @return
     */
    private boolean areTheLastThreeNumbers42And1(List<Integer> list) {
        if (!(getTheLastNumberOftheList(list) == 1)) return false;
        if (!(list.get(list.size() - 2) == 2)) return false;
        return list.get(list.size() - 3) == 4;

    }

    private int getTheLastNumberOftheList(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    private int getCollatzLength(int number) {
        if (number == 1) {
            return 1;
        }

        // If the length is already calculated, use it.
        if (collatzLengths.containsKey(number)) {
            return collatzLengths.get(number);
        }

        // Otherwise, calculate the length.
        int length;
        if (number % 2 == 0) {
            length = 1 + getCollatzLength(number / 2);
        } else {
            length = 1 + getCollatzLength(3 * number + 1);
        }

        // Store the calculated length in the map and return it.
        collatzLengths.put(number, length);
        return length;
    }
}
