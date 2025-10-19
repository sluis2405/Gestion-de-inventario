package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Suarez
 */
public class ConexionBD {
    
    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_integrado2?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "Luis240516"; // Reemplaza con tu contraseña real

    // Método para establecer la conexión
    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentar la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el driver JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        Connection prueba = conectar();
        if (prueba != null) {
            System.out.println("💡 La conexión se ha establecido correctamente.");
        } else {
            System.out.println("⚠️ No se pudo establecer la conexión.");
        }
    }
}
