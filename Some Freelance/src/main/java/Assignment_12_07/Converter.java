package Assignment_12_07;

public class Converter {


    public double cmToInch(double x){
        return x*0.3937007874;
    }
    public double inchToCm(double x){
        return x*2.54;
    }
    public double meterToYard(double x){
        return x*1.0936;
    }
    public double yardToMeter(double x){
        return x*0.9144;
    }
    public double celsiusToFahrenheit(double x){
        return (x*1.8000) + 32.00;
    }
    public double fahrenheitToCelsius(double x){
        return (x-32) / 1.8;
    }
}