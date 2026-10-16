public class MainStrategy {
    public static void main(String[] args) {
        System.out.println("--- Prueba de Patrón Strategy ---");
        double monto = 1000.00;

        Factura general = new Factura(new CalculoGeneral());
        System.out.println("General: " + general.total(monto));
    }
}