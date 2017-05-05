package SRP.SOLID.SRP.Solucao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClienteRepository {

	private static Connection connection = null;
    //1.jdbc driver name
    private static String SQL_JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    // 2. Database URL, V_UDAY\FRAMEWORK is ServerName and JSF is DataBase name
    private static String URL = "jdbc:sqlserver://V_UDAY;instanceName=FRAMEWORK;databaseName=JSF";
    //3.Database credentials
    private static String USERNAME = "udaykiran";//UserName
    private static String PASSWORD = "Pa55word";//Passwor
//	Ler https://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
	public void AdicionarCliente(Cliente cliente){
		 try {
		        Class.forName(SQL_JDBC_DRIVER);// Register jdbc driver

		        System.out.println("****Connect to Database****");

		        //4. open a connection
		        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		        System.out.println("DataBase connect to: "+ connection.getMetaData().getDriverName());
		        System.out.println("URL: "+ connection.getMetaData().getURL());

		        setConnectionClose();
		        System.out.println("Database Connection Closed");
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.err.println("Exception in getLocalConeection() "+e.getMessage());
		    }
	}
	
	public static void setConnectionClose() throws SQLException {
	    if (connection != null) {
	        connection.close();
	    }
	}
	
}
