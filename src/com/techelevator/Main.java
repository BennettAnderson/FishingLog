package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        List<Trip> tripList = new ArrayList<>();

        System.out.println("#################################");
        System.out.println("Welcome to Bennett's fishing log.");
        System.out.println("#################################");

        // options: fill out trip report, print trip reports,
        System.out.println("[1] Add trip report\n[2] Print trip reports");
        String reportAdd = userInput.nextLine();

        while (reportAdd.equals("1")) {
            tripLogDataInput(tripList);
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
            System.out.println("** " + trip.getLocation() + " **");
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

    private static void tripLogDataInput(List<Trip> tripList) {
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

        System.out.println("Add fish to the log? [y/n]");
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
}
