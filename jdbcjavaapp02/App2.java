package com.codegnan.app.jdbcjavaapp02;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class App2 {
    public static void main(String[] args) {
    	Connection conn = null;
    	Statement stmt = null;
    	ResultSet rs = null;
        try {
		
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	//STEP 2 - ESTABLISH CONNECTION WITH THE DATABASE SERVER
        	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlproject", "root" , "######");
		
		
		//STEP 3 - CREATE A STATEMENT ON THE DATABASE  CONNECTION
		stmt = conn.createStatement();
		
		
		
		String SqlQuery = """
				
				SELECT empid ,empname,empsal from employee1
				""";
		
		rs = stmt.executeQuery(SqlQuery);
		while(rs.next())
		{
			int empid =rs.getInt(1);
			String empname = rs.getString(2);
			int empsal = rs.getInt(3);
			
			
			System.out.println(empid);
			System.out.println(empname);
			System.out.println(empsal);
			
			System.out.println("===========");
		}
		
		//STEP 4 - EXECUTE QUERIES
        } catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		}
        catch(SQLException sqlEx)
        {
        	sqlEx.printStackTrace();
        }
        finally {
        	try {
        		//STEP 5 - CLOSE THE RESOURCES
        		//CLOSE STATEMNET ON THE DATABASE CONNECTION
        		
        		if(rs != null)
        		{
        			rs.close();
        		}
        		if(stmt != null)
        		{
        			stmt.close();
        			
        			
        		}
        		//CLOSE CONNECTION ON THE DATABASE SERVER
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
