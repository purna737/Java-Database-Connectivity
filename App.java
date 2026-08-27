package javaApplication;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.Connection;

class   App
{
    public static void main(String[] args)
    {
        Connection conn = null;
        Statement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "Root@735");
            System.out.println("connection  created ");
            stmt= conn.createStatement();
            System.out.println("sql statement created");

        }
        catch(ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}