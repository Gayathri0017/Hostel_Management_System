package hostels;
import java.util.Scanner;
public class Warden {
    private Scanner sc=new Scanner(System.in);
    private Rooms roomManager;
    public Warden(){
        roomManager=new Rooms();
      }
    public void manageRooms() {
        while(true){
            System.out.println("\n-----Warden Room Management-----");
            System.out.println("1) View Rooms");
            System.out.println("2) Allocate a Room");
            System.out.println("3) Vacate a Room");
            System.out.println("4) Exit");
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    roomManager.displayRooms();
                    break;
                case 2:
                	System.out.println("Do you want to allocate 1)Single room\n2)Shared room(4 in a room)");
                	int ch=sc.nextInt();
                	sc.nextLine();
                	if(ch==1) {
                		System.out.print("Enter room label to allocate a full room: ");
                        String guestRoom=sc.nextLine();
                        roomManager.allocateGuestRoom(guestRoom);
                	}
                	else if(ch==2) {
                		System.out.print("Enter room Label to book: ");
                		String roomNumber=sc.nextLine();
                		roomManager.allocateRoom(roomNumber);
                	}
                    break;
                case 3:
                	System.out.println("Do you want to Vacate 1)Single room\n2)Shared room(4 in a room)");
                	int c=sc.nextInt();
                	sc.nextLine();
                	if(c==1) {
                		 System.out.print("Enter room label to vacate a full room: ");
                         String guestRoomVacate=sc.nextLine();
                         roomManager.vacateGuestRoom(guestRoomVacate);
                	}
                	else if(c==2) {
                		System.out.print("Enter room number to vacate: ");
                		String vacateRoomNumber=sc.nextLine();
                		System.out.print("Enter bed number (1 to 4): ");
                		int bedNumber=sc.nextInt();
                		sc.nextLine();
                		roomManager.vacateRoom(vacateRoomNumber, bedNumber);
                	}
                    break;
                case 6:
                    System.out.println("Exiting room management.");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }
        }
    }
}

