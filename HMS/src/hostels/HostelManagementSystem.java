package hostels;
import java.util.Scanner;
//import com.hostels.*;
public class HostelManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hostel Management System!");
        int role = chooseUserRole(sc);
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
    protected static int chooseUserRole(Scanner sc) {
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
    protected static boolean handleUserAuthentication(Scanner sc) {
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.println("1)Register\n2) Login");
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
        protected static void adminOperations(Scanner sc) {
            Hmsfees f = new Hmsfees();
            Admin admin = new Admin();
            Maintenance m=new Maintenance();
            int adminChoice;
            do {
                System.out.println("\nAdmin Panel:");
                System.out.println("1) Create Event");
                System.out.println("2) View Events");
                System.out.println("3) View Fees Records");
                System.out.println("4) View Complaints");
                System.out.println("5) Exit");
                System.out.print("Enter choice: ");
                adminChoice = sc.nextInt();
                sc.nextLine(); // Consume newline
                switch (adminChoice) {
                    case 1:
                        admin.createEvent();
                        break;
                    case 2:
                        admin.displayEvents();
                        break;
                    case 3:
                        System.out.println("Enter student index to get fee status");
                        String index = sc.nextLine();
                        f.viewFees(index);
                        break;
                    case 4:
                        m.viewRequests();
                        break;
                    case 5:
                        System.out.println("Exiting Admin Panel...");
                        break;
                    default:
                        System.out.println("Please enter a valid choice.");
                }
            } while (adminChoice != 5);
   
    }

    protected static void wardenOperations(Scanner sc) {
        Warden warden = new Warden();
        warden.manageRooms();
    }
    protected static void studentOperations(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();
        Student student = new Student(studentID);
        student.manageStudent();
        
    }

}