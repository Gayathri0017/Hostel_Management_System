package hostels; 
import java.lang.*;
import java.util.*;
class User {
    String username,password,role;

    User(String username,String password,String role) 
    {
    	this.username=username;
        this.password=password;
        this.role=role;
    }
}

public class UserType {
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
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice=s.nextInt();
            s.nextLine();
            switch(choice) 
            {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exit thankyou ");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public static void register() 
    {
        if (userCount>=Max) 
        {
            System.out.println("User limit reached.");
            return;
        }

        System.out.print("Enter username:");
        String username=s.nextLine();
        if (findUser(username)!=null) 
        {
            System.out.println("Username already exists.");
            return;
        }

        System.out.print("Enter password:");
        String password=s.nextLine();
        System.out.print("Enter role (Student/Admin/Warden): ");
        String role=s.nextLine();

        if(!role.equalsIgnoreCase("Student") && !role.equalsIgnoreCase("Admin") && !role.equalsIgnoreCase("Warden")) 
        {
            System.out.println("Invalid role. Please enter Student, Admin, or Warden.");
            return;
        }
        users[userCount++]=new User(username,password,role);
        System.out.println("Registration successful!");
    }

    public static void login() 
    {
        System.out.print("Enter username:");
        String username=s.nextLine();
        System.out.print("Enter password:");
        String password=s.nextLine();
        User user=findUser(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login successful!");
            welcomeMessage(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public static User findUser(String username) 
    {
        for (int i=0;i<userCount;i++) 
        {
            if (users[i].username.equals(username)) 
            {
                return users[i];
            }
        }
        return null;
    }

    public static void welcomeMessage(User user) 
    {
        switch(user.role.toLowerCase()) 
        {
            case "student":
                System.out.println("Welcome, Student " + user.username + " stay at the hostel.");
                break;
            case "admin":
                System.out.println("Welcome, Admin " + user.username);
                break;
            case "warden":
                System.out.println("Welcome, Warden " + user.username);
                break;
            default:
                System.out.println("Welcome, " + user.username);
        }
    }
}
