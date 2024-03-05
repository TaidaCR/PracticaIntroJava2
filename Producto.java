import java.util.HashMap;

public class Producto {
    
    private double precioUnitario;
    private String nombreProducto;
    
    

    public Producto(String nombreProducto, double precioUnitario){
        this.precioUnitario = precioUnitario;
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio(){
        return precioUnitario;
    }

    public void setPrecio(double valor){
        precioUnitario = valor;
    }

    public String getNombre(){
        return nombreProducto;
    }

    public void setNombre(String valor){
        nombreProducto = valor;
    }
}


