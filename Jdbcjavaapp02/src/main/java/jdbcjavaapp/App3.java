package jdbcjavaapp;

import java.sql.*;

public class App3 {

    public static void main (String[] args)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;



        try {
           Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "*****");
            stmt = conn.createStatement();


           /* String SqlQuery = """
                    INSERT INTO employee VALUES(101,'jai','kumar','2021-12-11'),
                    (102,'kumar','raj','2023-03-18'),(103,'pavan','kumar','2024-10-02'),
                    (104,'vishnu','teja','2021-02-11')
                    """;*/


           /* String SqlQuery = " SELECT  first_name,last_name from employee";


            rs = stmt.executeQuery(SqlQuery);
            while (rs.next())
            {
                String first_name  = rs.getString(1);
                String last_name = rs.getString(2);

                System.out.println("First name is :"+first_name);
                System.out.println("last name is: "+last_name);
                System.out.println();
            }*/



            String 

        }




        catch (ClassNotFoundException cnfex)
        {
            cnfex.printStackTrace();
        }
        catch (SQLException sqe)
        {
            sqe.printStackTrace();
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
