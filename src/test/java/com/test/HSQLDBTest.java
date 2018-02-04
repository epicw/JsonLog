package com.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.*;

import com.alert.Output;
import com.persistence.HSQLDBUtility;

public class HSQLDBTest {

	private HSQLDBUtility utility;
	
	@Before
	public void init() {
        try {
			utility = new HSQLDBUtility();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void testCreateTable() {
		try {
			utility.createTable();    // In createTable function, it creates a connection.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(utility.getConnection());
	}
	
	@Test
	public void testInsertEvent() {    // to insert an event
		long duration = 10;
		Output output = new Output("testId1", duration, true);
		try {
			utility.createTable();
			utility.saveEvent(output);
			System.out.println("Inserted to HSQLDB successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void cleanInsertions() {
		HSQLDBUtility utility;
		try {
			utility = new HSQLDBUtility();	 
			Connection c = utility.getConnection();
			String sql = "DELETE FROM \"PUBLIC\".\"EVENTALERT\"";
			Statement statement;
		
			statement = c.createStatement();
			statement.execute(sql);
			System.out.println("Deleted all inserted rows");		
			utility.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
        
	}
}
