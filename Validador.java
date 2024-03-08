import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Validador {
    private List<Producto>listaProductos;

    public Validador(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    //ARREGLAR. SALE EL MENSAJE DOS VECES
    public Double validarUnidadesTotales(Double i, Double numProd){
        Scanner input = new Scanner(System.in);
        Double unidadesProd = 0.0;
        Double unidadesTotales = 0.0;
        boolean siguePidiendo=true;
        
        while(siguePidiendo){
            try{
                System.out.print("Introduce numero de unidades: ");
                unidadesProd=input.nextDouble();
                unidadesTotales=unidadesProd+i;
                siguePidiendo = false;
            }catch(InputMismatchException e){
                System.out.print("El número debe ser un entero. ");
                input.next();
                siguePidiendo = true;
            }
        }
        if (numProd >0 && numProd <500){
            while (unidadesTotales>numProd){
                System.out.print("El número de items excede el declarado. Introduzca un número menor: ");
                unidadesProd = input.nextDouble();
                unidadesTotales=unidadesProd+i;
                input.nextLine();
            }
        }else{
            System.out.print("Por favor introduce un número válido entre 0 y 500");

        }
        return unidadesProd;
    }

    public Double validadorNumProd (){
        Scanner input = new Scanner(System.in);
        int numProd = 0;
        boolean siguePidiendo = true;
        while (siguePidiendo){
            try{
                System.out.print("Introduce número de unidades a comprar: ");
                numProd = input.nextInt();
                siguePidiendo = false;
            }catch (InputMismatchException e){
                System.out.print("El número debe ser un entero. ");
                input.next();
                siguePidiendo = true;
            }
        }
        double numProdDouble = (double) numProd;
        return numProdDouble;
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