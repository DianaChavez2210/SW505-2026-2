public abstract class EmisorComprobante {
    protected abstract Comprobante crearComprobante();
    
    public void procesar(String rucCliente, double monto) {
        Comprobante comprobante = crearComprobante();
        comprobante.emitir(rucCliente, monto);
    }
}