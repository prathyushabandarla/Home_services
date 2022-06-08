package com.project;
import java.util.Scanner;
import java.sql.*;
public class reservation  {
   
    public static void main(String[] args) throws SQLException
    {
        booking bb = new booking();
        Boolean flag2 = true;
        do
        {
        	System.out.println("****************HOME  SERVICES*************");
            System.out.println("press 1 to Login as Admin");
            System.out.println("press 2 to Login as User");
            System.out.println("press 3 to choose EXIT");

            Scanner sc2 = new Scanner(System.in);
            int j = sc2.nextInt();
           
            switch(j)
            {
            case 1: bb.admin();
                flag2 = false;
                break;
            case 2: bb.user();
                flag2 = false;
                System.exit(0);
                break;
            case 3:
                System.exit(0);
            default : System.out.println("wrong choice u have entered");
                System.out.println("Please Enter the Correct One");
                break;
            }

        }while(flag2);


        Boolean flag = true;
        do{
            String s = "y";
            while (s.equals("y")) {
                System.out.println("*********** MAIN MENU *************");
                System.out.println("press 1 to choose electrician");
                System.out.println("press 2 to choose plumber");
                System.out.println("press 3 to choose driver");
                System.out.println("press 4 to choose EXIT");

                Scanner sc = new Scanner(System.in);
                int i = sc.nextInt();

               

                switch (i)
                
                
                {
                case 1: bb.electrician();
                    break;
                case 2: bb.plumber();
                    break;
                case 3: bb.driver();
                    break;
                case 4: System.exit(0);
                default : System.out.println("Wrong Choice");
                    break;
                }
                System.out.println("want to continue press y/n");
                s = sc.next();

            }

            flag = false;
}
        while(flag);

    }
}

