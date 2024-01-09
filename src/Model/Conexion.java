
package Model;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    String url ="jdbc.mysql://localhost:3306/ricos";
    String user="root",password="jacobluis7.";
    Connection con;
    
    public Connection getConnection(){
        try{
    Class.forName("com.mysql.jdbc.Driver");
    con=(Connection)DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}
