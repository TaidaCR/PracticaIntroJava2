import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.Random;

public class CuentaSupermercado {
    Scanner scanner = new Scanner(System.in);
    String nombreProd;
    Double unidadesProd;

    //PARA DAR ACCESO A LA ARRAY DE MAIN
    private List<Producto>listaProductos;
    
    HashMap <String, Double> numUnidades = new HashMap<>();

    public CuentaSupermercado(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }


    public double precioTotal(double numUnidades, double precioProducto){
        return numUnidades*precioProducto;
    }

    public void addProducto(String productoEscaneado, Double unidadesProducto){
        boolean siguePidiendo = true;
        while (siguePidiendo==true){
            for (Producto producto : listaProductos){
                String prod1 = producto.getNombre();
                //SI EL PRODUCTO ESTA EN LA LISTAPRODUCTOS LO AÑADE, SI NO LO PIDE DE NUEVO
                if (prod1.equals(productoEscaneado)){
                    if (numUnidades.containsKey(productoEscaneado)){
                        Double unidadesYaAñadidas = numUnidades.get(productoEscaneado);
                        Double sumaUnidades = unidadesYaAñadidas + unidadesProducto;
                        numUnidades.put(productoEscaneado,sumaUnidades);
                    }else{
                        numUnidades.put(productoEscaneado,unidadesProducto);
                    }
                    siguePidiendo=false;
                    break;
                }else{
                    siguePidiendo=true;
                }
            }
        }
    }

    public String imprimirTicket1(){
        StringBuilder sb = new StringBuilder();
        Double precioTotalCuenta = 0.0;
        Double precioTotalUd = 0.0;
        Double unidades = 0.0;
        Double precio = 0.0;
        Random random = new Random ();
        int numeroTicket = random.nextInt(1000);
        sb.append("   \n");
        sb.append("TICKET NUMERO: " +numeroTicket +" \n");
        sb.append("   \n");
        sb.append("Producto       Ud.     PU      Total \n");
        sb.append("------------------------------------\n");
        sb.append("   \n");
        for (Map.Entry<String, Double> entry : numUnidades.entrySet()){
            String nombre = entry.getKey();
            unidades = entry.getValue();
            for (Producto producto: listaProductos){
                if (producto.getNombre().equalsIgnoreCase(nombre)){
                    precio = producto.getPrecio();
                    break;
                }
            }
            precioTotalUd = precio*unidades;
            sb.append(String.format("%-15s%-8.2f%-8.2f%-8.2f\n", nombre, unidades, precio, precioTotalUd));
            precioTotalCuenta = precioTotalCuenta + precioTotalUd;
        }
        sb.append("------------------------------------\n");
        sb.append("Total:                         "+ precioTotalCuenta+"\n");
        sb.append("   \n");
        return sb.toString();
    }
}   


   


