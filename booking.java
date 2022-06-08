package com.project;
import java.util.Scanner;
import java.sql.*;
public class booking
{
    public Connection getconn()
    {
        Connection con = null;
        try
        {
            String url= "jdbc:mysql://localhost:3306/project";
            String usernm="root";
            String pass="bandarla7700";
            con = DriverManager.getConnection(url,usernm,pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }


    Scanner sc1 = new Scanner(System.in);

    public String admin() throws SQLException
  {
        System.out.println("You have Choosen the 1st Option ");
       

        boolean flag = true;
        do
        {

           System.out.println("Enter Username");
           String username = sc1.next();

           System.out.println("Enter password");
           String password = sc1.next();

           Connection con =getconn();
           Statement stmt= con.createStatement();
           ResultSet rs=stmt.executeQuery("select username,password from admin");




           if (rs.next()) {

               if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
               {
                 System.out.println("*********Your Authentication Was Successfull********");
                 flag = false;
             }

             else  
             {
                 System.out.println("######  Access Denied | Access Denied ######");
                 System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
             }
         }

     }
     while(flag);
        return "success";
 }



 public void user() throws SQLException
 {
    boolean flag1 =true;

    System.out.println("**********ThankYou For Choosing the 2nd Option************");
    do
    {
        System.out.println("Enter Username");
        String username = sc1.next();
        System.out.println("Enter password");
        String password = sc1.next();

        Connection con =getconn();
        Statement stmt= con.createStatement();
        ResultSet rs=stmt.executeQuery("select username,password from user");




        if (rs.next()) {

           if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
           {
             System.out.println("*********Your Authentication Was Successfull********");
             flag1 = false;
         }

         else  
         {
             System.out.println("######  Access Denied | Access Denied ######");
             System.out.println("%%%%%%%%% Please Enter Correct Details %%%%%%%%%%%");
         }
     }
 }while(flag1);        

 do
 {
   System.out.println("press 1 if your the electrician");
   System.out.println("press 2 if your the plumber");
   System.out.println("press 3 if your the driver");
   System.out.println("press 4 to EXIT");


   int v = sc1.nextInt();


   Connection con = getconn();
   Statement stmt = con.createStatement();

   switch(v)
   {
   case 1:
    System.out.println("---Enter Your Aadharid---");
    int aa = sc1.nextInt();
    ResultSet rs1 = stmt.executeQuery("select * from electrician where aadharid="+aa);
    while(rs1.next())
    {
      System.out.println("name="+rs1.getString(1)+"aadharid="+rs1.getString(2)+"phone_no="+rs1.getString(3)+"experience="+rs1.getString(4));

  }flag1= false;
  break;
case 2:
   System.out.println("---Enter Your Aadharid---");
   int aa1 = sc1.nextInt();
   ResultSet rs2 = stmt.executeQuery("select * from plumber where aadharid="+aa1);
   while(rs2.next())
   {
      System.out.println("name="+rs2.getString(1)+"aadharid="+rs2.getString(2)+"phone_no="+rs2.getString(3)+"experience="+rs2.getString(4));

  }flag1= false;
  break;
case 3:
   System.out.println("---Enter Your Aadharid---");
   int aa2 = sc1.nextInt();
   ResultSet rs3 = stmt.executeQuery("select * from driver where aadharid="+aa2);
   while(rs3.next())
   {
      System.out.println("name="+rs3.getString(1)  +"aadharid="+rs3.getString(2)  +"phone_no="+rs3.getString(3)  +"experience="+rs3.getString(4));

  }
  flag1= false;
  break;
case 4:
    System.exit(0);
default : System.out.println("You Have Entered the Wromg Number");
   System.out.println("@@@@@@@@ Please Choose Under the OPtions.ThankYou @@@@@@@@@@@");
   break;

}


}while(flag1);
}



public void electrician() throws SQLException
{
   
    System.out.println("******THANKS FOR CHOOSING electrician********");
    Connection con = getconn();
    String s1 = "insert into electrician(name,aadharid,phone_no,experience) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur phone_no:");
    int pho = sc1.nextInt();
    System.out.println("Enter ur experience ");
    int exp = sc1.nextInt();  

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setInt(3,pho);
    stmt.setInt(4,exp);
    stmt.executeUpdate();  

}


public void plumber() throws SQLException
{
    System.out.println("******THAKS FOR CHOOSING plumber********");
    Connection con = getconn();
    String s1 = "insert into plumber(name,aadharid,phone_no,experience) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur phone_no:");
    int pho1 = sc1.nextInt();
    System.out.println("enter ur experience");
    int exp = sc1.nextInt();


    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setInt(3,pho1);
    stmt.setInt(4,exp);
    int b = stmt.executeUpdate();
}


public void driver() throws SQLException
{
    System.out.println("******THANKS FOR CHOOSING driver********");
    Connection con = getconn();
    String s1 = "insert into driver(name,aadharid,phone_no,experience) values(?,?,?,?)";
    PreparedStatement stmt = con.prepareStatement(s1);

    System.out.println("Enter ur Name:");
    String name =sc1.next();
    System.out.println("Enter ur AadharID:");
    int id =sc1.nextInt();
    System.out.println("Enter ur phone_no:");
    int pho2 = sc1.nextInt();
    System.out.println("Enter ur experience");
    int exp = sc1.nextInt();

    stmt.setString(1,name);
    stmt.setInt(2,id);
    stmt.setInt(3,pho2);
    stmt.setInt(4,exp);
    int c = stmt.executeUpdate();
}


}

