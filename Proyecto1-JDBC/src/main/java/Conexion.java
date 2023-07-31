import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://hostname/superheroes";
            Connection connection = DriverManager.getConnection(url, "root", "root");

            System.out.println("Conexión exitosa");

        } catch (SQLException e) {
            System.out.println("Error de conexión");
        }

    }
}
