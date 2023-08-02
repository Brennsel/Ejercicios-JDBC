package servicios;

import entidades.Fabricante;
import persistencia.FabricanteDAO;

public class FabricanteServicio {

    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

        try{
            //validaciones

            if (codigo <= 0)
                throw new Exception("Debe indicar el codigo del fabricante");

            if (nombre == null || nombre.trim().isEmpty())
                throw new Exception("Debe indicar el nombre del fabricante");

            //creo el fabricante

            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);

            //guardo el fabricante

            dao.guardarFabricante(fabricante);

        } catch (Exception e){
            throw e;
        }
    }

}
