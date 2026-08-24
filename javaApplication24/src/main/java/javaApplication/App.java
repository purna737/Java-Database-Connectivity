package javaApplication;




import java.sql.*;
import java.util.Scanner;
import static java.lang.System.out;
import static  java.sql.DriverManager.getConnection;

public class App
{
    public static void main( String[] args )

    {

        var sc = new Scanner(System.in);
        out.println("Enter employee id:");
        var employeeid= sc.nextInt();
        out.println("Enter first name:");
        var firstname = sc.next();
       out.println("Enter the last name:");
        var lastname = sc.next();
        out.println("Enter Dateofjoin:");
        var dateofjoin = sc.next();

        out.println("Enter email details:");
        var emailaddress = sc.next();
        out.println("Enter login password");
        var loginpassword = sc.next();

        var SqlQuery = "INSERT INTO EMPLOYEE1 VALUES (?,?,?,?,?,?)";

        try ( var conn = getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");

       var stmt= conn.prepareStatement(SqlQuery);)
        {
            Employee emp = new Employee(employeeid,firstname,lastname,dateofjoin,emailaddress,loginpassword);

            stmt.setInt(1,emp.id());
            stmt.setString(2,emp.firstname());
            stmt.setString(3,emp.lastname());
            stmt.setString(4,emp.dateofjoin());
            stmt.setString(5,emp.emailaddress());
            stmt.setString(6,emp.loginpassword());


            var  noofrowsAffected =  stmt.executeUpdate();
            if (noofrowsAffected !=0)
            {
                System.out.println("Rows Affected successfully");
            }

        }
        catch(SQLException sqex)
        {
            sqex.printStackTrace();

            System.out.println("Error saving Record");
        }


    }
}

