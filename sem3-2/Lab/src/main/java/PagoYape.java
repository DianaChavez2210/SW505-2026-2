public class PagoYape implements MetodoPago{
    @Override
    public void procesar(double monto){
        System.out.println("Cobrando S/ " + monto + " con yape");
    } 
    @Override
    public String nombre(){ return "Yape"; }
}