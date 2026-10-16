public class Main {
    public static void main(String[] args) {
        System.out.println("--- Prueba de Patrón Factory Method ---");
        EmisorComprobante emisorBoleta = new EmisorBoleta();
        emisorBoleta.procesar("001", 100);
        
        EmisorComprobante emisorFactura = new EmisorFactura();
        emisorFactura.procesar("002", 150);

        EmisorComprobante emisorNotaCredito = new EmisorNotaCredito();
        emisorNotaCredito.procesar("003", 50);
    }
}