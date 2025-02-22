package hostels;



import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Scanner;



class VistorManagement {

    private static List<Visitor> visitors = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);



    static class Visitor {

        String name;

        String inTime;

        String outTime;

        String studentID; // Added to store the student ID



        // Method to enter visitor details

        void enterDetails(String studentID) {

            Scanner sc = new Scanner(System.in);

            this.studentID = studentID; // Assign the student ID to the visitor



            System.out.print("Enter Visitor Name: ");

            name = sc.nextLine();



            // Validate and set the login time

            while (true) {

                System.out.print("Enter InTime (HH:MM): ");

                inTime = sc.nextLine();

                if (isValidTime(inTime)) {

                    break;

                } else {

                    System.out.println("Invalid time format. Please enter time in HH:MM format.");

                }

            }

        }



        // Method to enter and validate the logout time

        void exitDetails() {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.print("Enter OutTime (HH:MM) for " + name + ": ");

                String outTimeInput = sc.nextLine();

                if (isValidTime(outTimeInput)) {

                    if (isAfterEntryTime(outTimeInput)) {

                        this.outTime = outTimeInput;

                        break;

                    } else {

                        System.out.println("Exit time must be after the entry time.");

                    }

                } else {

                    System.out.println("Invalid time format. Please enter time in HH:MM format.");

                }

            }

        }



        // Method to display visitor details

        void displayDetails() {

            System.out.println("Visitor Name: " + name);

            System.out.println("Student ID: " + studentID); // Display the student ID

            System.out.println("InTime: " + inTime);

            System.out.println("OutTime: " + (outTime != null ? outTime : "Not recorded"));

        }



        // Helper method to validate time format (HH:MM)

        private boolean isValidTime(String time) {

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            timeFormat.setLenient(false);

            try {

                timeFormat.parse(time);

                return true;

            } catch (ParseException e) {

                return false;

            }

        }



        // Helper method to check if the logout time is after the login time

        private boolean isAfterEntryTime(String outTime) {

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            try {

                Date entry = timeFormat.parse(this.inTime);

                Date exit = timeFormat.parse(outTime);

                return exit.after(entry);

            } catch (ParseException e) {

                return false;

            }

        }

    }



    public static void main(String[] args) {

        while (true) {

            System.out.println("\nVisitor Management System");

            System.out.println("1. Log Entry of Visitor");

            System.out.println("2. Log Exit of Visitor");

            System.out.println("3. View Visitor Details");

            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume newline



            switch (choice) {

                case 1:

                    logEntry();

                    break;

                case 2:

                    logExit();

                    break;

                case 3:

                    viewVisitorDetails();

                    break;

                case 4:

                    System.out.println("Exiting Visitor Management System.");

                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

    }



    // Method to log entry of a visitor

    static void logEntry() {

        System.out.print("Enter Student ID: ");

        String studentID = scanner.nextLine();



        Visitor visitor = new Visitor();

        visitor.enterDetails(studentID); // Pass the student ID to the visitor

        visitors.add(visitor);

        System.out.println("Visitor entry logged successfully.");

    }



    // Method to log exit of a visitor

    static void logExit() {

        System.out.print("Enter Visitor Name: ");

        String visitorName = scanner.nextLine();



        for (Visitor visitor : visitors) {

            if (visitor.name.equalsIgnoreCase(visitorName)) {

                visitor.exitDetails();

                System.out.println("Visitor exit logged successfully.");

                return;

            }

        }

        System.out.println("Visitor not found.");

    }



    // Method to view visitor details for a particular student ID

    static void viewVisitorDetails() {

        System.out.print("Enter Student ID: ");

        String studentID = scanner.nextLine();



        boolean found = false;

        for (Visitor visitor : visitors) {

            if (visitor.studentID.equals(studentID)) {

                visitor.displayDetails();

                found = true;

            }

        }



        if (!found) {

            System.out.println("No visitors found for the given Student ID.");

        }

    }

}