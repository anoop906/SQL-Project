package dataBase;
import java.sql.Connection;//establish the date connection between eclipse and the SQL server
import java.sql.DriverManager;// insure to which database we want to connect
import java.sql.ResultSet;// it store the result of an query
import java.sql.Statement;// write the query in the eclipse

public class DatabaseConnection {
	static final String DB_url = "jdbc:sqlserver://ANKIT\\SQLEXPRESS:1433;databaseName=java_database;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
	public static void main(String[] args) throws Exception {
		//Calling the class from Project- Referenced Libraries-package-com.microsoft.sqlserver.jdbc; class-SQL Database
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection connection= DriverManager.getConnection(DB_url);
		Statement statement= connection.createStatement();
		String query = "Select id,name,age from javatable";
		ResultSet result= statement.executeQuery(query);
		while(result.next()) {
			int id= result.getInt("id");
			String name = result.getString("name");
			int age = result.getInt("age");
			System.out.println("Id: "+ id+ " "+ "Name: "+ name+" "+"Age: "+age );
			
		}
		result.close();//which will open in last will close in first
		statement.close();
		connection.close();
		

	}

}
