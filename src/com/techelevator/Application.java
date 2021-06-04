package com.techelevator;

import com.techelevator.view.MenuDrivenCLI;

import java.io.File;
import java.util.Scanner;

public class Application {

    private static final String MAIN_MENU_OPTION_ADD_TRIP_REPORT = "Add a trip report";
    private static final String MAIN_MENU_OPTION_PRINT_REPORTS = "View trip reports";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit and save";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_ADD_TRIP_REPORT, MAIN_MENU_OPTION_PRINT_REPORTS, MAIN_MENU_OPTION_EXIT};

    private final MenuDrivenCLI ui = new MenuDrivenCLI();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        // need to populate the list at startup
        File tripData = new File("savedTrips.txt");
        TripLog tripLog = new TripLog();
        tripLog.populateTripList(tripData);
        System.out.println("#################################");
        System.out.println("Welcome to Bennett's fishing log.");
        System.out.println("#################################");

        while (true) {
            String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);
            if (selection.equals(MAIN_MENU_OPTION_ADD_TRIP_REPORT)) {
                tripLog.tripDataInput();
            } else if (selection.equals(MAIN_MENU_OPTION_PRINT_REPORTS)) {
                tripLog.printTripReports();
            } else if (selection.equals(MAIN_MENU_OPTION_EXIT)) {
                tripLog.printDataToFile(tripData);
                System.exit(0);
            }
        }

    }

}

