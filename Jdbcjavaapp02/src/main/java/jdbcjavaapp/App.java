package jdbcjavaapp;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    public static void main( String[] args )

    {

        Connection conn = null;
        Statement stmt = null;
       try {


               Class.forName("com.mysql.cj.jdbc.Driver");
               System.out.println("Driver loaded");

               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "*****");

               stmt= conn.createStatement();


              /* String SqlQuery1 = """
                       INSERT INTO empj Values(2,'king',120000),
                       (3,'raj',110000),
                       (4,'sai',100000)
                       """;
              int noofrowsAffected =  stmt.executeUpdate(SqlQuery1);
              if (noofrowsAffected !=0)
              {
                  System.out.println("Rows inserted successfully");
              } */

          /* String SqlQuery2 = """
                       INSERT INTO empj Values
                       (5,'sai',100000)
                       """;
           int noofrowsAffected =  stmt.executeUpdate(SqlQuery2);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows 2 inserted successfully");
           }

           String SqlQuery3 = """
                       INSERT INTO empj Values
                       (6,'sai',100000)
                       """;
            noofrowsAffected =  stmt.executeUpdate(SqlQuery3);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows  3 inserted successfully");
           }
*/

           String SqlQuery4 = """
                       INSERT INTO empj Values
                       (7,'mani',110000)
                       """;
          int  noofrowsAffected =  stmt.executeUpdate(SqlQuery4);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows  4 inserted successfully");
           }

           String SqlQuery5 = """
                       INSERT INTO product Values
                       (1,'pencil',100)
                       """;
           noofrowsAffected =  stmt.executeUpdate(SqlQuery5);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows  5 inserted successfully");
           }

           String SqlQuery6 = """
                       INSERT INTO product Values
                       (2,'scale',17)
                       """;
           noofrowsAffected =  stmt.executeUpdate(SqlQuery6);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows  6 inserted successfully");
           }

           String SqlQuery7 = """
                       INSERT INTO product Values
                       (3,'pad',2)
                       """;
           noofrowsAffected =  stmt.executeUpdate(SqlQuery7);
           if (noofrowsAffected !=0)
           {
               System.out.println("Rows  7 inserted successfully");
           }


           }
           catch(ClassNotFoundException cnfex)
           {
               cnfex.printStackTrace();
           }
           catch(SQLException sqex)
           {
               sqex.printStackTrace();

               System.out.println("Error saving Record");
           }

       finally {
           try{
               if(stmt!=null)
               {
                   stmt.close();
               }
               if(conn!=null)
               {
                   conn.close();
               }
           }
           catch (SQLException sqel)
           {
               sqel.printStackTrace();
           }
       }
       }
    }

