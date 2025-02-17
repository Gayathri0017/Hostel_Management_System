package hostels;
import java.util.*;
public class FeeManagement {

	public static void main(String[] args) {
			        Scanner sc = new Scanner(System.in);
			        FeesManagement fees = new FeesManagement();
			        while(true) {
			        	System.out.println("Hostel fees management");
			        	System.out.println("1.set food preference");
			        	System.out.println("2.view total fees");
			        	System.out.println("3.pay fees");
			        	System.out.println("4.exit");
			        	System.out.println("Enter choice");
			        	int choice=sc.nextInt();
			        	switch(choice) {
			        	case 1:
			        		System.out.println("Enter room no");
			        		int roomnum=sc.nextInt();
			        		if(roomnum<1||roomnum>50){
			                    System.out.println("Enter 1 to 50");
			                    continue;
			               }
			        		System.out.println("Enter veg/Non-veg");
			        		String preference=sc.next();
			        		fees.setpreference(roomnum,preference);
			        		break;
			        	case 2:
			        	    System.out.println("Enter room no");
			        	    int roomnumber=sc.nextInt();
			        	    if(roomnumber<1||roomnumber>50){
			                     System.out.println("Enter 1 to 50");
			                continue;
			                }
			        	    fees.displayfees(roomnumber);
			        	    break;
			        	case 3:
			        	    System.out.println("Enter room no");
			        	    int roomno=sc.nextInt();
			        	    if(roomno<1||roomno>50){
			                     System.out.println("Enter 1 to 50");
			                continue;
			                }
			                if(fees.ispaid(roomno)){
			                    System.out.println("already paid");
			                    break;
			                }
			                System.out.println("Enter amount to pay");
			                int amount=sc.nextInt();
			                fees.payfees(roomno,amount);
			                break;
			           case 4:
			               System.out.println("Exit");
			               return;
			           default:
			           System.out.println("Invalid choice");
			        	}
			        }
		       }
		}
		class FeesManagement{
		    private static final int capacity=50;
		    private static final int vegcost=2000;
		    private static final int nonvegcost=3000;
		    private static final int roomrent=5000;
		    private boolean[] hasfood=new boolean[capacity];
		    private String[] foodprefer=new String[capacity];
		    private int[] balance=new int[capacity];
		    private int[] totfees=new int[capacity]; 
		    public FeesManagement(){
		        Arrays.fill(balance, roomrent);
		        Arrays.fill(totfees, roomrent); 
		    }
			public void setpreference(int roomnum,String preference){
			    if(!preference.equalsIgnoreCase("veg")&&!preference.equalsIgnoreCase("Nonveg")){
			        System.out.println("select veg or Nonveg");
			        return;
			    }
			    int foodcharge=0;
			    if(preference.equalsIgnoreCase("veg")){
			        foodcharge+=vegcost;
			    }
			    else{
			        foodcharge+=nonvegcost;
			    }
			    foodprefer[roomnum-1]=preference.toLowerCase();
			    hasfood[roomnum-1]=true;
			    totfees[roomnum-1]=roomrent+foodcharge;  
			    balance[roomnum-1]=totfees[roomnum-1];  
			    System.out.println("set food preferenct");
			}
			public void displayfees(int roomnum){
			     System.out.println("Total fees:"+totfees[roomnum-1]);
			     System.out.println("Remaining balance: "+balance[roomnum-1]);
			}
			boolean ispaid(int roomnumber){
			    return balance[roomnumber-1]==0;
			}
			public void payfees(int roomnumber,int amount){
			    if(balance[roomnumber-1]<=amount){
			        System.out.println("payment successfull");
			        System.out.println("extra amount return "+(amount-balance[roomnumber-1]));
			        balance[roomnumber-1]-=amount;
			    }
			    else{
			        balance[roomnumber-1]-=amount;
			        System.out.println("payment successfull");
			        System.out.println("Remaining balance "+balance[roomnumber-1]);
			    }
			}
	}
