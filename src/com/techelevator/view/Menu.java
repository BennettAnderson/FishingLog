package com.techelevator.view;

import com.techelevator.Fish;
import com.techelevator.Trip;
import com.techelevator.TripLog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private PrintWriter out;
    private Scanner in;
    private File tripData = new File("savedTrips.txt");
    private TripLog tripLog = new TripLog(tripData);

    public TripLog getTripLog() {
        return tripLog;
    }

    public Menu(InputStream input, OutputStream output) throws FileNotFoundException {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();
        try {
            int selectedOption = Integer.parseInt(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch (NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
        }
        if (choice == null) {
            out.println("\n*** " + userInput + " is not a valid option ***\n");
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.print("\nPlease choose an option >>> ");
        out.flush();
    }

    public void tripDataInput() throws FileNotFoundException {
        out.print("Trip date: ");
        String tripDate = in.nextLine();

        out.print("Location: ");
        String userLocation = in.nextLine();

        out.print("Weather/Conditions: ");
        String weatherInput = in.nextLine();

        out.print("Add a fish to the log? [y/n]: ");
        String fishAdd = in.nextLine();
        List<Fish> catchList = new ArrayList<>();
        while (fishAdd.equalsIgnoreCase("y")) {
            out.print("Enter fish species caught: ");
            String fishCaught = in.nextLine();
            Fish fish = new Fish(fishCaught);
            catchList.add(fish);
            out.print("Lure/bait/fly used: ");
            String lureUsed = in.nextLine();
            fish.setLure(lureUsed);
            out.print("Approximate length (in): ");
            String length = in.nextLine();
            fish.setLength(length);
            out.print("Add another fish to the log? [y/n]: ");
            fishAdd = in.nextLine();
        }

        out.print("Input trip notes: ");
        String tripNotes = in.nextLine();
        out.println();
        Trip newTrip = new Trip(tripDate, userLocation, weatherInput, tripNotes, catchList);
        tripLog.addTrip(newTrip);

        tripLog.addTripToFile(newTrip);
    }
}
