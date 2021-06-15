package com.techelevator;

import com.techelevator.view.MenuDrivenCLI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Application {

    private static final String MAIN_MENU_OPTION_ADD_TRIP_REPORT = "Add a trip report";
    private static final String MAIN_MENU_OPTION_PRINT_REPORTS = "View trip reports";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit and save";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_ADD_TRIP_REPORT, MAIN_MENU_OPTION_PRINT_REPORTS, MAIN_MENU_OPTION_EXIT};

    private final MenuDrivenCLI ui = new MenuDrivenCLI();
    private static Scanner userInput = new Scanner(System.in);
    private List<Trip> tripList = new ArrayList<>();
    private File tripData = new File("savedTrips.txt");

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        // need to populate the list at startup
        populateTripList(tripData);
        System.out.println("\n" +
                " ______                                 _         _______ _      _     _                _                  \n" +
                "(____  \\                         _   _ ( )       (_______|_)    | |   (_)              | |                 \n" +
                " ____)  ) ____ ____  ____   ____| |_| ||/  ___    _____   _  ___| | _  _ ____   ____   | |      ___   ____ \n" +
                "|  __  ( / _  )  _ \\|  _ \\ / _  )  _)  _) /___)  |  ___) | |/___) || \\| |  _ \\ / _  |  | |     / _ \\ / _  |\n" +
                "| |__)  | (/ /| | | | | | ( (/ /| |_| |__|___ |  | |     | |___ | | | | | | | ( ( | |  | |____| |_| ( ( | |\n" +
                "|______/ \\____)_| |_|_| |_|\\____)\\___)___|___/   |_|     |_(___/|_| |_|_|_| |_|\\_|| |  |_______)___/ \\_|| |\n" +
                "                                                                              (_____|               (_____|\n");

        while (true) {
            String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);
            switch (selection) {
                case MAIN_MENU_OPTION_ADD_TRIP_REPORT:
                    tripDataInput();
                    printDataToFile(tripData);
                    break;
                case MAIN_MENU_OPTION_PRINT_REPORTS:
                    printTripReports();
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    printDataToFile(tripData);
                    System.exit(0);
            }
        }

    }

    public void populateTripList(File inputFile) {
        try (Scanner tripScanner = new Scanner(inputFile)) {
            while (tripScanner.hasNextLine()) {
                String line = tripScanner.nextLine();
                String[] tripArray = line.split("\\|");
                Trip newTrip = new Trip(tripArray[0], tripArray[1], tripArray[2], tripArray[3]);
                String str = tripArray[4];
                String[] array = str.split("\\^");
                for (String s : array) {
                    String[] strArray = s.split(", ");
                    Fish fish = new Fish(strArray[0], strArray[1], strArray[2]);
                    newTrip.getCatchList().add(fish);
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
                StringBuilder catchStr = new StringBuilder();
                for (Fish fish : trip.getCatchList()) {
                    catchStr.append(fish.fishDataString());
                }
                printLine.println(trip.getDate() + "|" + trip.getLocation() + "|" +
                        trip.getWeather() + "|" + trip.getComments() + "|" + catchStr);
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
            Fish fish = new Fish(fishCaught);
            newTrip.addFish(fish);
            System.out.print("Lure/bait/fly used: ");
            String lureUsed = userInput.nextLine();
            fish.setLure(lureUsed);
            System.out.print("Approximate length (in): ");
            String length = userInput.nextLine();
            fish.setLength(length);
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
            for (Fish fish : trip.getCatchList()) {
                System.out.println(" - " + fish.getSpecies() + " | " + fish.getLength() + "\" | " + fish.getLure());
            }
            System.out.println("Notes: " + trip.getComments());
            System.out.println();
        }
    }

}

