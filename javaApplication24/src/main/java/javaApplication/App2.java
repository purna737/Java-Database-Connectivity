package javaApplication;




import java.sql.*;
import java.util.Scanner;
import static java.lang.System.out;
import static  java.sql.DriverManager.getConnection;

public class App2
{
    public static void main( String[] args )

    {

        var sc = new Scanner(System.in);
//        out.println("Enter employee id:");
//        var employeeid= sc.nextInt();
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

        var SqlQuery = "INSERT INTO EMPLOYEE1(firtsname,lastname,firstname,lastname,dateofjoin,emailaddress,loginpassword) VALUES (?,?,?,?,?)";

        try ( var conn = getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");

              var stmt= conn.prepareStatement(SqlQuery,PreparedStatement.RETURN_GENERATED_KEYS);)
        {
            Employee emp = new Employee(firstname,lastname,dateofjoin,emailaddress,loginpassword);

           // stmt.setInt(1,emp.id());
            stmt.setString(2,emp.firstname());
            stmt.setString(3,emp.lastname());
            stmt.setString(4,emp.dateofjoin());
            stmt.setString(5,emp.emailaddress());
            stmt.setString(6,emp.loginpassword());



            var  noofrowsAffected =  stmt.executeUpdate();
            if (noofrowsAffected !=0)
            {
                out.println("Rows Affected successfully");
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();

                out.println("Congratulations! Your employee has been added!");
                out.println("Here is the employee id assigned: " + rs.getString(1));
            }

        }
        catch(SQLException sqex)
        {
            sqex.printStackTrace();

            System.out.println("Error saving Record");
        }


    }
}

