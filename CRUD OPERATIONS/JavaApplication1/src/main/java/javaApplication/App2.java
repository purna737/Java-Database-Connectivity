package javaApplication;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;

/**
 * Hello world!
 */
public class App2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee id:");
        int employeeid =sc.nextInt();

        System.out.println("Enter firstname :");
        String firstname = sc.next();

        System.out.println("Enter last name:");
        String lastname = sc.next();

        System.out.println("Enter dateofjoin:");
        String dateofjoin = sc.next();

        System.out.println("Enter email address:");
        String emailaddress = sc.next();

        System.out.println("Enter password:");
        String loginpass = sc.next();


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");




            //stmt = conn.createStatement();


            String SqlQuery = "INSERT INTO employee1 VALUES(?,?, ?, ?, ?, ?)";

            stmt = conn.prepareStatement(SqlQuery);

            stmt.setInt(1,employeeid);
            stmt.setString(2,firstname);
            stmt.setString(3,lastname);
            stmt.setString(4,dateofjoin);
            stmt.setString(5,emailaddress);
            stmt.setString(6,loginpass );



            System.out.println(SqlQuery);



            int  noofrowsAffected =  stmt.executeUpdate();
            if (noofrowsAffected !=0)
            {
                System.out.println("Rows Affected successfully");
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


