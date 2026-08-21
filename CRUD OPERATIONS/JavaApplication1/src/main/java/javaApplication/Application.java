package javaApplication;

import java.sql.*;
import java.util.Scanner;



public class Application
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter userid:");
        int userid =sc.nextInt();

        System.out.println("Enter firstname :");
        String firstname = sc.next();

        System.out.println("Enter last name:");
        String lastname = sc.next();



        System.out.println("Enter addressid:");
        int addressid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter line1:");
        String line1 = sc.nextLine();

        System.out.println("Enter line2:");
        String line2 = sc.nextLine();

        System.out.println("Enter line3:");
        String line3 = sc.nextLine();

        System.out.println("Enter city:");
        String city = sc.next();


        System.out.println("Enter state:");
        String state = sc.next();

        System.out.println("Enter pincode:");
        String pincode = sc.next();




        System.out.println("Enter contactid:");
        int contactid = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter mobileno:");
        String mobileno = sc.next();

        System.out.println("Enter emailaddress:");
        String emailaddress = sc.next();






        Connection conn = null;
        // Statement stmt = null;

        PreparedStatement stmt1 = null;

        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;










        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");




            //stmt = conn.createStatement();


            String SqlQuery1 = "INSERT  INTO users VALUES (?,?,?)";

            String SqlQuery2 = "INSERT INTO addresses values (?,?,?,?,?,?,?)";

            String SqlQuery3 = "INSERT INTO contacts values (?,?,?)";


            stmt1 = conn.prepareStatement(SqlQuery1);

            stmt2 = conn.prepareStatement(SqlQuery2);

            stmt3 = conn.prepareStatement(SqlQuery3);

            stmt1.setInt(1,userid);
            stmt1.setString(2,firstname);
            stmt1.setString(3,lastname);

            int  noofrowsAffected =  stmt1.executeUpdate();
            if (noofrowsAffected !=0)
            {
                System.out.println("Rows Affected successfully into users");
            }

            stmt2.setInt(1, addressid);
            stmt2.setString(2,line1);
            stmt2.setString(3,line2);
            stmt2.setString(4,line3);
            stmt2.setString(5,city);
            stmt2.setString(6,state);
            stmt2.setString(7,pincode);


             noofrowsAffected =  stmt2.executeUpdate();
            if (noofrowsAffected !=0)
            {
                System.out.println("Rows Affected successfully into addresses");
            }


            stmt3.setInt(1,contactid);
            stmt3.setString(2,mobileno);
            stmt3.setString(3,emailaddress);


            noofrowsAffected =  stmt3.executeUpdate();
            if (noofrowsAffected !=0)
            {
                System.out.println("Rows Affected successfully into contacts");
            }





        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
        }
        finally {
            try {


                if(stmt1 != null)
                {
                    stmt1.close();


                }
                if( stmt2 != null)
                {
                    stmt2.close();


                }

                if(stmt3 != null)
                {
                    stmt3.close();


                }


                if(conn !=null)
                {
                    conn.close();

                }
            } catch(SQLException sqlEx)
            {
                sqlEx.printStackTrace();
            }

        }
    }
}
