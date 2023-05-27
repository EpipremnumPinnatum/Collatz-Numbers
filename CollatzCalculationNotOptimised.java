import java.util.ArrayList;
import java.util.List;

/**
 * This class calculates the Collatz numbers without optimization
 *
 *
 */

public class CollatzCalculationNotOptimised {


    private boolean isEven(int number){
        return number%2==0;
    }

    public ArrayList<Integer> calculateCollatzSeriesSuboptimally(int number){
        return new ArrayList<>();
    }

    /**
     * Calculates all the numbers through the Collatz algorithm and gives back list
     * with all the numbers it had to go through to finally reach 4,2,1
     * @param collatzNumber
     * @return list with all the numbers it had to go through
     */
    public void notOptimizedCollatzAlgorithm(CollatzNumber collatzNumber){
        List<Integer> seriesInProcess = new ArrayList<>();
        seriesInProcess.add(collatzNumber.getNumber());

        while(!areTheLastThreeNumbers42And1(seriesInProcess)){
            if (isEven(getTheLastNumberOftheList(seriesInProcess))){
                int evenNumber = getTheLastNumberOftheList(seriesInProcess);
                seriesInProcess.add(evenNumber/2);
            }else {
                int oddNumber = getTheLastNumberOftheList(seriesInProcess);
                seriesInProcess.add(oddNumber*3+1);
            }
        }
        collatzNumber.setNumberOfSteps(seriesInProcess.size()-1);//because the first number should not count as a step
        collatzNumber.setSeries(seriesInProcess);
        collatzNumber.setSeriesIsCalculated(true);
    }

    /**
     * checks if the last numbers in the series are 4,2,1
     * @param list
     * @return
     */
    private boolean areTheLastThreeNumbers42And1(List<Integer> list){
        if(!(getTheLastNumberOftheList(list)==1)) return false;
        if(!(list.get(list.size()-2)==2)) return false;
        return list.get(list.size() - 3) == 4;

    }

    private int getTheLastNumberOftheList(List<Integer> list){
        return list.get(list.size()-1);
    }



}
