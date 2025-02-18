package hostels;
import java.util.*;

public class HostelManagementSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hostel Management System!");
        System.out.println("Enter your role:\n1) Admin\n2) Warden\n3) Student");
        int role = sc.nextInt();

        UserType u = new UserType();

        switch (role) {
            case 1: // Admin
                if (handleUserAuthentication(u, sc)) {  
                    int adminChoice = 0;
                    while (adminChoice != 5) {
                        System.out.println("What do you want to do with the application:\n1) View Students Records\n2) View Room Details\n3) View Fees Records\n4) View Complaints\n5) Exit");
                        adminChoice = sc.nextInt();

                        switch (adminChoice) {
                            case 1:
                                // Implement View Student Records
                                break;
                            case 2:
                                // Implement View Room Details
                                break;
                            case 3:
                                // Implement View Fees Records
                                break;
                            case 4:
                                // Implement View Complaints
                                break;
                            case 5:
                                System.out.println("Thank you!!");
                                break;
                            default:
                                System.out.println("Please enter a valid choice.");
                        }
                    }
                }
                break;

            case 2: // Warden
                if (handleUserAuthentication(u, sc)) {  
                    int wardenChoice = 0;
                    while (wardenChoice != 4) {
                        System.out.println("What do you want to do with your application:\n1) Allocate Room\n2) View Complaints\n3) Track Visitors\n4) Exit");
                        wardenChoice = sc.nextInt();

                        switch (wardenChoice) {
                            case 1:
                                // Implement Allocate Room
                                break;
                            case 2:
                                // Implement View Complaints
                                break;
                            case 3:
                                // Implement Track Visitors
                                break;
                            case 4:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Please enter a valid choice.");
                        }
                    }
                }
                break;

            case 3: // Student
                if (handleUserAuthentication(u, sc)) {  
                    int studentChoice = 0;
                    while (studentChoice != 4) {
                        System.out.println("What do you want to do with your application:\n1) View Room Details\n2) Make Payment\n3) Raise Complaint\n4) Exit");
                        studentChoice = sc.nextInt();

                        switch (studentChoice) {
                            case 1:
                                // Implement View Room Details
                                break;
                            case 2:
                                // Implement Make Payment
                                break;
                            case 3:
                                // Implement Raise Complaint
                                break;
                            case 4:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Please enter a valid choice.");
                        }
                    }
                }
                break;

            default:
                System.out.println("Invalid role selection! Please restart the program.");
        }

        sc.close(); // Close scanner to prevent memory leak
    }

    // Handles user authentication and ensures login validation
    private static boolean handleUserAuthentication(UserType u, Scanner sc) {
        boolean isAuthenticated = false;

        while (!isAuthenticated) {
            System.out.println("1) Register\n2) Login");
            int option = sc.nextInt();

            if (option == 1) {
                u.register();
                System.out.println("Registration successful. Please log in.");
            } else if (option == 2) {
                isAuthenticated = u.login(); // Checks if login is successful
                if (!isAuthenticated) {
                    System.out.println("Invalid credentials! Please try again.");
                }
            } else {
                System.out.println("Please enter a valid choice!");
            }
        }

        return true; // User is now logged in
    }
}

