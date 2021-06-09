package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripLog {
    private static List<Trip> tripList = new ArrayList<>();
    private File dataFile;

    public TripLog(File tripReports) throws FileNotFoundException {
        populateTripLog(tripReports);
        this.dataFile = tripReports;
    }

    public void populateTripLog(File inputFile) throws FileNotFoundException {
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
                    newTrip.addCatch(fish);
                }
                tripList.add(newTrip);
            }
        }
    }

    public void addTripToFile(Trip trip) throws FileNotFoundException {
        try (PrintWriter printLine = new PrintWriter(dataFile)) {
            StringBuilder catchStr = new StringBuilder();
            for (Fish fish : trip.getCatchList()) {
                catchStr.append(fish.fishDataString());
            }
            printLine.println(trip.getDate() + "|" + trip.getLocation() + "|" +
                    trip.getWeather() + "|" + trip.getComments() + "|" + catchStr);

        }

    }
    public void addTrip(Trip trip) {
        tripList.add(trip);

    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("\n####### Fishing Log #######\n");
        for (Trip trip : tripList) {
            list.append(trip.toString());
        }
        return list.toString();
    }
}
