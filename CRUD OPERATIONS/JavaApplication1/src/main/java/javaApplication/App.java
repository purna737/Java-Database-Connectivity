package javaApplication;

import java.sql.*;
import java.util.Scanner;



public class App
{
    public static void main(String[] args) {
        Connection conn = null;
       // Statement stmt = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        Scanner sc = new Scanner(System.in);

        /*System.out.println("Enter employee id:");
        int employeeid =sc.nextInt();*/

        /*System.out.println("Enter firstname :");
        String firstname = sc.next();

        System.out.println("Enter last name:");
        String lastname = sc.next();


        System.out.println("Enter dateofjoin:");
        String dateofjoin = sc.next();*/

        System.out.println("Enter email address:");
        String emailaddress = sc.nextLine();

        System.out.println("Enter password:");
        String loginpass = sc.next();




        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");




            //stmt = conn.createStatement();


            String SqlQuery = "SELECT  first_name,last_name from employee1 where  emailaddress = ? AND loginpass = ?";

            stmt = conn.prepareStatement(SqlQuery);


            stmt.setString(1,emailaddress);
            stmt.setString(2,loginpass);

            rs = stmt.executeQuery();


            if(rs.next())
            {
                String firstname = rs.getString(1);
                String lastname = rs.getString(2);

                System.out.println("Welcome " +firstname+" "+lastname);
            }

            else {
                System.out.println("Invalid email address or password....please try again later...");
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


                if(stmt != null)
                {
                    stmt.close();


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
