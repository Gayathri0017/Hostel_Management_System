package hmspackage;
import java.util.Arrays;
import java.util.Scanner;
public class Hmsfees {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        FeesManagement fees = new FeesManagement();
        //comments passed
        while (true) {
            System.out.println("-----Hostel Fees Management-----");
            System.out.println("1) Set Food Preference");
            System.out.println("2) View Total Fees");
            System.out.println("3) Pay Fees");
            System.out.println("4) Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    System.out.print("Enter food preference (Veg/Non-Veg): ");
                    String preference = sc.next();
                    fees.setFoodPreference(roomNumber, preference);
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int roomNum = sc.nextInt();
                    fees.displayFees(roomNum);
                    break;
                case 3:
                    System.out.print("Enter room number: ");
                    int payRoom = sc.nextInt();

                    if (fees.isFeesPaid(payRoom)) {
                        System.out.println("Fees already paid for Room " + payRoom);
                        break;
                    }

                    System.out.print("Enter amount to pay: ");
                    int amount = sc.nextInt();
                    fees.payFees(payRoom, amount);
                    break;
                case 4:
                    System.out.println("Exiting Fees Management...");
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
	}
}
class FeesManagement {
    private static final int Room_Rent = 5000;
    private static final int Veg_Cost = 2000;
    private static final int Nonveg_Cost = 3000;
    private static final int Capacity = 50;

    private boolean[] hasFoodPreference;  
    private String[] foodPreference;
    private int[] balance;  

    FeesManagement() {
        hasFoodPreference = new boolean[Capacity];
        foodPreference = new String[Capacity];
        balance = new int[Capacity];
        Arrays.fill(balance, Room_Rent);  
    }

    public void setFoodPreference(int roomNumber, String preference) {
        if (roomNumber < 1 || roomNumber > Capacity) {
            System.out.println("Please choose a valid room number (1-50).");
            return;
        }
        if (!preference.equalsIgnoreCase("veg") && !preference.equalsIgnoreCase("non-veg")) {
            System.out.println("Please select Veg or Non-Veg.");
            return;
        }

        int foodCharge = preference.equalsIgnoreCase("veg") ? Veg_Cost : Nonveg_Cost;
        foodPreference[roomNumber - 1] = preference.toLowerCase();
        hasFoodPreference[roomNumber - 1] = true;
        balance[roomNumber - 1] = Room_Rent + foodCharge;  

        System.out.println("Food preference for Room " + roomNumber + " set to " + preference);
    }

    public void displayFees(int roomNumber) {
        if (roomNumber < 1 || roomNumber > Capacity) {
            System.out.println("Please choose a valid room number (1-50).");
            return;
        }

        int totalFees = Room_Rent;
        if (hasFoodPreference[roomNumber - 1]) {
            if ("veg".equals(foodPreference[roomNumber - 1])) {
                totalFees += Veg_Cost;
            } else {
                totalFees += Nonveg_Cost;
            }
        }

        System.out.println("Room Rent: " + Room_Rent);
        if (hasFoodPreference[roomNumber - 1]) {
        	if (foodPreference[roomNumber - 1].equals("veg")) {
        	    System.out.println("Food Charges: " + Veg_Cost);
        	} else {
        	    System.out.println("Food Charges: " + Nonveg_Cost);
        	}
        } else {
            System.out.println("No food preference set.");
        }
        System.out.println("Total Fees: " + totalFees);
        System.out.println("Remaining Balance: " + balance[roomNumber - 1]);
    }

    public void payFees(int roomNumber, int amount) {
        if (roomNumber < 1 || roomNumber > Capacity) {
            System.out.println("Please choose a valid room number (1-50).");
            return;
        }
        if (balance[roomNumber - 1] == 0) {
            System.out.println("Fees already paid for Room " + roomNumber);
            return;
        }
        if (amount >= balance[roomNumber - 1]) {
            System.out.println("Payment successful! Extra amount returned: " + (amount - balance[roomNumber - 1]));
            balance[roomNumber - 1] = 0;
        } else {
            balance[roomNumber - 1] -= amount;
            System.out.println("Payment successful. Remaining balance: " + balance[roomNumber - 1]);
        }
    }

    public boolean isFeesPaid(int roomNumber) {
        return balance[roomNumber - 1] == 0;
    }
}