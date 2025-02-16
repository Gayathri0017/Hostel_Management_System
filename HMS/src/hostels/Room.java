package hostels;
import java.util.*;
class Rooms{
	private static final int capacity=60;
	private static final int roomsPerFloor=20;
	private static final int bedsPerRoom=4;
	private static final int guestRoom=41;
	private boolean[][] rooms;
	private boolean guests[];
	private int bookedBeds;
	private int bookedRooms;
	Rooms() {
		this.rooms=new boolean[capacity][bedsPerRoom];
		this.guests=new boolean[capacity];
		this.bookedBeds=0;
	}
	private int getRoomNumber(String roomLabel) {
		char floor=roomLabel.charAt(0);
		int roomNumber=Integer.parseInt(roomLabel.substring(1));
		if(roomNumber<1 || roomNumber>roomsPerFloor) {
			return -1;
		}
		switch(floor) {
		case 'A':
			return roomNumber-1;
		case 'B':
			return roomsPerFloor+roomNumber-1;
		case 'C':
			return (2*roomsPerFloor)+roomNumber-1;
		default:
			return -1;
		}
		
	}
	public void displayRooms(){
		System.out.println("-----Available Rooms and Beds-----");
        for(int floor=0;floor<3;floor++) {
        	char label=(char)(floor+'A');
        	System.out.println("Floor "+label);
        	for(int i=1;i<=roomsPerFloor;i++) {
        		int index=(floor*roomsPerFloor)+(i-1);
        		String roomLabel=label+Integer.toString(i);
        	if(floor==0 || floor==1) {
        		System.out.print(roomLabel+"[");
        		for(int bed=0;bed<bedsPerRoom;bed++) {
        			System.out.print(rooms[index][bed] ? "X" : "O");
        			if(bed<bedsPerRoom-1)
        				System.out.print(",");
        		}
        		System.out.print("]\t");
        	}
        	else {
        		if(guests[index]==true) {
        			System.out.print("-\t");
        		}
        		else {
        			System.out.print(roomLabel+"\t");
        		}
        	}
        	if(i%10==0) {
        		System.out.println();
        	}
        		
        	}
        	System.out.println("------------------------------------------------------------------------------");
        }
		
	}
	public void allocateRoom(String roomNumber){
		int roomIndex=getRoomNumber(roomNumber);
		if(roomIndex==-1) {
			System.out.println("Invalid room number,Please choose valid number");
		}
		if(roomIndex>=guestRoom-1) {
			System.out.println("Use 'Book a full room option for C floor");
			return;
		}
		for(int i=0;i<bedsPerRoom;i++) {
			if(rooms[roomIndex][i]==false) {
				rooms[roomIndex][i]=true;
				bookedBeds++;
				System.out.println("Bed "+(i+1)+" in room "+roomNumber+" is booked");
				return;
			}
		}
		System.out.println(roomNumber+" is fully occupied");
	}
	public void vacateRoom(String roomNumber,int bedNumber) {
		int roomIndex=getRoomNumber(roomNumber);
		if(roomIndex==-1) {
			System.out.println("Invalid room number,Please choose valid number");
		}
		else if(rooms[roomIndex][bedNumber-1]==false) {
			System.out.println("bed "+bedNumber +" in Room "+roomNumber +" is already Vacant");
		}
		else {
			rooms[roomIndex][bedNumber-1]=false;
			bookedBeds--;
			System.out.println("Bed "+bedNumber+" Room "+roomNumber+" vacated successfully");
		}
		
	}
	  public void allocateGuestRoom(String roomLabel) {
	        int roomIndex=getRoomNumber(roomLabel);
	        if (roomIndex==-1 || roomIndex<guestRoom - 1) {
	            System.out.println("Invalid room!Only C1-C20 can be booked as full rooms.");
	            return;
	        }
	        if (guests[roomIndex]) {
	            System.out.println("Room " + roomLabel + " is already booked.");
	        } else {
	            guests[roomIndex] = true;
	            bookedRooms++;
	            System.out.println("Room " + roomLabel + " booked successfully!");
	        }
	    }
	  public void vacateGuestRoom(String roomLabel) {
	        int roomIndex = getRoomNumber(roomLabel);
	        if (roomIndex == -1||roomIndex <guestRoom- 1) {
	            System.out.println("Invalid room! Only C1-C20 can be vacated as full rooms.");
	            return;
	        }

	        if (!guests[roomIndex]) {
	            System.out.println("Room " + roomLabel + " is already vacant.");
	        } else {
	            guests[roomIndex] = false;
	            bookedRooms--;
	            System.out.println("Room " + roomLabel + " vacated successfully!");
	        }
	    }
}
public class Room{
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	Rooms r=new Rooms();
	while(true) {
		System.out.println("-----Hostel Room Management-----");
		System.out.println("1)View Rooms");
		System.out.println("2)Book a Bed");
		System.out.println("3)Vacate Bed");
		System.out.println("4)Book a Room");
		System.out.println("5)Vacate a Room");
		System.out.println("6)Exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			r.displayRooms();
			break;
		case 2:
			System.out.println("Enter room Label to book");
			String roomNumber=sc.nextLine();
			r.allocateRoom(roomNumber);
			break;
		case 3:
			System.out.println("Enter room number to vacate");
			String vacateroomNumber=sc.nextLine();
			System.out.println("Enter bed number (1 to 4)");
			int bedNumber=sc.nextInt();
			r.vacateRoom(vacateroomNumber,bedNumber);
			break;
		case 4:
			System.out.println("Enter room number to book full room");
			String guestRoom=sc.nextLine();
			r.allocateGuestRoom(guestRoom);
			break;
		case 5:
			System.out.println("Enter room number to book vacate full room");
			String guestRoomVacate=sc.nextLine();
			r.vacateGuestRoom(guestRoomVacate);
			break;
		case 6:
			System.out.println("Thanks for visiting....");
			return;
		default:
			System.out.println("Invalid choice!,Please enter a valid Choice");
			break;
		}
	}
}
}
