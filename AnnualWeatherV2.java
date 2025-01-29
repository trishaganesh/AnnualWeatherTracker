package com.trishawrites;
/**
 * Annual Weather description: The purpose of this program is to prompt the user to enter a temperature scale of
 * either Fahrenheit or Celsius, and prompt the user to enter a precipitation scale of either Inches or Centimeters.
 * Based on the user's input, we will print the results accordingly, in the form of a data table.
 *
 * @author Trisha Ganesh
 * @version 6/19/2021
 *
 */

import java.util.Scanner;

public class AnnualWeatherV2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String chosenCity = "Orlando";
        String chosenState = "Florida";

        String monthsOfYear[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};


        double temperature[] = {60.9, 62.6, 67.4, 71.5, 77.1, 81.2, 82.4, 82.5, 81.1, 75.3, 68.8, 63.0};
        double precipitation[] = {2.4, 2.4, 3.5, 2.4, 3.7, 7.4, 7.2, 6.3, 5.8, 2.7, 2.3, 2.3};


        String tempLabel = "F";    //initialize to F
        String precipLabel = "in."; //initialize to in

        //ask user for temp and precipitation scale choice
        System.out.print("Choose the temperature scale (F = Fahrenheit, C = Celsius): ");
        String temperatureScale = in.next().toLowerCase();
        System.out.print("Choose the precipitation scale (i = inches, c = centimeteres): ");
        String precipitationScale = in.next().toLowerCase();

        double convertedTemp[] = convertTemp(temperatureScale, temperature);
        double convertedPrecipitation[] = convertPrecipitation(precipitationScale, precipitation);


        //Output: display table of weather data including average and total
        System.out.println();
        System.out.println("           Weather Data");
        System.out.println("      Location: " + chosenCity + ", " + chosenState);
        System.out.println("Month     Temperature (" + tempLabel + ")     Precipitation (" + precipLabel + ")");
        System.out.println();
        System.out.println("***************************************************");

        double sumOfTemperature = 0.0;
        double annualPrecipitation = 0.0;
        for (int index = 0; index < temperature.length && index < precipitation.length; index++) {
            //addition assignment operator for temperature and precipitation values
            sumOfTemperature += temperature[index];
            annualPrecipitation += precipitation[index];
        }

        //calculate average of temperature values (for both Fahrenheit and Celsius)
        double temperatureAverage = sumOfTemperature / temperature.length;

        //for loop to set index, identify months per year, and add incrementation for months, temperature, and precipitation to print values
        for (int index = 0; index < 12; index++) {
            System.out.printf("%s%14s%21s\n", monthsOfYear[index], convertedTemp[index], convertedPrecipitation[index]);
        }
        System.out.println();
        //round Temperature and Precipitation values to one decimal place
        double roundTemperatureAverage = temperatureAverage;
        double roundAnnualPrecipitation = annualPrecipitation;
        roundTemperatureAverage = Math.round(roundTemperatureAverage * 10.0) / 10.0;
        roundAnnualPrecipitation = Math.round(roundAnnualPrecipitation * 10.0) / 10.0;

        //Print Temperature and Precipitation results
        System.out.println("Average: " + roundTemperatureAverage + "\t" + "Annual: " + roundAnnualPrecipitation);
    }


    //method to convert the temperature to Celsius
    public static double[] convertTemp(String temperatureScale, double[] temperature) {
        //convert temperature from Fahrenheit to Celsius (for each index)
        if (temperatureScale.equals("f")) {
            for (int index = 0; index < 12; index++) {
                temperature[index] = (temperature[index] - 32) * 5 / 9;
                temperature[index] = ((int) temperature[index] * 10) / 10;
            }
        }
        return temperature;
    }

    //method to convert the precipitation to Centimeters
    public static double[] convertPrecipitation(String precipitationScale, double[] precipitation) {
        //convert precipitation from Inches to Centimeters (for each index)
        if (precipitationScale.equals("c")) {
            for (int index = 0; index < 12; index++) {
                precipitation[index] = precipitation[index]  * 2.54;
                precipitation[index] = ((int) precipitation[index]*10)/10;
            }
        }
        return precipitation;
    }
}


