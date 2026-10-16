public class EmisorBoleta implements Comprobante {
    @Override
    public void emitir(String rucCliente, double monto) {
        System.out.println("Boleta: " + rucCliente + "|" + "Monto: " + monto);
    }
    @Override
    public String tipo() {
        return "Boleta";
    }
}