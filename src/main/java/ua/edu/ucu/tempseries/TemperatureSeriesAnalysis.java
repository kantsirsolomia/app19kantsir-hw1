package ua.edu.ucu.tempseries;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    double[] temperature;
    int lengthh;

    public TemperatureSeriesAnalysis() {
        this.temperature = new double[200];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperature = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }
//ckecked
    public double average() {
        if (temperature.length > 0) {
            double sum = 0;
            double average;
            for (double element : temperature) {
                sum += element;
            }
            return sum / temperature.length;
        } else throw new IllegalArgumentException();
    }
//non
    public double deviation() {
        if (temperature.length > 0) {
            double average;
            average = average();
            double sum = 0;
            for (int i = 0; i < temperature.length; i++) {
                sum += Math.pow((average - temperature[i]), 2);
            }
            double devi = Math.sqrt(sum /temperature.length) ;
            return devi;
        } else {
            throw new IllegalArgumentException();
        }
    }
//checked
    public double min() {
        if (temperature.length > 0) {
            double min = temperature[0];

            for (double element : temperature) {
                if (element<min) {
                    min = element;
                }
            }
            return min;
        } else {
            throw new IllegalArgumentException();
        }
    }
//checked
    public double max() {
        if (temperature.length > 0) {
            double max = temperature[0];

            for (double element : temperature) {
                if (element > max) {
                    max = element;
                }
            }
            return max;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToZero() {
        if (temperature.length > 0) {
            return findTempClosestToValue(0);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperature.length > 0) {
            double min = Math.abs(temperature[0]);
            for (int i = 0; i < temperature.length; i++) {
                if (min > Math.abs(temperature[i])) {
                    min = temperature[i];
                }
            }
            return min;
        } else {
            throw new IllegalArgumentException();
        }
    }
//checked
    public double[] findTempsLessThen(double tempValue) {
        int el = 0;
        int counter = 0;

        if (temperature.length > 0) {
            for (int i = 0; i < temperature.length; i++) {
                if (temperature[i] < tempValue) {
                    counter++;
                }
            }
            double[] smaller = new double[counter];
            for (int i=0;i<temperature.length; i++){
                if (temperature[i] < tempValue) {
                    smaller[el] = temperature[i];
                    el++;
                }
                if (counter==el){
                    return smaller;
                }
            }
        return null;

        }
        else {
            throw new IllegalArgumentException();
        }
    }
    //checked
        public double[] findTempsGreaterThen ( double tempValue){

            int el = 0;
            int counter = 0;

            if (temperature.length > 0) {
                for (int i = 0; i < temperature.length; i++) {
                    if (temperature[i] > tempValue) {
                        counter++;
                    }
                }
                double[] greater = new double[counter];
                for (int i=0;i<temperature.length; i++){
                    if (temperature[i] > tempValue) {
                        greater[el] = temperature[i];
                        el++;
                    }
                    if (counter==el){
                        return greater;
                    }
                }
                return null;

            }
            else {
                throw new IllegalArgumentException();
            }

        }

        public TempSummaryStatistics summaryStatistics () {
            if (temperature.length > 0) {

                return new TempSummaryStatistics(this);
            } else {
                throw new IllegalArgumentException();
            }
        }
//checked
        public int addTemps ( double...temps){
            int counter = 0;
            int temp_len = temperature.length;
            if (temperature.length >0){
                for (int i = 0;i<temperature.length;i++){
                    if(temperature[i]!= -273){
                        counter++;
                    }
                }

                for (int el= 0;el<temps.length;el++){
                    if(counter>=temp_len){
                        double[] t2 = Arrays.copyOf(temperature, temperature.length);
                        int tlen = temperature.length;
                        temperature = new double[counter*2];
                        temp_len = temperature.length;
                        for(int j=0;j<tlen ;j++){
                            temperature[j]=t2[j];
                        }
                    }
                    temperature[counter] = temps[el];
                    counter++;
                }
                return counter;

            }
            return 0;
        }


        }

