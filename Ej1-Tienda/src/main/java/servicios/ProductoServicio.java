package servicios;

import entidades.Producto;
import persistencia.ProductoDAO;

public class ProductoServicio {

    private ProductoDAO dao;

    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, double precio, int codigoFabricante) throws Exception {

        try{
            //validaciones

            if (nombre == null || nombre.trim().isEmpty())
                throw new Exception("Debe indicar el nombre del producto");

            if (precio <= 0)
                throw new Exception("Debe indicar el precio del producto");

            if (codigoFabricante <= 0)
                throw new Exception("Debe indicar el codigo del fabricante");

            //creo el producto

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigoFabricante);

            //guardo el producto

            dao.guardarProducto(producto);

        } catch (Exception e){
            throw e;

        }
    }



}
