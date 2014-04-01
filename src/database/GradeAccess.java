package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to access grades in project SQL database.
 * 
 * NOTE: This class will NOT work outside of the SFU network. It also requires
 * the JDBC Driver for SQL server to be in the classpath of the JVM for it to
 * function.
 * 
 * @author Markus Balaski
 * @version 0.1 - 22/03/2014
 */
public class GradeAccess {
	// ATTRIBUTES - CLASS VARIABLES

	private static Connection dbConnection; // The connection to the database

	// STATIC METHODS

	/*
	 * Method to establish a connection to the Cypress SQL server. Uses
	 * hard-coded login information of our group's SQL connection.
	 */
	private static void establishConnection() {
		try { // Access the JDBC driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("No JDBC driver found, exiting.");
		}

		try { // Connect to Cypress
			dbConnection = DriverManager
					.getConnection("jdbc:sqlserver://cypress.csil.sfu.ca;"
							+ " user = c275g01; password = TAA2Md7nGrPj2LjN");
		} catch (SQLException e) {
			System.out.println("Connection failed, exiting.");
		}
	}

	// NON-STATIC METHODS

        public static int getStudentID(String stud_name) {
                String query = "SELECT StudentID FROM c275g01A.dbo.Student WHERE StudentName = '" + stud_name + "'";
                        ResultSet rs = execQuery(query);
                        int student_id = 666; //If you get this value, you'll know the database didn't find anything.
                       
              try {
                rs.next();
                student_id = rs.getInt(1);
            } catch (SQLException ex) {
                Logger.getLogger(GradeAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
                       
                       return student_id;
        }
        
	public static ResultSet accessGrades(String courseID, String actName) {
		String query = "SELECT Grade FROM c275g01A.dbo.Grades WHERE"
				+ " CourseID = '" + courseID + "',ActivityName = '" + actName
				+ "'";
		return execQuery(query);
	}

	public static void enterGrade(int studentID, String courseID,
			String actName, float grade) {
		String query = "INSERT INTO c275g01A.dbo.Grades VALUES (" + studentID
				+ ",'" + courseID + "','" + actName + "'," + grade + ")";
		execUpdate(query);
	}

	public static void updateGrade(int studentID, String courseID,
			String actName, float grade) {
		String query = "UPDATE c275g01A.dbo.Grades SET Grade = " + grade
				+ " WHERE StudentID = '" + studentID + ",CourseID = '"
				+ courseID + "',ActivityName = '" + actName + "'";
		execUpdate(query);
	}

	// HELPER METHODS

	/*
	 * Method to execute an update (INSERT, DELETE, UPDATE) query on the
	 * database connection.
	 */
	private static void execUpdate(String query) {
		PreparedStatement prepStatement = null;

		establishConnection(); // Establish connection to Cypress

		try { // Prepare and execute the query
			prepStatement = dbConnection.prepareStatement(query);
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Exception occured, the state : "
					+ e.getSQLState() + "\nMessage: " + e.getMessage());
		}
	}

	/*
	 * Method to execute a query on the database connection and return a result
	 * set for the query entered as a string argument.
	 */
	private static ResultSet execQuery(String query) {
		PreparedStatement prepStatement = null;
		ResultSet resSet = null;

		establishConnection();
		try { // Prepare and execute query
			prepStatement = dbConnection.prepareStatement(query);
			resSet = prepStatement.executeQuery();
		} catch (SQLException e) {
			System.out.println("SQL Exception occured, the state : "
					+ e.getSQLState() + "\nMessage: " + e.getMessage());
		}
		return resSet;
	}
}