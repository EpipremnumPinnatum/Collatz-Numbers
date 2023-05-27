import java.util.ArrayList;
import java.util.List;

public class CollatzNumber {

    private final int number;

    private boolean seriesIsCalculated;

    private List<Integer> series;

    private int numberOfSteps;

    public int getNumber() {
        return number;
    }
    public void setSeriesIsCalculated(boolean seriesIsCalculated) {
        this.seriesIsCalculated = seriesIsCalculated;
    }
    public List<Integer> getSeries() {
        return series;
    }
    public void setSeries(List<Integer> series) {
        this.series = series;
    }
    public int getNumberOfSteps() {
        return numberOfSteps;
    }
    public void setNumberOfSteps(int numberOfSteps) {
        this.numberOfSteps = numberOfSteps;
    }

    public CollatzNumber(int number){
        this.number = number;
        seriesIsCalculated =false;
        numberOfSteps = -1;
        series = new ArrayList<Integer>();
    }

    private calculateCollatz(){

    }


}
