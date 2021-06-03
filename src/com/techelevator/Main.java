package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Trip> tripList = new ArrayList<>();
    private static File tripData = new File("savedTrips.txt");

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        // need to populate the list at startup
        populateTripList();

        System.out.println("#################################");
        System.out.println("Welcome to Bennett's fishing log.");
        System.out.println("#################################");

        // options: fill out trip report, print trip reports,
        System.out.println("[1] Add a trip report\n[2] Print trip reports");
        String reportAdd = userInput.nextLine();

        while (reportAdd.equals("1")) {
            tripDataInput(tripList);
            System.out.println("Add another trip report? [y/n]");
            String reportAddAnother = userInput.nextLine();
            if (reportAddAnother.equals("n")) {
                reportAdd = "2";
            }
        }

        // if user chooses to print reports and when the input trip data loop is finished, full fishing log is printed
        System.out.println();
        System.out.println("####### Fishing Log #######");
        System.out.println();
        for (Trip trip : tripList) {
            System.out.println("***** " + trip.getLocation() + " *****");
            System.out.println("Date: " + trip.getDate());
            System.out.println("Weather Conditions: " + trip.getWeather());
            System.out.println("Catch: ");
            for (String fish : trip.getCatchList()) {
                System.out.println(" - " + fish);
            }
            System.out.println("Notes: " + trip.getComments());
            System.out.println();
        }

        printDataToFile();
    }

    private static void tripDataInput(List<Trip> tripList) {
        System.out.println("Trip date: ");
        String tripDate = userInput.nextLine();

        System.out.println("Location: ");
        String userLocation = userInput.nextLine();

        System.out.println("Weather/Conditions: ");
        String weatherInput = userInput.nextLine();

        Trip newTrip = new Trip(userLocation);
        tripList.add(newTrip);
        newTrip.setDate(tripDate);
        newTrip.setWeather(weatherInput);

        System.out.println("Add a fish to the log? [y/n]");
        String fishAdd = userInput.nextLine();
        while (fishAdd.equals("y")) {
            System.out.println("Enter fish species caught: ");
            String fishCaught = userInput.nextLine();
            newTrip.addCatch(fishCaught);
            System.out.println("Add another fish to the log? [y/n]");
            fishAdd = userInput.nextLine();
        }

        System.out.println("Input trip notes: ");
        String tripNotes = userInput.nextLine();
        newTrip.setComments(tripNotes);
        System.out.println();
    }

    private static void populateTripList() throws FileNotFoundException {
        try (Scanner tripScanner = new Scanner(tripData)) {
            while (tripScanner.hasNextLine()) {
                String line = tripScanner.nextLine();
                //date|String location|String weather|String comments|List<String> catchList
                String[] tripArray = line.split("\\|");
                Trip newTrip = new Trip(tripArray[0], tripArray[1], tripArray[2], tripArray[3]);
                String str = tripArray[4];
                String newStr = str.replaceAll("\\[", "");
                String newNewStr = newStr.replaceAll("]", "");
                String[] array = newNewStr.split(". ");
                for (int i = 0; i < array.length; i++) {
                    newTrip.addCatch(array[i]);
                }
                tripList.add(newTrip);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading save file");
        }

    }

    private static void printDataToFile() {
        try (PrintWriter printLine = new PrintWriter(tripData)) {
            for (int i = 0; i < tripList.size(); i++) {
                Trip trip = tripList.get(i);
                printLine.println(trip.getDate() + "|" + trip.getLocation() + "|" +
                        trip.getWeather() + "|" + trip.getComments() + "|" + trip.getCatchList());
            }
        } catch (Exception e) {
            System.out.println("Cannot find file");
        }
    }

}
