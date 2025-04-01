package agenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBaseDatos {
    private static final String URL="jdbc:mysql://localhost:3307/agenda";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    public static Connection getConnection(){
        Connection conexion=null;
        
        try {
            conexion=DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexion establecida");

        } catch (SQLException e) {
            System.out.println("Error en la conexion: "+e.getMessage());
        }
        return conexion;
    }
}
