import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

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

    public void imprimirTicket(){
        for (Map.Entry<String, Double> entry : numUnidades.entrySet()){
            String nombre = entry.getKey();
            Double unidades = entry.getValue();
            String unidadesString = Double.toString(unidades);

            System.out.printf(nombre+"--"+unidadesString+"--"+"\n");
        }
    }
}   

   


