package com.hostels;
import java.util.Scanner;
class Visitor {
    String name;
    String inTime;
    String outTime;
    void enterDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Visitor Name: ");
        name = sc.nextLine();
        System.out.print("Enter InTime (HH:MM): ");
        inTime = sc.nextLine();
    }
    void exitDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter OutTime (HH:MM) for " + name + ": ");
        outTime = sc.nextLine();
    }
    void displayDetails() {
        System.out.println("Visitor Name: " + name);
        System.out.println("InTime: " + inTime);
        System.out.println("OutTime: " + (outTime != null ? outTime : "Not recorded"));
    }
}
public class VisitorManagement extends Visitor{
    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        visitor.enterDetails();
        visitor.exitDetails();
        visitor.displayDetails();
    }
}
