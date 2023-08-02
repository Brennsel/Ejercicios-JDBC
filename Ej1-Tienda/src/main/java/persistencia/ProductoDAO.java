package persistencia;

import entidades.Producto;

import java.util.ArrayList;
import java.util.Collection;

public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {

        try {
            if (producto == null)
                throw new Exception("Debe indicar el producto");

            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)" +
                    "VALUES (" + producto.getCodigo() + ", '" + producto.getNombre() + "', " + producto.getPrecio() + ", " + producto.getCodigo_fabricante() + ")";
            instarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(Producto producto) throws Exception {

        try {
            if (producto == null)
                throw new Exception("Debe indicar el producto que sea modificar");

            String sql = "UPDATE producto SET nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + ", codigo_fabricante = " + producto.getCodigo_fabricante() +
                    " WHERE codigo = " + producto.getCodigo();
            instarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(Producto producto) throws Exception {

        try {
            if (producto == null)
                throw new Exception("Debe indicar el producto que sea eliminar");

            String sql = "DELETE FROM producto " +
                             "WHERE codigo = " + producto.getCodigo();
            instarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    //a) Lista el nombre de todos los productos que hay en la tabla producto.

    public Collection<Producto> listarNombres() throws Exception {
        try {
            String sql = "SELECT nombre FROM producto";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al listar los nombres de los productos");
        }
    }

    //b) Lista los nombres y los precios de todos los productos de la tabla producto.

    public Collection<Producto> listarNombresPrecios() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al listar los nombres y precios de los productos");
        }
    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.

    public Collection<Producto> listarPreciosEntre120y202() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN 120 AND 202";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al listar los productos con precio entre 120 y 202");
        }
    }

    //d) Buscar y listar todos los Portátiles de la tabla producto.

    public Collection<Producto> listarPortatiles() throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%'";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al listar los portátiles");
        }
    }

    //e) Listar el nombre y el precio del producto más barato

    public Collection<Producto> listarProductoMasBarato() throws Exception {
        try {
            String sql = "SELECT nombre, precio FROM producto WHERE precio = (SELECT MIN(precio) FROM producto)";
            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList<>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al listar el producto más barato");
        }
    }

    //Buscar producto por código

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo;
            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error al buscar el producto por código");
        }
    }
}
