public interface Comprobante {
    void emitir(String rucCliente, double monto);
    String tipo(); 
}