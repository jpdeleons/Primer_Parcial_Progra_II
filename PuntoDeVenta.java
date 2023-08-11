import java.util.ArrayList;
import java.util.List;

interface ElementoVenta {
    double calcularPrecio();
}

class Producto implements ElementoVenta {
    private String nombre;
    private double precio;
    private String codigoBarras;
    private int cantidadStock;

    public Producto(String nombre, double precio, String codigoBarras, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigoBarras = codigoBarras;
        this.cantidadStock = cantidadStock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", cantidadStock=" + cantidadStock +
                '}';
    }
}

class Servicio implements ElementoVenta {
    private String nombre;
    private String descripcion;
    private double precio;

    public Servicio(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}

class CarritoDeCompras {
    private List<ElementoVenta> elementos;

    public CarritoDeCompras() {
        elementos = new ArrayList<>();
    }

    public void agregarElemento(ElementoVenta elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(ElementoVenta elemento) {
        elementos.remove(elemento);
    }

    public double calcularTotalCompra() {
        double total = 0.0;
        for (ElementoVenta elemento : elementos) {
            total += elemento.calcularPrecio();
        }
        return total;
    }

    public void generarRecibo() {
        System.out.println("Recibo de compra:");
        for (ElementoVenta elemento : elementos) {
            System.out.println(elemento.toString());
        }
        System.out.println("Total: $" + calcularTotalCompra());
    }
}

public class PuntoDeVenta {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Camiseta", 20.99, "123456789", 100);
        Producto producto2 = new Producto("Zapatos", 59.99, "987654321", 50);
        Servicio servicio1 = new Servicio("Limpieza", "Servicio de limpieza a domicilio", 30.0);

        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.agregarElemento(producto1);
        carrito.agregarElemento(producto2);
        carrito.agregarElemento(servicio1);

        carrito.generarRecibo();
    }
}