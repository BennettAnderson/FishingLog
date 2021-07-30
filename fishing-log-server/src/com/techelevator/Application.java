package com.bennettanderson;

import com.bennettanderson.view.MenuDrivenCLI;

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
                    tripLog.tripDataInput();
                    break;
                case MAIN_MENU_OPTION_PRINT_REPORTS:
                    tripLog.printTripReports();
                    break;
                case MAIN_MENU_OPTION_EXIT:
                    tripLog.printDataToFile(tripData);
                    System.exit(0);
            }
        }

    }

}

