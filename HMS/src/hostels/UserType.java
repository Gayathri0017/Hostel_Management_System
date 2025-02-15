package hostels;

import java.util.Scanner;

class User {
    String userID,name,email,password,phoneNumber,role;

    User(String userID,String name,String email,String password,String phoneNumber,String role) 
    {
        this.userID =userID;
        this.name =name;
        this.email =email;
        this.password =password;
        this.phoneNumber =phoneNumber;
        this.role =role;
    }
}

public class UserType 
{
    private static final int Max=50;
    private static User[] users=new User[Max];
    private static int userCount=0;
    private static Scanner s=new Scanner(System.in);

    public static void main(String[] args) 
    {
        while(true) 
        {
            System.out.println("\nHostel Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update Profile");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice=s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    updateProfile();
                    break;
                case 4:
                    System.out.println("Exit. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void register() {
        if (userCount>=Max) {
            System.out.println("User limit reached.");
            return;
        }
        System.out.print("Enter User ID: ");
        String userID=s.nextLine();
        if (findUserByID(userID)!=null) {
            System.out.println("User ID already exists.");
            return;
        }

        System.out.print("Enter Name:");
        String name=s.nextLine();
        System.out.print("Enter Email: ");
        String email=s.nextLine();
        System.out.print("Enter Password: ");
        String password=s.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber=s.nextLine();
        System.out.print("Enter Role (Student/Admin/Warden): ");
        String role=s.nextLine();

        if (!role.equalsIgnoreCase("Student") && !role.equalsIgnoreCase("Admin") && !role.equalsIgnoreCase("Warden")) {
            System.out.println("Invalid role. Please enter Student, Admin, or Warden.");
            return;
        }

        users[userCount++]=new User(userID, name, email, password, phoneNumber, role);
        System.out.println("Registration successful!");
    }

    public static void login() {
        System.out.print("Enter User ID: ");
        String userID = s.nextLine();
        System.out.print("Enter Password: ");
        String password = s.nextLine();

        User user=findUserByID(userID);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful!");
            welcomeMessage(user);
        } else {
            System.out.println("Invalid User ID or Password.");
        }
    }

    public static void updateProfile() {
        System.out.print("Enter User ID: ");
        String userID=s.nextLine();
        User user=findUserByID(userID);

        if (user==null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter New Name (Leave blank to keep current): ");
        String newName=s.nextLine();
        if (!newName.isEmpty())
        	user.name=newName;

        System.out.print("Enter New Email (Leave blank to keep current): ");
        String newEmail = s.nextLine();
        if (!newEmail.isEmpty()) 
        	user.email=newEmail;

        System.out.print("Enter New Password (Leave blank to keep current): ");
        String newPassword = s.nextLine();
        if (!newPassword.isEmpty()) 
        	user.password=newPassword;

        System.out.print("Enter New Phone Number (Leave blank to keep current): ");
        String newPhoneNumber = s.nextLine();
        if (!newPhoneNumber.isEmpty()) 
        	user.phoneNumber=newPhoneNumber;

        System.out.println("Profile updated successfully!");
    }

    public static User findUserByID(String userID) 
    {
        for (int i=0;i<userCount;i++) 
        {
            if (users[i].userID.equals(userID)) 
            {
                return users[i];
            }
        }
        return null;
    }

    public static void welcomeMessage(User user) {
        switch (user.role.toLowerCase()) {
            case "student":
                System.out.println("Welcome, Student " + user.name + "! Stay at the hostel.");
                break;
            case "admin":
                System.out.println("Welcome, Admin " + user.name + "!");
                break;
            case "warden":
                System.out.println("Welcome, Warden " + user.name + "!");
                break;
            default:
                System.out.println("Welcome, " + user.name + "!");
        }
    }
}
