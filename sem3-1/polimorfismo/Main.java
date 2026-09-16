public class Main {
    public static void main(strind[] args){
        MetodoPago pago1 = new PagoYape();
        MetodoPago pago2 = new PagoTarjeta();

        pago1.procesar(monto: 1500);
        pago2.procesar(monto: 12);
    }
}