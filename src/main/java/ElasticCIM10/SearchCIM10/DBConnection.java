/**
 * 
 */
package ElasticCIM10.SearchCIM10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * @author weiliu
 *
 */


public class DBConnection {

    /**
     * 3306 is the default port for MySQL in XAMPP. Note both the 
     * MySQL server and Apache must be running. 
     */
	//public static final String url = "jdbc:mysql://192.168.64.2:3306/LIU";
	public static final String url = "jdbc:mysql://localhost/projet_inf203";

    /**
     * The MySQL user.
     */
	public static final  String user = "root";
	//public static final  String user = "LIU";
	

    /**
     * Password for the above MySQL user. If no password has been 
     * set (as is the default for the root user in XAMPP's MySQL),
     * an empty string can be used.
     */
	public static final String password = "";

	
	private static Connection conn = null;
	 
	     static
	     {
	         try
	         {
	             // 1.charge le driver
	             Class.forName("com.mysql.jdbc.Driver");
	             // 2.connexion à la base de données
	             conn = DriverManager.getConnection(url, user, password);
	         }
	         catch (ClassNotFoundException e)
	         {
	             e.printStackTrace();
	         }
	         catch (SQLException e)
	         {
	             e.printStackTrace();
	         }
	     }
	 
	     public static Connection getConnection()
	     {
	         return conn;
	     }
	
}
