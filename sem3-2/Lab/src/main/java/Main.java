public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(new DescuentoVip(), new PagoYape());
        pedido.procesar(200.0); // VIP 15% + Yape
    }
}
