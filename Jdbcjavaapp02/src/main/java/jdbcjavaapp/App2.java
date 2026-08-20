package jdbcjavaapp;





import java.sql.*;

public class App2
{
    public static void main( String[] args )

    {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root" , "*****");

            stmt= conn.createStatement();

            String SqlQuery = """
                    SELECT id,name,sal from empj
                    """;

            rs = stmt.executeQuery(SqlQuery);

          while(rs.next())
            {
               /* int id = rs.getInt(1);
                String name = rs.getString(2);
                int sal = rs.getInt(3);*/

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int sal = rs.getInt("sal");


                System.out.println("Employee id :" + id);
                System.out.println("Employee name :" + name);
                System.out.println("Employee sal :" + sal);
                System.out.println();

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

                if(rs !=null)
                {
                    rs.close();
                }
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

