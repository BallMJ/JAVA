import java.sql.*;

public class mysqlTableReader {


    public static void connect(){
		
        //Location of database and other parameters to connect to it
        String url = "jdbc:mysql://localhost:3306/javatest";
        String username = "USERNAME";
        String password = "PASSWORD";
        
        System.out.println("Connecting to database...");
        
        
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Database Connected!");
            System.out.println("Database is located at: "+url);
            
            //Getting name of tables in database
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while(rs.next()){
                System.out.println("Table name is: "+rs.getString(3));
            }
            
        }catch (SQLException e){
            throw new IllegalStateException("Cannot connect to the database", e);
        }
        
        
    }
    
    
    public static void main(String[] args) {
        
        connect();
        
    }
    
}
