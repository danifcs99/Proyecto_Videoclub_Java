
package bbdd;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
    
    static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbName = "proyecto_videoclub";
    static String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
    static String user = "root";
    static String pass = "";
    static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection conexion;
    
    public static void Conectar(){
    	try {
           Class.forName(driver) ;
           conexion = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return conexion;
    }
}
