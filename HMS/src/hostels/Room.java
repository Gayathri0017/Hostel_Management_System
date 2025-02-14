package hostels;
import java.util.*;
class Rooms{
	private static final int capacity=50;
	private boolean[] rooms;
	private int roomCount;
	Rooms() {
		this.rooms=new boolean[capacity];
		this.roomCount=0;
	}
	public void getRoomCount(){
		System.out.println("Total booked room count is: "+roomCount);
	}
	public void displayRooms(){
		System.out.println("-----Available Rooms are-----");
		for(int i=0;i<capacity;i++){
			if(i%10==0) {
				System.out.println();
			}
			System.out.print(rooms[i] ? "-\t" : (i+1) +"\t");
		}
		System.out.println();
	}
	public void allocateRoom(int roomNumber){
		if(roomNumber<1 || roomNumber>capacity) {
			System.out.println("Invalid room number,Please choose between 1 to 50");
		}
		else if(rooms[roomNumber-1]==true) {
			System.out.println("Room "+roomNumber +" is already booked");
		}
		else {
			rooms[roomNumber-1]=true;
			roomCount++;
			System.out.println("Room "+roomNumber+" booked successfully");
		}
	}
	public void vacateRoom(int roomNumber) {
		if(roomNumber<1 || roomNumber>capacity) {
			System.out.println("Invalid room number,Please choose between 1 to 50");
		}
		else if(rooms[roomNumber-1]==false) {
			System.out.println("Room "+roomNumber +" is already Vacant");
		}
		else {
			rooms[roomNumber-1]=false;
			roomCount--;
			System.out.println("Room "+roomNumber+" vacated successfully");
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
		System.out.println("2)Book Room");
		System.out.println("3)Vacate Room");
		System.out.println("4)Exit");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			r.displayRooms();
			break;
		case 2:
			System.out.println("Enter room number to book");
			int roomNumber=sc.nextInt();
			r.allocateRoom(roomNumber);
			break;
		case 3:
			System.out.println("Enter room number to vacate");
			int vacateroomNumber=sc.nextInt();
			r.vacateRoom(vacateroomNumber);
			break;
		case 4:
			System.out.println("Thanks for visiting....");
			return;
		default:
			System.out.println("Invalid choice!,Please enter a valid Choice");
			break;
			}
		}
	}
}
