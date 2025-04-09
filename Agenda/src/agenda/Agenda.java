package agenda;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Agenda {

    public static void main(String[] args) {
        //primero obtenemos la conexion
        Connection conexion = ConexionBaseDatos.getConnection();
        
        //compruebo si se ha realizado
        if (conexion != null) {
            
            //hago las consultas
            try {
                //insertar
                String insertar = "INSERT INTO contacto (Nombre, Telefono) VALUES ('Amin',112345688)";
                String consulta_sql = "SELECT * FROM contacto";
                Statement stmt = conexion.createStatement();
                System.out.println(stmt.execute(insertar) ?  "Error al insertar":"Se ha insertado correctamente");
                ResultSet resultado = stmt.executeQuery(consulta_sql);
                
                //mostar datos de la base de datos
                while (resultado.next()) {
                    System.out.println("Id: " + resultado.getInt("id"));
                    System.out.println("Nombre: " + resultado.getNString("Nombre"));
                    System.out.println("Telefono: " + resultado.getInt("Telefono"));
                }
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
