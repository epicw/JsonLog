package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.hsqldb.jdbcDriver;
public class HsqlDemo {
    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/xdb", "sa", "");
            if (c != null) {
                System.out.println("Connected db success!");
                //String sql = "CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR, BIRTHDAY DATE);";
                Statement st = c.createStatement();
                //st.execute(sql);
                String id = "'4'";
                String name = "'test'";
                String birthday = "SYSDATE";
                String sql = "INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ( "+ id + ", "+ name +", "+ birthday + ");";
                st.executeUpdate(sql);
                if (st != null) {
                    st.close();
                }
                c.close();
            }
        } catch(Exception e) {
            System.out.println("ERROR:failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }
    }   
}
