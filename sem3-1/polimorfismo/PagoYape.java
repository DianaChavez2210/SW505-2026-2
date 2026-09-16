public class PagoYape implements MetodoPago{
    public void procesar(double monto){
        System.out.printf("Se pago con Yape el valor de" + monto + "soles");
    }
}