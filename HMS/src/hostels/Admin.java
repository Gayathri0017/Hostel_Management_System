package hostels;
import java.util.Scanner;
public class Admin {
	    private static final int MAX_EVENTS = 10;
	    private String[] eventNames = new String[MAX_EVENTS];
	    private String[] eventDates = new String[MAX_EVENTS];
	    private String[] eventVenues = new String[MAX_EVENTS];
	    private int eventCount = 0;
	    Scanner scanner = new Scanner(System.in);
	    public void createEvent() {
	        if (eventCount >= MAX_EVENTS) {
	           System.out.println("Event limit reached! Cannot add more events.");
	            return;
	        }
	        System.out.print("Enter Event Name: ");
	        eventNames[eventCount] = scanner.nextLine();
	        System.out.print("Enter Event Date (DD/MM/YYYY): ");
	        eventDates[eventCount] = scanner.nextLine();
	        System.out.print("Enter Event Venue: ");
	        eventVenues[eventCount] = scanner.nextLine();
	        eventCount++;
	        System.out.println("Event Created Successfully!");
	    }
	    public void displayEvents() {
	        if (eventCount == 0) {
	            System.out.println("No events available.");
	            return;
	        }
	        System.out.println("\n--- Event List ---");
	        for (int i = 0; i < eventCount; i++) {
	            System.out.println("Event " + (i + 1));
	            System.out.println("Name: " + eventNames[i]);
	            System.out.println("Date: " + eventDates[i]);
	            System.out.println("Venue: " + eventVenues[i]);
	            System.out.println("----------------------");

	        }

	    }
	    //Hmsfees.viewFees();
	}
