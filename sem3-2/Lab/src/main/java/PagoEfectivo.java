public class PagoEfectivo implements MetodoPago{
    @Override
    public void procesar(double monto){
        System.out.println("Cobrando S/ " + monto + " con efectivo");
    } 
    @Override
    public String nombre(){ return "Efectivo"; }
}