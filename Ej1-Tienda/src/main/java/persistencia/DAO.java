package persistencia;

import java.sql.*;

public abstract class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;


    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarBase() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarBase() throws SQLException {
        try{
            if(resultado != null){
                resultado.close();
            }

            if(sentencia != null){
                sentencia.close();
            }

            if(conexion != null){
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void instarModificarEliminar(String sql) throws Exception{
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);

        }catch (Exception ex) {

            //conexion.rollback();
            /*
                Si se produce un error en la ejecución de la sentencia SQL
                se debe hacer un rollback para deshacer los cambios realizados en la base de datos
                y lanzar la excepción para que sea tratada en la capa superior
             */

            /*Descomentar la linea conexion.rollback() si deseo tener en cuenta el rollback
            Correr el siguiente script en Workbench para que se produzca un error en la ejecución de la sentencia SQL

            SET autocommit = 1;
            COMMIT;
             */
            System.out.println("Error en la ejecución de la sentencia SQL");
            throw ex;

        }finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception{
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        }catch (Exception ex) {
            throw ex;
        }
    }
}
