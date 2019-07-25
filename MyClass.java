import java.io.*;
import java.net.*;
import java.util.*;


public class MyClass {

	public static Socket socket            = null; 
	public static DataInputStream  input   = null; 
	public static DataOutputStream out     = null; 
  
public static void main(String[] args) {
	      
    	Scanner sc=new Scanner(System.in);
    	int choice;
    
        // establish a connection 
        try
        { 
            socket = new Socket("localhost",6665); 
            System.out.println("Connected"); 
  
            // takes input from terminal 
            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(Exception u) 
        { 
            System.out.println(u); 
        }
       
    	System.out.print("Welcome to the ATM Machine!\n");
        System.out.println("Select from the following menu options below:\n");
        System.out.println(" 1. For Admin Login");
        System.out.println(" 2. For Customer Login");
        choice=sc.nextInt();
       try 
       {
		out.write(choice);
       } 
       catch (IOException e) 
       {
		e.printStackTrace();
       }
        
    }

}

