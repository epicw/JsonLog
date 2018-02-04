package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alert.Output;

public class HSQLDBUtility {
	private static final Logger logger = LogManager.getLogger("HSQLDBUtility");
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStmt;
	
	public HSQLDBUtility() throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		
		if (preparedStmt != null) {
			preparedStmt.close();
		}
		
		connection.close();
		logger.info("Database connection has been closed.");
	}
	
	public void createTable() throws SQLException {
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/xdb", "sa", "");
		} catch (SQLException e) {
			logger.error("ERROR:failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
		}
		
        if (connection != null) {
            logger.info("Connected database success!");
            String sql = "CREATE TABLE IF NOT EXISTS EventAlert (" + 
            		"ID VARCHAR(20) NOT NULL PRIMARY KEY," + 
            		"DURATION BIGINT NOT NULL," + 
            		"TYPE VARCHAR(20)," + 
            		"HOST VARCHAR(30)," + 
            		"ALERT BOOLEAN NOT NULL" + 
            		")";
            statement = connection.createStatement();
            statement.execute(sql);
            logger.info("Create EventAlert Table in HSQLDB successfully!");
        }
	}
	
	public void saveEvent(Output output) throws SQLException {
		String id = output.getId();
		Long duration = output.getDuration();
		String type = output.getType() != null ? output.getType(): "";
		String host = output.getHost() != null ? output.getHost(): "";
		boolean alert = output.isAlert();
		String sql = "INSERT INTO EventAlert(ID, DURATION, TYPE, HOST, ALERT) VALUES (?, ?, ?, ?, ?);";
		
		preparedStmt = connection.prepareStatement(sql);
	    preparedStmt.setString(1, id);
	    preparedStmt.setLong(2, duration);
	    preparedStmt.setString(3, type);
	    preparedStmt.setString(4, host);
	    preparedStmt.setBoolean(5, alert);
	    preparedStmt.execute();
	}

}
