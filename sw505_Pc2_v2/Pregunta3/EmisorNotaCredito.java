public class EmisorNotaCredito implements Comprobante {
    @Override
    public void emitir(String rucCliente, double monto) {
        System.out.println("NotaCredito: " + rucCliente + "|" + "Monto: " + monto);
    }
    @Override 
    public String tipo() {
        return "NotaCredito";
    }
}