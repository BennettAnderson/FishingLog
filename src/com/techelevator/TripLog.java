package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripLog {
    private static Scanner userInput = new Scanner(System.in);
    private static List<Trip> tripList = new ArrayList<>();

    public TripLog() {
    }

    public void populateTripList(File inputFile) {
        try (Scanner tripScanner = new Scanner(inputFile)) {
            while (tripScanner.hasNextLine()) {
                String line = tripScanner.nextLine();
                //date|String location|String weather|String comments|List<String> catchList
                String[] tripArray = line.split("\\|");
                Trip newTrip = new Trip(tripArray[0], tripArray[1], tripArray[2], tripArray[3]);
                String str = tripArray[4];
                String newStr = str.replaceAll("\\[", "");
                String newNewStr = newStr.replaceAll("]", "");
                String[] array = newNewStr.split(", ");
                for (String s : array) {
                    newTrip.addCatch(s);
                }
                tripList.add(newTrip);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading save file");
        }
    }

    public void printDataToFile(File inputFile) {
        try (PrintWriter printLine = new PrintWriter(inputFile)) {
            for (Trip trip : tripList) {
                printLine.println(trip.getDate() + "|" + trip.getLocation() + "|" +
                        trip.getWeather() + "|" + trip.getComments() + "|" + trip.getCatchList());
            }
        } catch (Exception e) {
            System.out.println("Cannot find file");
        }
    }

    public void tripDataInput() {
        System.out.print("Trip date: ");
        String tripDate = userInput.nextLine();

        System.out.print("Location: ");
        String userLocation = userInput.nextLine();

        System.out.print("Weather/Conditions: ");
        String weatherInput = userInput.nextLine();

        Trip newTrip = new Trip(userLocation);
        tripList.add(newTrip);
        newTrip.setDate(tripDate);
        newTrip.setWeather(weatherInput);

        System.out.print("Add a fish to the log? [y/n]: ");
        String fishAdd = userInput.nextLine();
        while (fishAdd.equalsIgnoreCase("y")) {
            System.out.print("Enter fish species caught: ");
            String fishCaught = userInput.nextLine();
            newTrip.addCatch(fishCaught);
            System.out.print("Add another fish to the log? [y/n]: ");
            fishAdd = userInput.nextLine();
        }

        System.out.print("Input trip notes: ");
        String tripNotes = userInput.nextLine();
        newTrip.setComments(tripNotes);
        System.out.println();
    }

    public void printTripReports() {
        System.out.println();
        System.out.println("####### Fishing Log #######");
        System.out.println();
        for (Trip trip : tripList) {
            System.out.println("*********************** " + trip.getLocation() + " ***********************");
            System.out.println("Date: " + trip.getDate());
            System.out.println("Weather Conditions: " + trip.getWeather());
            System.out.println("Catch: ");
            for (String fish : trip.getCatchList()) {
                System.out.println(" - " + fish);
            }
            System.out.println("Notes: " + trip.getComments());
            System.out.println();
        }
    }
}
