import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class MyATM {
	
	private double currentBal =1000;
	Scanner input = new Scanner(System.in);
	HashSet<String> h2=new HashSet<String>();
	HashMap<String, Integer> h1=new HashMap<String, Integer>();
	LinkedList<Integer> list=new LinkedList<Integer>();
	PriorityQueue<String> p1=new PriorityQueue<String>();
	
	public static DataInputStream in=null;
	public static Socket socket=null;
	public static ServerSocket server1=null;
	
		
	
public void admin()
{
	String username,username1="siddhesh";
	int password,pass=123456;
	

	String name;
	int account_no,choice;
	System.out.println("Enter Username");
	username=input.next();
	
	System.out.println("Enter Password");
	password=input.nextInt();
	
	if(username1.equals(username) && (pass==password))
	{
		do
		{
		System.out.println("Enter Your Choice");
		System.out.println("1. For Entering New Customers");
		System.out.println("2. To add Money");
		System.out.println("3. To Check Total Amount");
		System.out.println("4. View All Customers");
		System.out.println("5. To add Balance for Customers");
		System.out.println("6. Exit ");
		choice=input.nextInt();
	
		switch (choice) {
		case 1:
			System.out.println("Enter no. of new Customers");
			 int n=input.nextInt();
			 for(int i=0;i<n;i++)
			 {
				 System.out.println("Enter name");
				 name =input.next();
				 System.out.println("Enter account no.");
				 account_no=input.nextInt();
				 h1.put(name,account_no);
			 }
			break;

		case 2:
			System.out.println("Enter No of Notes You are adding");
			int n1=input.nextInt();
			System.out.println("Enter Value of Notes You are Adding");
			int money=input.nextInt();
			for(int i=0;i<n1;i++)
			{
				list.add(money);
			}
			break;
			
		case 3:
			Object[] arr=list.toArray();
			int sum = 0;
			for(int i=0;i<list.size();i++)
			{
				sum=sum+(Integer)arr[i];
			}
			System.out.println("Total Amount Present In ATM is"+sum);
			break;
					
		case 4:
			System.out.println(h1);
			break;
			
		case 5:
			System.out.println("Enter Balance for :");
			break;
			
		case 6:
			System.exit(0);
			break;
			
		default:
			break;
		}
		}while(choice!=6);
	}
	else
	{
		System.out.println("Username or Password is Wrong.Please Try again.");
	}
}
public void newuser()
{
	System.out.println("To Create New Account Enter Information as follows:");
	System.out.println("Enter username");
	String s1=input.next();
	h2.add(s1);

}
public void mainMenu(){
    int selection;
    
    	System.out.print("Welcome to the ATM Machine!\n");
    	System.out.println("Select Your Choice from Following:");
    	System.out.println(" 1. New Customer      ");
    	System.out.println(" 2. Existing Customer ");
    	
    	int choice;
    	choice=input.nextInt();
    	switch (choice) {
		case 1:
			newuser();
			break;

		case 2:
			System.out.println("Select from the following menu options below:\n");
	        System.out.println(" 1.  Check Balance ");
	        System.out.println(" 2.  Withdrawal  ");
	        System.out.println(" 3.  Deposit  ");
	        System.out.println(" 4.  Exit     ");
	        System.out.print("Please select your option now: ");
	        selection =input.nextInt();
	switch (selection){
	    case 1:
	        viewBalance();
	        break;
	    case 2:
	        withdrawFunds();
	        break;
	    case 3:
	        depositFunds();
	        break;
	    case 4:
	        System.out.println("Thank you for using ATM! \n Goodbye! \n");
	        break;
				}
	default:
		break;				
    	}
}
      
public void viewBalance() 
{
    int selection1;
    System.out.println("You have selected Balance.\n");
    System.out.println("\t-- Your Current Balance is:$ " + currentBal);
    System.out.println("Return to main menu? \n 1 for YES \n");
    selection1 =input.nextInt();
switch (selection1){
    case 1:
        mainMenu();
        break;
					}
}

public void withdrawFunds() 
{
    int withdrawSelection;
    System.out.println("Amount to withdraw: ");
    System.out.println("1. $20");
    System.out.println("2.  $40");
    System.out.println("3. $50");
    System.out.println("4. $100");
    System.out.println("5. MAIN MENU");
    System.out.print("Please select your option now: ");
    withdrawSelection =input.nextInt();
switch (withdrawSelection)
{
    case 1:
        accountWithdraw(20);
        mainMenu();
        break;
    case 2:
        accountWithdraw(40);
        mainMenu();
        break;
    case 3:
        accountWithdraw(50);
        mainMenu();
        break;
    case 4:
        accountWithdraw(100);
        mainMenu();
        break;
    case 5:
        mainMenu();
        break;
}
}

public void accountWithdraw(int withdrawFunds){
    currentBal = currentBal -withdrawFunds;
    System.out.println("Please take your funds.");
}
public void depositFunds(){
    int addSelection;
    System.out.println("Amount to deposit: ");
    System.out.println("1. $20");
    System.out.println("2. $40");
    System.out.println("3. $50");
    System.out.println("4. $100");
    System.out.println("5. MAIN MENU");
    System.out.print("Please select your option now: ");
    addSelection =input.nextInt();
    switch (addSelection){
    case 1:
        accountAdd(20);
        mainMenu();
        break;
    case 2:
        accountAdd(40);
        mainMenu();
        break;
    case 3:
        accountAdd(50);
        mainMenu();
        break;
    case 4:
        accountAdd(100);
        mainMenu();
        break;
    case 5:
        mainMenu();
        break;
}
}
public void accountAdd (int depositFunds){
    currentBal = currentBal +depositFunds;
    System.out.println("Thank you.");
}
    public static void main(String[] args) {
      
    	Scanner sc=new Scanner(System.in);
    	int choice;
    	int no = 0;
           
    	try{
			server1 = new ServerSocket(6665);
			System.out.println("Waiting for a client..");
			socket=server1.accept();
			System.out.println("Client accepted");
			
			 in = new DataInputStream( 
		                new BufferedInputStream(socket.getInputStream())); 
		  
		          no=in.read();
		          System.out.println(no); 

		        System.out.println("Closing connection"); 
		  
		         // close connection 
		         socket.close(); 
		          in.close(); 

		}
		 catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    	try
		{
			String url="jdbc:mysql://10.10.13.188:3306/te3233db";
			String sql="select * from atm";
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,"te3233","te3233");
			
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    	
    	System.out.print("Welcome to the ATM Machine!\n");
        System.out.println("Select from the following menu options below:\n");
        System.out.println(" 1. For Admin Login");
        System.out.println(" 2. For Customer Login");
        MyATM m1=new MyATM();
        
        switch (no) {
		case 1:
			m1.admin();
			break;
			
		case 2:
			m1.mainMenu();
			break;

		default:
			break;
		}
    }
}