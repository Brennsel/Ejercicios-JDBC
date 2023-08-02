
import entidades.Producto;
import persistencia.ProductoDAO;
import servicios.FabricanteServicio;
import servicios.ProductoServicio;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) throws Exception {

        Scanner leer = new Scanner(System.in);
        ProductoDAO pd = new ProductoDAO();
        int opcion, cod;
        double precio;
        String nombre;

        System.out.println("================================================");
        System.out.println(">>>>>>>>>>>>>>>>>>BD TIENDA<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("------------------------------------------------");
        System.out.println("1. Listar nombre de todos los productos");
        System.out.println("2. Listar nombre y precio de todos los productos");
        System.out.println("3. Listar productos entre $120 y $202");
        System.out.println("4. Listar portatiles");
        System.out.println("5. Listar nombre y precio de producto mas barato");
        System.out.println("6. Ingresar un producto");
        System.out.println("7. Ingresar un fabricante");
        System.out.println("8. Editar un producto");
        System.out.println("9. Eliminar un producto");
        System.out.println("------------------------------------------------");
        System.out.print("Seleccione una opcion a realizar: > ");
        opcion = leer.nextInt();
        System.out.println("------------------------------------------------");


        switch (opcion) {

            case 1:
                System.out.println("Listar nombre de todos los productos\n");

                for (Producto producto : pd.listarNombres()) {
                    if (producto.getNombre() != null) {
                        System.out.println(producto.getNombre());
                    }
                }
                break;

            case 2:
                System.out.println("Listar nombre y precio de todos los productos\n");

                for (Producto producto : pd.listarNombresPrecios()) {
                    if (producto.getNombre() != null) {
                        System.out.println(producto.getNombre() + " - " + producto.getPrecio());
                    }
                }
                break;

            case 3:
                System.out.println("Listar productos entre $120 y $202\n");

                for (Producto producto : pd.listarPreciosEntre120y202()) {
                    if (producto.getNombre() != null) {
                        System.out.println(producto.getNombre() + " - " + producto.getPrecio());
                    }
                }
                break;

            case 4:
                System.out.println("Listar portatiles\n");

                for (Producto producto : pd.listarPortatiles()) {
                    if (producto.getNombre() != null) {
                        System.out.println(producto.getNombre());
                    }
                }
                break;

            case 5:

                System.out.println("Listar nombre y precio de producto mas barato\n");

                for (Producto producto : pd.listarProductoMasBarato()) {
                    if (producto.getNombre() != null) {
                        System.out.println(producto.getNombre() + " - " + producto.getPrecio());
                    }
                }
                break;

            case 6:

                System.out.println("Agregar un producto\n");
                System.out.println("Ingrese el nombre del producto: ");
                nombre = leer.next();
                System.out.println("Ingrese el precio del producto: ");
                precio = leer.nextDouble();
                System.out.println("Ingrese el codigo del fabricante: ");
                cod = leer.nextInt();

                ProductoServicio ps = new ProductoServicio();

                try {
                    ps.crearProducto(nombre, precio, cod);
                } catch (Exception e) {
                    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
                }

                System.out.println("Producto agregado correctamente");
                break;

            case 7:

                System.out.println("Agregar un fabricante\n");
                System.out.print("Ingrese el codigo del fabricante: ");
                cod = leer.nextInt();
                System.out.print("Ingrese el nombre del fabricante: ");
                nombre = leer.next();

                FabricanteServicio fs = new FabricanteServicio();

                try {
                    fs.crearFabricante(cod, nombre);
                } catch (Exception e) {
                    Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
                }

                System.out.println("Fabricante agregado correctamente");
                break;

            case 8:

                System.out.print("Ingrese el codigo del producto que desea modificar: \n");
                cod = leer.nextInt();

                pd.modificarProducto(pd.buscarProductoPorCodigo(cod));

                System.out.println("Producto modificado correctamente");

                break;

            case 9:

                System.out.print("Ingrese el codigo del producto que desea eliminar: \n");
                cod = leer.nextInt();

                pd.eliminarProducto(pd.buscarProductoPorCodigo(cod));

                System.out.println("Producto eliminado correctamente");

                break;

            default:
                System.out.println("Opcion incorrecta");
                break;
        }

    }
}
