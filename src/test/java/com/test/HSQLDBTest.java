package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.*;

import com.alert.Output;
import com.persistence.HSQLDBUtility;

public class HSQLDBTest {

	HSQLDBUtility utility;
	
	@Before
	public void init() {
        try {
			utility = new HSQLDBUtility();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void testConnection() {
		assertNull(utility.getConnection());
	}
	
	@Test
	public void testCreateTable() {
		try {
			utility.createTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(utility.getConnection());
	}
	
	@Test
	public void testInsertEvent() {
		long duration = 10;
		Output output = new Output("testId1", duration, true);
		try {
			utility.createTable();
			utility.saveEvent(output);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
