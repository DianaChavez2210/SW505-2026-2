public class EmisorFactura implements Comprobante {
    @Override
    public void emitir(String rucCliente, double monto) {
        System.out.println("Factura: " + rucCliente + "|" + "Monto: " + monto);
    }
    @Override
    public String tipo() {
        return "Factura";
    }
}