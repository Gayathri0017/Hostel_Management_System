package hostels;
import java.util.Scanner;
class Rooms {
    private static final int capacity = 60;
    private static final int roomsPerFloor = 20;
    private static final int bedsPerRoom = 4;
    private static final int guestRoom = 41;
    private boolean[][] rooms;
    private boolean[] guests;
    private int bookedBeds;
    private int bookedRooms;
    Rooms() {
        this.rooms = new boolean[capacity][bedsPerRoom];
        this.guests = new boolean[capacity];
        this.bookedBeds = 0;
    }
    private int getRoomNumber(String roomLabel) {
        try {
            char floor = roomLabel.charAt(0);
            int roomNumber = Integer.parseInt(roomLabel.substring(1));

            if (roomNumber < 1 || roomNumber > roomsPerFloor) {
                throw new IllegalArgumentException("Invalid room number.");
            }
            switch (floor) {
                case 'A': return roomNumber - 1;
                case 'B': return roomsPerFloor + roomNumber - 1;
                case 'C': return (2 * roomsPerFloor) + roomNumber - 1;
                default: throw new IllegalArgumentException("Invalid floor.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid room format. Use A1, B5, C10, etc.");
            return -1;
        }
    }
    public void allocateRoom(String roomNumber) {
        int roomIndex = getRoomNumber(roomNumber);
        if (roomIndex == -1 || roomIndex >= guestRoom - 1) {
            System.out.println("Invalid room selection.");
            return;
        }
        for (int i = 0; i < bedsPerRoom; i++) {
            if (!rooms[roomIndex][i]) {
                rooms[roomIndex][i] = true;
                bookedBeds++;
                System.out.println("Bed " + (i + 1) + " in room " + roomNumber + " booked.");
                return;
            }
        }
        System.out.println("Room " + roomNumber + " is fully occupied.");
    }
    public void vacateRoom(String roomNumber, int bedNumber) {
        int roomIndex = getRoomNumber(roomNumber);
        if (roomIndex == -1) return;

        try {
            if (bedNumber < 1 || bedNumber > bedsPerRoom) {
                throw new IllegalArgumentException("Invalid bed number.");
            }
            if (!rooms[roomIndex][bedNumber - 1]) {
                System.out.println("Bed " + bedNumber + " in Room " + roomNumber + " is already vacant.");
            } else {
                rooms[roomIndex][bedNumber - 1] = false;
                bookedBeds--;
                System.out.println("Bed " + bedNumber + " in Room " + roomNumber + " vacated successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void allocateGuestRoom(String roomLabel) {
        int roomIndex = getRoomNumber(roomLabel);
        if (roomIndex == -1 || roomIndex < guestRoom - 1) {
            System.out.println("Invalid room! Only C1-C20 can be booked as full rooms.");
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
        if (roomIndex == -1 || roomIndex < guestRoom - 1) {
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
