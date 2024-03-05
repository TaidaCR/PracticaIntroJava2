import java.util.Scanner;
public class Validador {
    public Validador(){
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
}
