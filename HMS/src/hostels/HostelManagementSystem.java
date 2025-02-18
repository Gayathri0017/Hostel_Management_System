package hostels;
import java.util.Scanner;

public class HostelManagementSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hostel Management System!");
        
        int role = chooseUserRole(sc); // User selects role at the start

        // Ensure user is registered and logged in before proceeding
        if (!handleUserAuthentication(sc)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        switch (role) {
            case 1:
                adminOperations(sc);
                break;
            case 2:
                wardenOperations(sc);
                break;
            case 3:
                studentOperations(sc);
                break;
            default:
                System.out.println("Invalid role. Exiting...");
        }

        sc.close();
    }

    // Function to let user choose role
    private static int chooseUserRole(Scanner sc) {
        int role;
        do {
            System.out.println("Select your role:");
            System.out.println("1) Admin");
            System.out.println("2) Warden");
            System.out.println("3) Student");
            System.out.print("Enter choice: ");
            role = sc.nextInt();
            if (role < 1 || role > 3) {
                System.out.println("Invalid choice! Please enter a valid role.");
            }
        } while (role < 1 || role > 3);
        
        return role;
    }

    // Handles user authentication (ensures registration and login)
    private static boolean handleUserAuthentication(Scanner sc) {
        boolean isAuthenticated = false;

        while (!isAuthenticated) {
            System.out.println("\n1) Register\n2) Login");
            int option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                UserType.register(); 
                System.out.println("Registration successful! Please log in to continue.");
            } else if (option == 2) {
                UserType.login();
                isAuthenticated = true;
            } else {
                System.out.println("Please enter a valid choice!");
            }
        }

        return true;
    }
    private static void adminOperations(Scanner sc) {
        int adminChoice;
        do {
            System.out.println("\nAdmin Panel:");
            System.out.println("1) View Students Records");
            System.out.println("2) View Room Details");
            System.out.println("3) View Fees Records");
            System.out.println("4) View Complaints");
            System.out.println("5) Exit");
            System.out.print("Enter choice: ");
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
                    System.out.println("Exiting Admin Panel...");
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
            }
        } while (adminChoice != 5);
    }

    // Warden Menu
    private static void wardenOperations(Scanner sc) {
        Warden w=new Warden();
        w.manageRooms();
    }
    // Student Menu
    private static void studentOperations(Scanner sc) {
        int studentChoice;
        do {
            System.out.println("\nStudent Panel:");
            System.out.println("1) View Room Details");
            System.out.println("2) Make Payment");
            System.out.println("3) Raise Complaint");
            System.out.println("4) Exit");
            System.out.print("Enter choice: ");
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
                    System.out.println("Exiting Student Panel...");
                    break;
                default:
                    System.out.println("Please enter a valid choice.");
            }
        } while (studentChoice != 4);
    }
}

