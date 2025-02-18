package hostels;
import java.util.*;
import java.lang.*;
class Request {
    int requestID;
    String issueDescription;
    String status;

    public Request(int requestID, String issueDescription) {
        this.requestID = requestID;
        this.issueDescription = issueDescription;
        this.status = "Pending";
    }
}

public class Maintenance {
    private static final int MAX_REQUESTS = 20;
    private static Request[] requests = new Request[MAX_REQUESTS];
    private static int requestCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nRequest Management System");
            System.out.println("1. Raise a Request (Student)");
            System.out.println("2. View Requests (Warden)");
            System.out.println("3. Update Request Status (Warden)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    raiseRequest();
                    break;
                case 2:
                    viewRequests();
                    break;
                case 3:
                    updateRequestStatus();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void raiseRequest() {
        if (requestCount >= MAX_REQUESTS) {
            System.out.println("Request limit reached. Cannot raise more requests.");
            return;
        }

        System.out.print("Enter issue description: ");
        String issueDescription = scanner.nextLine();

        requests[requestCount] = new Request(requestCount + 1, issueDescription);
        System.out.println("Request raised successfully! Request ID: " + (requestCount + 1));
        requestCount++;
    }

    private static void viewRequests() {
        if (requestCount == 0) {
            System.out.println("No requests available.");
            return;
        }

        System.out.println("\nList of Requests:");
        for (int i = 0; i < requestCount; i++) {
            System.out.println("Request ID: " + requests[i].requestID);
            System.out.println("Issue: " + requests[i].issueDescription);
            System.out.println("Status: " + requests[i].status);
            System.out.println("----------------------");
        }
    }

    private static void updateRequestStatus() {
        if (requestCount == 0) {
            System.out.println("No requests available.");
            return;
        }

        System.out.print("Enter Request ID to update: ");
        int requestID = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < requestCount; i++) {
            if (requests[i].requestID == requestID) {
                System.out.print("Enter new status (Pending/Resolved): ");
                String newStatus = scanner.nextLine();
                requests[i].status = newStatus;
                System.out.println("Request updated successfully!");
                return;
            }
        }

        System.out.println("Request ID not found.");
    }
}

