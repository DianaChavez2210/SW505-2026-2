public class PagoTarjeta implements MetodoPago{
    public void procesar(double monto){
        System.out.printf("Se pago con Tarjeta el valor de" + monto + "soles");
    }
}