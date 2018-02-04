import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Class.forName("org.hsqldb.jdbcDriver");
	            Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/xdb", "sa", "");
	            if (c != null) {
	                System.out.println("Connected db success!");
	                String sql = "CREATE TABLE TBL_USERS(ID INTEGER, NAME VARCHAR(20), BIRTHDAY DATE);";
	                Statement st = c.createStatement();
	                st.execute(sql);
	                sql = "INSERT INTO TBL_USERS(ID, NAME, BIRTHDAY) VALUES ('1', 'ADMIN', SYSDATE);";
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
