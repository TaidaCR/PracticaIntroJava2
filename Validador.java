import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Validador {
    private List<Producto>listaProductos;

    public Validador(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    public Double validarUnidadesTotales(Double i, Double numProd){
        Scanner input = new Scanner(System.in);
        Double unidadesProd = input.nextDouble();
        Double unidadesTotales=unidadesProd+i;
        while (unidadesTotales>numProd){
            System.out.print("El número de items excede el declarado. Introduzca un número menor: ");
            unidadesProd = input.nextDouble();
            unidadesTotales=unidadesProd+i;
            input.nextLine();
        }
        return unidadesProd;
    }

    public String validadorProductos (){
        Scanner input = new Scanner(System.in);
        boolean siguePidiendo = true;
        String productoEscaneado="";
        String prod="";
        while (siguePidiendo==true){
            System.out.print("Introduce nombre del producto escaneado: ");
            productoEscaneado = input.nextLine();

            for (Producto producto : listaProductos){
                if (producto.getNombre().equalsIgnoreCase(productoEscaneado)){
                    prod = producto.getNombre();
                    siguePidiendo=false;
                    break;
                } 
            }
            if (siguePidiendo){
                System.out.print("El producto no está en la lista.");
            }
        }
        
        
        return prod;
        
    }
}
