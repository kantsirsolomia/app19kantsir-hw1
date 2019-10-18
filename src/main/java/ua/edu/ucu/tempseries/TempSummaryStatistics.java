package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    double avgTemp;
    double devTemp;
    double minTemp;
    double maxTemp;

    public TempSummaryStatistics(TemperatureSeriesAnalysis series) {
        avgTemp = series.average();
        devTemp = series.deviation();
        minTemp = series.min();
        maxTemp = series.max();
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }


}
