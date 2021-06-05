package task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GetCon {

	    public int registerEmployee(CloseAcc employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (first_name, last_name,email, password, address, contact) VALUES " +
	            " (?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        //Step 1: Established the connection with database
	        try (Connection connection = DriverManager
	        	     .getConnection("jdbc:mysql://localhost:3306/bisag? useSSL=false", "root", "mypass2002");

	        	        // Step 2:Create a statement using connection object
	        	            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT_USERS_SQL)) {       
	        	    	   // preparedStatement.setString(1,employee.getFirstName());
	        	        // Step 3: Execute the query or update query
	        	            result = preparedStatement.executeUpdate();

	        	        } catch (SQLException e) {
	        	            // process sql exception
	        	            printSQLException(e);
	        	        }
	        	        return result;
	        	    }

	        	    private void printSQLException(SQLException ex) {
	        	        for (Throwable e: ex) {
	        	            if (e instanceof SQLException) {
	        	                e.printStackTrace(System.err);
	        	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	        	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	        	                System.err.println("Message: " + e.getMessage());
	        	                Throwable t = ex.getCause();
	        	                while (t != null) {
	        	                    System.out.println("Cause: " + t);
	        	                    t = t.getCause();
	        	                }
	        	            }
	        	        }
	        	    }
	        	}