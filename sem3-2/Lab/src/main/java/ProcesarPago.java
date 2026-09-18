public class ProcesarPago {
    public void cobrar(MetodoPago metodo, double monto){
        metodo.procesar(monto);
    }
}