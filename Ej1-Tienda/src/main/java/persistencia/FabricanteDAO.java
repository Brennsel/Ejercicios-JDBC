package persistencia;

import entidades.Fabricante;

public final class FabricanteDAO extends DAO {

    public void guardarFabricante(Fabricante fabricante) throws Exception {

        try{
            if(fabricante == null)
                throw new Exception("Debe indicar el fabricante");

            String sql = "INSERT INTO fabricante (codigo, nombre)" +
                        "VALUES (" + fabricante.getCodigo() + ", '" + fabricante.getNombre() + "')";
            instarModificarEliminar(sql);

    } catch (Exception e){
            throw e;
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {

        try{
            if(fabricante == null)
                throw new Exception("Debe indicar el fabricante que sea modificar");

            String sql = "UPDATE fabricante SET nombre = '" + fabricante.getNombre() +
                            "' WHERE codigo = " + fabricante.getCodigo();
            instarModificarEliminar(sql);

    } catch (Exception e){
            throw e;
        }
    }

    public void eliminarFabricante(Fabricante fabricante) throws Exception {

        try{
            if(fabricante == null)
                throw new Exception("Debe indicar el fabricante que sea eliminar");

            String sql = "DELETE FROM fabricante " +
                            "WHERE codigo = " + fabricante.getCodigo();
            instarModificarEliminar(sql);

    } catch (Exception e){
            throw e;
        }
    }


}
