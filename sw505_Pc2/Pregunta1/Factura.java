
public class Factura {
    private final CalculoGeneral estrategia;
    
    public Factura(CalculoGeneral estrategia) {
        this.estrategia = estrategia;
    }
    
    public double total(double base) {
        double IGV = estrategia.calcularIGV(base);
        double percepcion = estrategia.calcularPercepcion(base);
        return base - IGV - percepcion;
    }
}
