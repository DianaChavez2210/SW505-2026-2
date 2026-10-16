public class CalculoGeneral implements EstrategiaCalculo {
    @Override
    public double calcularIGV(double base) {
        double IGV = 0.18 * base;
        return IGV;
    }

    @Override
    public double calcularPercepcion(double base) {
        double percepcion = 0.02 * base; 
        return percepcion;
    }
        
}