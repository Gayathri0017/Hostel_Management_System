package Assignment;

import java.util.Scanner;

public class Assignment_1 {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		
		//Assignment-1
		
		/*
		 * System.out.println("Enter the Employee Name :"); String sname=s.nextLine();
		 * System.out.println("Enter the wages for a day :"); int wages=s.nextInt();
		 * System.out.println("Enter the number days worked in the company :"); int
		 * days=s.nextInt(); int salary=wages*days;
		 * System.out.println("#####Employee salary Details######");
		 * System.out.println("Employee Name:"+sname);
		 * System.out.println("Salary is "+salary); s.close();
		 */
		
		//Assignment-2
		
		/*
		 * System.out.println("Enter the number:"); int div=s.nextInt(); if(div%7==0) {
		 * System.out.println("The given number "+div+" is divisor of 7"); }
		 */
		
		
		//Assignment-7
		
		/*
		 * System.out.println("Enter the age :"); int age=s.nextInt();
		 * System.out.println("Enter the weight :"); int weight=s.nextInt(); if(age>18
		 * && age<55 && weight>45) {
		 * System.out.println("The donor is eligile to donate the blood"); }
		 */
		
		//Assignment-8
		
		System.out.println("Enter the character");
		char ch=s.next().charAt(0);
		if(ch>='0' && ch<='9')
		{
			System.out.println("it is integer");
		}
		else if(ch>='a' && ch<='z')
		{
			System.out.println("It is lowercase");
			
		}
		else if(ch>='A' && ch<='Z')
		{
			System.out.println("it is upper case");
		}
		else
		{
			System.out.println("Give valid character");
		}
		
		
	}

}
