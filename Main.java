import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        //CREO LISTADO PRODUCTOS DISPONIBLES
        List<Producto> listaProductos = new ArrayList<>();
        CuentaSupermercado cuenta = new CuentaSupermercado (listaProductos);
        Validador validador = new Validador(listaProductos);

        //AÑADO PRODUCTOS Y PRECIO
        listaProductos.add(new Producto("Leche", 1.20));
        listaProductos.add(new Producto("Arroz", 1.85));
        listaProductos.add(new Producto("Huevos", 1.75));
        listaProductos.add(new Producto("Tomate", 0.20));
        listaProductos.add(new Producto("Agua", 0.80));
        listaProductos.add(new Producto("Naranjas", 1.55));
        listaProductos.add(new Producto("Pasta", 2.50));
        listaProductos.add(new Producto("Yogurt", 2.25));
        
        System.out.print("LISTA DE PRODUCTOS DISPONIBLES");

        //RECORRE LA LISTA REALIZADA Y LA IMPRIME PARA VER LOS PRODUCTOS QUE HAY
        for (Producto producto : listaProductos){
            System.out.printf(producto.getNombre() + " - " + producto.getPrecio() + "\n");
        }

        //AÑADIR NUM PRODUCTOS
        //System.out.print("Introduce numero de unidades a comprar: ");
        double numProd = validador.validadorNumProd();

        double i=0;
        while (i<numProd){
            String productoEscaneado = validador.validadorProductos();
            System.out.print("Introduce numero de unidades: ");
            Double unidadesProducto = validador.validarUnidadesTotales(i, numProd);
            //scanner.nextLine();
            
            cuenta.addProducto(productoEscaneado, unidadesProducto);
            i=i+unidadesProducto;
        }
        System.out.print(cuenta.imprimirTicket1());
    
    }
}
         