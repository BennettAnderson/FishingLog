package com.bennettanderson;

import com.bennettanderson.model.*;
import com.bennettanderson.view.Menu;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.sql.DataSource;
import java.util.*;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

//    private static final String MAIN_MENU_OPTION_ADD_TRIP_REPORT = "Add a trip report";
//    private static final String MAIN_MENU_OPTION_PRINT_REPORTS = "View trip reports";
//    private static final String MAIN_MENU_OPTION_PRINT_ALL_FISH = "View all fish caught";
//    private static final String MAIN_MENU_OPTION_EXIT = "Exit and save";
//    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_ADD_TRIP_REPORT, MAIN_MENU_OPTION_PRINT_REPORTS, MAIN_MENU_OPTION_PRINT_ALL_FISH, MAIN_MENU_OPTION_EXIT};
//
//    private final Menu menu;
//    private final TripDao tripDao;
//    private final FishDao fishDao;

//    public static void main(String[] args) {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/FishDB");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres1");
//
//        Application application = new Application(dataSource);
//        application.run();
//    }
//
//    public Application(DataSource dataSource) {
//        this.menu = new Menu(System.in, System.out);
//        tripDao = new JdbcTripDao(dataSource);
//        fishDao = new JdbcFishDao(dataSource);
//    }
//
//    private void run() {
//        displayApplicationBanner();
//
//        while (true) {
//            String selection = menu.promptForSelection(MAIN_MENU_OPTIONS);
//            switch (selection) {
//                case MAIN_MENU_OPTION_ADD_TRIP_REPORT:
//                    tripDataInput();
//                    break;
//                case MAIN_MENU_OPTION_PRINT_REPORTS:
//                    printTripReports();
//                    break;
//                case MAIN_MENU_OPTION_PRINT_ALL_FISH:
//                    printAllFish();
//                    break;
//                case MAIN_MENU_OPTION_EXIT:
//                    System.exit(0);
//            }
//        }
//
//    }
//
//    private void displayApplicationBanner() {
//        System.out.println("\n" +
//                " ______                                 _         _______ _      _     _                _                  \n" +
//                "(____  \\                         _   _ ( )       (_______|_)    | |   (_)              | |                 \n" +
//                " ____)  ) ____ ____  ____   ____| |_| ||/  ___    _____   _  ___| | _  _ ____   ____   | |      ___   ____ \n" +
//                "|  __  ( / _  )  _ \\|  _ \\ / _  )  _)  _) /___)  |  ___) | |/___) || \\| |  _ \\ / _  |  | |     / _ \\ / _  |\n" +
//                "| |__)  | (/ /| | | | | | ( (/ /| |_| |__|___ |  | |     | |___ | | | | | | | ( ( | |  | |____| |_| ( ( | |\n" +
//                "|______/ \\____)_| |_|_| |_|\\____)\\___)___|___/   |_|     |_(___/|_| |_|_|_| |_|\\_|| |  |_______)___/ \\_|| |\n" +
//                "                                                                              (_____|               (_____|\n");
//
//    }

    //    public void populateTripList(File inputFile) {
//        try (Scanner tripScanner = new Scanner(inputFile)) {
//            while (tripScanner.hasNextLine()) {
//                String line = tripScanner.nextLine();
//                String[] tripArray = line.split("\\|");
//                Trip newTrip = new Trip(tripArray[0], tripArray[1], tripArray[2], tripArray[3]);
//                String str = tripArray[4];
//                String[] array = str.split("\\^");
//                for (String s : array) {
//                    long[] strArray = s.split(", ");
//                    Fish fish = new Fish(strArray[0], strArray[1], strArray[2]);
//                    newTrip.getCatchList().add(fish);
//                }
//                tripList.add(newTrip);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Error reading save file");
//        }
//    }
//
//    public void printDataToFile(File inputFile) {
//        try (PrintWriter printLine = new PrintWriter(inputFile)) {
//            for (Trip trip : tripList) {
//                StringBuilder catchStr = new StringBuilder();
//                for (Fish fish : trip.getCatchList()) {
//                    catchStr.append(fish.fishDataString());
//                }
//                printLine.println(trip.getDate() + "|" + trip.getLocation() + "|" +
//                        trip.getWeather() + "|" + trip.getComments() + "|" + catchStr);
//            }
//        } catch (Exception e) {
//            System.out.println("Cannot find file");
//        }
//    }
//
//    public void tripDataInput() {
//        String tripDate = getUserInput("Trip Date: ");
//
//        String userLocation = getUserInput("Location: ");
//
//        String weatherInput = getUserInput("Weather/Conditions: ");
//
//        String tripNotes = getUserInput("Input trip notes: ");
//
//        Trip trip = new Trip();
//        trip.setDate(tripDate);
//        trip.setLocation(userLocation);
//        trip.setWeather(weatherInput);
//        trip.setComments(tripNotes);
//
//        Trip newTrip = tripDao.addTrip(trip);
//        long tripId = newTrip.getTripId();
//
//        String fishAdd = getUserInput("Add a fish to the log? [y/n]: ");
//        while (fishAdd.equalsIgnoreCase("y")) {
//            String fishCaught = getUserInput("Enter fish species caught: ");
//            Fish fish = new Fish(fishCaught);
//            String lureUsed = getUserInput("Lure/bait/fly used: ");
//            fish.setLure(lureUsed);
//            long length = Long.parseLong(getUserInput("Approximate length (in): "));
//            fish.setLength(length);
//
//            fishDao.addFish(fish, tripId);
//
//            fishAdd = getUserInput("Add another fish to the log? [y/n]: ");
//        }
//
//        System.out.println();
//    }
//
//    private void printTripReports() {
//        System.out.println();
//        System.out.println("############### Fishing Log ###############");
//        System.out.println();
//        for (Trip trip : tripDao.getAllTrips()) {
//            System.out.println(trip.toString());
//            System.out.println("Catch: ");
//            long newId = trip.getTripId();
//            for (Fish fish : fishDao.getFishFromTrip(newId)) {
//                System.out.println(fish.toString());
//            }
//        }
//    }
//
//    private void printAllFish() {
//        System.out.println("\n-------------------\n All Fish Caught\n-------------------\n");
//        for (Fish fish : fishDao.getAllFish()) {
//            System.out.println(fish.toString() + "  --  location: " + fishDao.getLocationFromFish(fish.getFishId()));
//        }
//    }
//
//    private String getUserInput(String prompt) {
//        System.out.print(prompt + " >>> ");
//        return new Scanner(System.in).nextLine();
//    }
//
//}

